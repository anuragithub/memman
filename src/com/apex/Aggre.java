package com.apex;

import java.util.Iterator;
import java.util.List;

/**
 * Created by akm on 12/21/16.
 */
public class Aggre {
    public int location_wise_advertiser(List<Adobject> a,String loc,String advert){
        Iterator<Adobject> liit = a.iterator();
        int count = 0;
        while (liit.hasNext()) {
            if(liit.next().location.toString().equals(loc)) {

            if(liit.next().advertiser.toString().equals(advert)){
                count ++;
            }
        }

    }
        return count;
    }
    public int location_wise(List<Adobject> a,String loc){
        Iterator<Adobject> liit = a.iterator();
        int count = 0;
        while (liit.hasNext()) {
            if(liit.next().location.toString().equals(loc)) {
                    count ++;
            }

        }
        return count;
    }
    public int advetiser_wise(List<Adobject> a,String advrt){
        Iterator<Adobject> liit = a.iterator();
        int count = 0;
        while (liit.hasNext()) {
            if(liit.next().advertiser.toString().equals(advrt)) {
                count ++;
            }

        }
        return count;
    }
}
