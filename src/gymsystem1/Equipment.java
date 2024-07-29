/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem1;

import java.io.Serializable;

/**
 *
 * @author David
 */
public class Equipment implements Serializable {
    private String equipmentName;
    private String equipmentDescription;
    private double equipmentSize;
    private static double Default = 0.0;

    public Equipment(String equipmentName, String equipmentDescription, double equipmentSize) {
        this.equipmentName = equipmentName;
        this.equipmentDescription = equipmentDescription;
        this.equipmentSize = equipmentSize;
    }

    public Equipment(String equipmentName) {
        this(equipmentName, "unknown", Default);
    }

    public Equipment() {
        this("unknown", "unknown", Default);
    }

    public String getequipmentName() {
        return equipmentName;
    }

    public String getequipmentDescription() {
        return equipmentDescription;
    }

    public double getequipmentSize() {
        return equipmentSize;
    }

    public void setequipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public void setequipmentSize(double equipmentSize) {
        this.equipmentSize = equipmentSize;
    }

    public String toString() {
        return "\nequipmentName of equipment: " + getequipmentName() + "\nEquipment equipmentDescription: "
                + getequipmentDescription() +
                "\nSize of equipment: " + getequipmentSize();
    }

}
