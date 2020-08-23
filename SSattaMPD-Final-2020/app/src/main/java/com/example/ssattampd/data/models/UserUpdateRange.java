package com.example.ssattampd.data.models;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import java.io.Serializable;

public class UserUpdateRange implements Serializable {

    private static final int DEFAULT_MIN = 8;
    private static final int DEFAULT_MAX = 20;
    private int min;
    private int max;

    public UserUpdateRange() {
        min = DEFAULT_MIN;
        max = DEFAULT_MAX;
    }

    public UserUpdateRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
