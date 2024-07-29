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
public class Employee extends Person implements Serializable {
    private static int nextEmpID = 1; // Initialize nextEmpID as a static variable
    private final int employeeID;
    private final String employeeAddress;
    private final int employeePhoneNo;

    public Employee(String nm, int a, char g, String eeAddr, int pNo) {
        super(nm, a, g);
        this.employeeID = nextEmpID++; // Assign the value of nextEmpID to employeeID and increment nextEmpID
        this.employeeAddress = eeAddr;
        this.employeePhoneNo = pNo;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public int getEmployeePhoneNo() {
        return employeePhoneNo;
    }

    public String toString() {
        return "\n" + super.toString() + "\nEmployee ID: " + getEmployeeID() + "\nEmployee Address: "
                + getEmployeeAddress() +
                "\nEmployee Phone No: " + getEmployeePhoneNo();
    }
}
