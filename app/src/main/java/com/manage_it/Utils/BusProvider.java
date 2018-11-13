package com.manage_it.Utils;

import com.squareup.otto.Bus;

public class BusProvider {

    private static Bus BUS;

    public static Bus getInstance() {
        if(BUS == null){
            BUS = new Bus();
        }
        return BUS;
    }

    private BusProvider(){

    }
}


