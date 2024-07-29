
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem1;

import java.io.*;

/**
 *
 * @author David
 */
public class FitnessClasses extends Class implements Serializable {
    private String classID;
    private String activity;
    private double price;
    private double duration;
    private int numberOfClasses;
    private static int nextClassID = 1;

    private static int CLASS_ID_DEFAULT = 0;
    private static int CLASS_CAPACITY_DEFAULT = 0;
    private static double PRICE_DEFAULT = 0.0;
    private static double DURATION_DEFAULT = 0.0;
    private static int NUMBEROFCLASSES_DEFAULT = 0;

    public FitnessClasses(String classId, String activity, double price, double duration, int numberOfClasses) {
        this.classID = classId;
        this.activity = activity;
        this.price = price;
        this.duration = duration;
        this.numberOfClasses = numberOfClasses;
    }

    public FitnessClasses(String classId, int id) {
        this.classID = classId;
        nextClassID = Math.max(nextClassID, id + 1);
    }

    public String getclassId() {
        return classID;
    }

    public String getActivity() {
        return activity;
    }

    public double getPrice() {
        return price;
    }

    public double getDuration() {
        return duration;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public String toString() {
        return "\n" + super.toString() + "\nActivity: " + getActivity() +
                "\nClass Price: " + getPrice() + "\nClass Duration: " + getDuration() +
                "\nNumber of Classes available: " + getNumberOfClasses();
    }

    public static int getNextClassID() {
        return nextClassID;
    }

    public static void setNextMemID(int nextClassID) {
        FitnessClasses.nextClassID = nextClassID;
    }

}
