package com.luigimoro.climbingreport.pojo.climb;

import java.io.Serializable;

/**
 * Created by javaknight on 14/07/16.
 */
public class Pitch implements Serializable {

    private int pitchNumber;
    private String pitchDescription;
    private String belayDescription;
    private String pythonsNumber;
    private String spitsNumber;
    private String protectionLevel;
    private String rockQuality;
    private String hours;
    private String minutes;
    private String difficulty;
    private String pitchLength;

    public String getPitchDescription() {
        return pitchDescription;
    }

    public void setPitchDescription(String pitchDescription) {
        this.pitchDescription = pitchDescription;
    }

    public String getBelayDescription() {
        return belayDescription;
    }

    public void setBelayDescription(String belayDescription) {
        this.belayDescription = belayDescription;
    }

    public String getPythonsNumber() {
        return pythonsNumber;
    }

    public void setPythonsNumber(String pythonsNumber) {
        this.pythonsNumber = pythonsNumber;
    }

    public String getSpitsNumber() {
        return spitsNumber;
    }

    public void setSpitsNumber(String spitsNumber) {
        this.spitsNumber = spitsNumber;
    }

    public String getProtectionLevel() {
        return protectionLevel;
    }

    public void setProtectionLevel(String protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    public String getRockQuality() {
        return rockQuality;
    }

    public void setRockQuality(String rockQuality) {
        this.rockQuality = rockQuality;
    }

    public int getPitchNumber() {
        return pitchNumber;
    }

    public void setPitchNumber(int pitchNumber) {
        this.pitchNumber = pitchNumber;
    }


    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getPitchLength() {
        return pitchLength;
    }

    public void setPitchLength(String pitchLength) {
        this.pitchLength = pitchLength;
    }
}
