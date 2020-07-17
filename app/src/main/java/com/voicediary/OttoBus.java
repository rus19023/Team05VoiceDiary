package com.voicediary;

import com.squareup.otto.Bus;

/**
 * Created by albertopalomarrobledo on 11/4/18.
 */

public class OttoBus {

    private static Bus bus;

    public static Bus getBus(){
        if(bus == null){
            bus = new Bus();
        }
        return bus;
    }
}