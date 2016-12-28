package com.apex.aggr;

import com.apex.Adobject;

import java.util.ArrayList;
import java.util.List;

public class AggragatorSet {
    List<Aggragator> aggragatorList = new ArrayList<Aggragator>();

    public void addAggregator(Aggragator aggr) {
        aggragatorList.add(aggr);
    }

    public void processItem(Adobject info) {
        for (Aggragator aggr : aggragatorList) {
            Pair<List, List> current = aggr.getGroup(info);
            aggr.aggregate(current.getSecond(), info);
            System.out.println(current.getFirst().toString());
            System.out.println(current.getSecond().toString());
        }
    }
}
