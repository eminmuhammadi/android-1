package com.example.week9fm5cc5.helpers;

import java.util.*;
import java.lang.*;

public class ReplaceCharacters {

    /*
     |-------------------------------
     | Generate
     | FM5CC5
     | f => m , F => M
     | 5 => c, 5 => C, (no logic)
     | c => c, C => C, (no logic)
     | c => 5, C => 5
     |-------------------------------
    */
    public String generate(String string) {

        String updatedString = string
                .replace("f", "m")
                .replace("F", "M")
                .replace("c", "5")
                .replace("C", "5");

        return updatedString;
    }
}
