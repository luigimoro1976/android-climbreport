package com.luigimoro.climbingreport.pojo.climb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by javaknight on 14/07/16.
 */
public class Route implements Serializable {

    private String routeName;
    private int routeType;
    private String mountainChain;
    private String closestVillage;
    private String clesestRefugee;
    private int maxDifficulty;
    private int mandatotyDifficulty;
    private String routeStart;

    private List<Pitch> pitchList;

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getRouteType() {
        return routeType;
    }

    public void setRouteType(int routeType) {
        this.routeType = routeType;
    }

    public String getMountainChain() {
        return mountainChain;
    }

    public void setMountainChain(String mountainChain) {
        this.mountainChain = mountainChain;
    }

    public String getClosestVillage() {
        return closestVillage;
    }

    public void setClosestVillage(String closestVillage) {
        this.closestVillage = closestVillage;
    }

    public String getClesestRefugee() {
        return clesestRefugee;
    }

    public void setClosestRefugee(String clesestRefugee) {
        this.clesestRefugee = clesestRefugee;
    }

    public int getMaxDifficulty() {
        return maxDifficulty;
    }

    public void setMaxDifficulty(int maxDifficulty) {
        this.maxDifficulty = maxDifficulty;
    }

    public int getMandatotyDifficulty() {
        return mandatotyDifficulty;
    }

    public void setMandatotyDifficulty(int mandatotyDifficulty) {
        this.mandatotyDifficulty = mandatotyDifficulty;
    }

    public List<Pitch> getPitchList() {

        if (pitchList == null) {
            pitchList = new ArrayList<>();
        }
        return pitchList;
    }

    public void setPitchList(List<Pitch> pitchList) {
        this.pitchList = pitchList;
    }

    public void addPitch(Pitch pitch) {
        getPitchList().add(pitch);
    }

    public String getRouteStart() {
        return routeStart;
    }

    public void setRouteStart(String routeStart) {
        this.routeStart = routeStart;
    }
}
