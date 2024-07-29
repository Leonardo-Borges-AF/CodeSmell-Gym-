/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymsystem1;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author t00130990
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private char gender;

    public Person() {
        setName("unknown");
        setAge(0);
        setGender('U');
    }

    public Person(String nm, int a, char g) {
        setName(nm);
        setAge(a);
        setGender(g);
    }

    public Person(String nm) {
        setName(nm);
    }

    public void setName(String nm) {
        name = nm;
    }

    public String getName() {
        return name;
    }

    public void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }

    public void setGender(char g) {
        gender = g;
    }

    public char getGender() {
        return gender;
    }

    public static Comparator<Person> NameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareToIgnoreCase(p2.getName());
        }
    };

    public String toString() {
        return "First Name:" + getName() + "\nAge:" + getAge() + "\nGender:" + getGender();
    }

}
