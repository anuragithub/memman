package com.apex.aggr;

import com.apex.Adobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aggragator {
    private final String[] keys;
    private final String[] metrics;
    private final int id;
    private Map<List, List> aggrMap = new HashMap<List, List>();

    public Aggragator(int id, String[] keys, String[] metrics) {
        this.id = id;
        this.keys = keys;
        this.metrics = metrics;
    }

    public Pair<List, List> getGroup(Adobject info) {
        List key = new ArrayList(keys.length + 1);
        key.add(id);
        for (String keyStr : keys) {
            if (keyStr.equals("publisher")) {
                key.add(info.getPublisher());
            } else if (keyStr.equals("location")) {
                key.add(info.getLocation());
            }/* else if (keyStr.equals("advertiser")) {
                key.add(info.getAdvertiser());
            }*/
        }
        List vals = null;
        for(int i=0;i<key.size();i++){
        vals = aggrMap.get(key.get(i));
        if (vals == null) {
            vals = new ArrayList(metrics.length);
            // 0 -> cost , 1 -> impressions, 2 -> clicks
            vals.add(info.getCost());
            vals.add(info.getImpressions());
            vals.add(info.isClick()? 1 : 0);
            aggrMap.put(key, vals);
        }}
        return new Pair<List, List>(key, vals);
    }

    // impressions:sum,impressions:min,impressions:max

    public void aggregate(List vals, Adobject info) {
        vals.set(0, (Double)vals.get(0) + info.getCost());
        vals.set(1, (Integer)vals.get(1) + info.getImpressions());
        vals.set(2, (Integer)vals.get(2) + (info.isClick()?1 : 0));
    }
}
