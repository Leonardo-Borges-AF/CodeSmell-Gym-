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
public class Class implements Serializable {
  private String className;
  private int classCapacity;
  private int placesTaken;

  private static final int DEFAULT_CAPACITY = 0;
  private static final int TEST_CAPACITY = 2;

  public void cancelClass() {
    if (placesTaken > 0)
      placesTaken--;
  }

  public boolean takeClass() {
    if (placesTaken < classCapacity) {
      placesTaken++;
      return true;
    } else
      return false;
  }

  public int calculatePlacesLeft() {
    return classCapacity - placesTaken;
  }

  public Class(String title, int totCapacity) {
    this.className = title;
    this.classCapacity = placesTaken;
    placesTaken = 0;
  }

  public Class(String className) {
    this(className, TEST_CAPACITY); // temp, for purposes of testing the class system
  }

  public Class() {
    this("Title unknown", DEFAULT_CAPACITY);
  }

  public void setClassName(String cName) {
    this.className = cName;
  }

  public void setClassCapacity(int totCapacity) {
    this.classCapacity = totCapacity;
  }

  public String getClassName() {
    return className;
  }

  public int getClassCapacity() {
    return classCapacity;
  }

  public int getPlacesTaken() {
    return placesTaken;
  };

  public String toString() {
    return "\n Class Name: " + getClassName() + "\n Total Capacity: " + getClassCapacity() +
        "\n Places Taken: " + getPlacesTaken();
  }
}
