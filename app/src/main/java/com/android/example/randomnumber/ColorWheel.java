package com.android.example.randomnumber;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Doondi on 21/06/2016.
 */
public class ColorWheel {

    private String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7", // light gray
            "#daa520", // goldenrod
            "#808080", // grey
            "#cd5c5c", // indianred
            "#f0e68c", // khaki
            "#f08080", // lightcoral
            "#e0ffff", // lightcyan
            "#ffdab9" // peachpuff
    };


    public int getColor(){
        String color;

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);
        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }


}
