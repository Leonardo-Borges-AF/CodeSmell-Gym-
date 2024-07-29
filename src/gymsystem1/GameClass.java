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
public class GameClass extends Class implements Serializable {
    private int age;

    public GameClass(String title, int age) {
        super(title);
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + " Age: " + age;
    }
}
