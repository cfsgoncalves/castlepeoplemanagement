/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author claudio
 */
public class Settings {
    public static float studentPrice = 0;
    public static float adultPrice = 0;
    public static float childPrice = 0;
    public static float agedPrice = 0;

    public float getStudentPrice() {
        return studentPrice;
    }

    public void setStudentPrice(float studentPrice) {
        this.studentPrice = studentPrice;
    }

    public float getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(float adultPrice) {
        Settings.adultPrice = adultPrice;
    }

    public float getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(float childPrice) {
        Settings.childPrice = childPrice;
    }

    public static float getAgedPrice() {
        return agedPrice;
    }

    public static void setAgedPrice(float agedPrice) {
        Settings.agedPrice = agedPrice;
    }
   
}
