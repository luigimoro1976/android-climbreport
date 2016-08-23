package com.luigimoro.climbingreport;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.luigimoro.climbingreport.pojo.climb.Route;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    List<Route> routeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initRouteList();


        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, getRouteArray()));


    }




    String[] getRouteArray() {

        int arraySize = routeList.size();

        String[] array = new String[arraySize];

        int a = 0;
        for (Route elem: routeList) {
            array[a] = new String(elem.getRouteName());
            a++;
        }

        return array;


    }


    private void initRouteList() {

        if (routeList == null) {
            routeList = new ArrayList<>();
        }

        Route route1 = new Route();
        Route route2 = new Route();
        Route route3 = new Route();
        Route route4 = new Route();
        Route route5 = new Route();
        Route route6 = new Route();
        Route route7 = new Route();
        Route route8 = new Route();
        Route route9 = new Route();
        Route route10 = new Route();
        Route route11 = new Route();
        Route route12 = new Route();
        Route route13 = new Route();

        route1.setRouteName("Route 1");
        route2.setRouteName("Route 2");
        route3.setRouteName("Route 3");
        route4.setRouteName("Route 4");
        route5.setRouteName("Route 5");
        route6.setRouteName("Route 6");
        route7.setRouteName("Route 7");
        route8.setRouteName("Route 8");
        route9.setRouteName("Route 9");
        route10.setRouteName("Route 10");
        route11.setRouteName("Route 11");
        route12.setRouteName("Route 12");
        route13.setRouteName("Route 13");

        routeList.add(route1);
        routeList.add(route2);
        routeList.add(route3);
        routeList.add(route4);
        routeList.add(route5);
        routeList.add(route6);
        routeList.add(route7);
        routeList.add(route8);
        routeList.add(route9);
        routeList.add(route10);
        routeList.add(route11);
        routeList.add(route12);
        routeList.add(route13);
    }
}
