package com.luigimoro.climbingreport.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javaknight on 20/07/16.
 */
public class Constants {

    public static final String ROUTE_TYPE_EXTRA = "route_type";

    public static final String PITCH_NEW_EXTRA = "pitch_extra";

    public static final String ROUTE_STATUS = "route_status";


    public static final int ACTIVITY_CODE_ADD_PITCH = 110;

    public static final String ROUTE_CLASSIC_TYPE = "Classica";


    static final List<String> CLASSIC_ROUTE_GRADE_LIST = new ArrayList<String>() {{

        add("I");
        add("II");
        add("III");
        add("III+");
        add("IV-");
        add("IV");
        add("IV+");
        add("V-");
        add("V");
        add("V+");
        add("VI-");
        add("VI");
        add("VI+");
        add("VII-");
        add("VII");
        add("VII+");
        add("VIII");
    }};

    static final List<String> SPORT_ROUTE_GRADE_LIST = new ArrayList<String>() {{
        add("4a");
        add("4b");
        add("4c");
        add("5a");
        add("5b");
        add("5c");
        add("6a");
        add("6a+");
        add("6b");
        add("6b+");
        add("6c");
        add("6c+");
        add("7a");
    }};


    public static List<String> getClassicRouteGradeList() {
        return CLASSIC_ROUTE_GRADE_LIST;
    }


    public static List<String> getSportRouteGradeList() {
        return SPORT_ROUTE_GRADE_LIST;
    }
}
