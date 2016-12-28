package com.apex;

import com.apex.aggr.Aggragator;
import com.apex.aggr.AggragatorSet;

import java.util.*;

/**
 * Created by akm on 12/21/16.
 */
public class Adinfo {
    private enum Publisher {twitter, facebook, yahoo, google, bing, amazon};
    private enum Advertiser {starbucks, safeway, mcdonalds, macys, taco_bell, walmart, khols, san_diego_zoo, pandas, jack_in_the_box, tomatina, ron_swanson};
    private enum location {N, LREC, SKY, AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID};
    private static final RandomEnum<Publisher> p = new RandomEnum<Publisher>(Publisher.class);
    private static final RandomEnum<Advertiser> a = new RandomEnum<Advertiser>(Advertiser.class);
    private static final RandomEnum<location> l = new RandomEnum<location>(location.class);

    public static void main(String[] args) {
        String keys_user[] = {"publisher","location"};
        String metrics_user[] = {"0"};
        Aggragator ag = new Aggragator(0,keys_user,metrics_user);
        AggragatorSet agset =  new AggragatorSet();
        agset.addAggregator(ag);
        List<Adobject> lo = new ArrayList<Adobject>();
        for (int i = 0; i < 10; i++) {
            Adobject ao = new Adobject(p.random().toString(), a.random().toString(), l.random().toString());
            ao.setCost();
            ao.setImpressions();
            ao.setClick();
            //ao.disp();
            agset.processItem(ao);
        }
         /*
        Aggre ag = new Aggre();
        System.out.println("Enter the location");
        Scanner scan = new Scanner(System.in);
        String location = scan.nextLine();
        System.out.println("Enter the advertiser");
        String advrt = scan.nextLine();
        System.out.println("Choose the option :1)Group by location\n 2)Group by advertiser\n 3)Group by location and advertiser 4)exit");
        int c;
        while (true) {
            c = scan.nextInt();
            switch (c) {
                case 1:
                    int count = ag.location_wise(lo, location);
                    System.out.println(count);
                    break;
                case 2:
                    int count1 = ag.location_wise(lo, advrt);
                    System.out.println(count1);
                    break;
                case 3:
                    int count2 = ag.location_wise_advertiser(lo, location, advrt);
                    System.out.println(count2);
                    break;
                case 4:
                    break;
            }
        }*/
    }


    private static class RandomEnum<E extends Enum> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }
}