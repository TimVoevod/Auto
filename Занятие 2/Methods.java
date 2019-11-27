package com.company;

import java.util.Map;

public class Methods {
    public int minNumb(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public boolean oddEven(int a) {
        boolean b;
        if (a % 2 == 0) {
            b = true;
        } else b = false;
        return b;
    }

    public double secondExp(int a) {
        double b = Math.pow(a, 2);
        return b;
    }

    public double thirdExp(int a) {
        double b = Math.pow(a, 3);
        return b;
    }
}
