package com.atacelen.listview;

import android.graphics.Bitmap;
/*
    A Singleton class is a class that can only hold one instance. Therefore all Singleton instances refer to the same Singleton object.
    The constructor of the Singleton class is private and can only be accessed from inside the class.
    We call the "getInstance" method to instead of the constructor.
    We use this class to carry Bitmaps from one activity to the other. All Singleton instances refer to the same Singleton object.
 */
public class Singleton {
    private Bitmap chosenFoodImage;
    private static Singleton singleton;

    private Singleton(){

    }

    public Bitmap getChosenFoodImage() {
        return chosenFoodImage;
    }

    public void setChosenFoodImage(Bitmap chosenFoodImage) {
        this.chosenFoodImage = chosenFoodImage;
    }

    public static Singleton getInstance() {
        if(singleton == null){
            singleton = new Singleton();
        }

        return singleton;
    }
}
