package com.example.week9fm5cc5.helpers;

import java.util.*;
import java.lang.*;

public class GenerateAscii {

    /*
     |-------------------------------
     | Sum
     |-------------------------------
    */
    public int sum(String string) {
        int sum = 0;

        for (int i=0; i < string.length(); i++) {
            int asciiValue = string.charAt(i);
            sum += asciiValue;
        }

        return sum;
    }
}
