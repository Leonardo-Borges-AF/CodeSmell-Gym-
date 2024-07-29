package gymsystem1;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmployeeManager {
    boolean valid;
    char gender;
    int age, phone, classCapacity;
    double memPrice;

    public void addEmployee(ArrayList<Employee> empList) {
        String name = promptForInput("Please enter new employee's name");
        int age = promptForInt("Please Enter Employee's age");
        char gender = promptForChar("Enter gender:");
        String address = promptForInput("Please Enter Employee's address");
        int phone = promptForInt("Please Enter Employee's phone number");

        empList.add(new Employee(name, age, gender, address, phone));
    }

    private String promptForInput(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    private int promptForInt(String message) {
        boolean valid = false;
        int value = 0;

        do {
            String input = JOptionPane.showInputDialog(null, message);
            try {
                value = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                showMessage(input + " is invalid\nPlease enter digits only");
            }
        } while (!valid);

        return value;
    }

    private char promptForChar(String message) {
        return JOptionPane.showInputDialog(null, message).charAt(0);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void removeEmployee(ArrayList<Employee> empList) {
        String removeName = JOptionPane.showInputDialog(null, "Please enter employees name you wish to remove");

        for (int i = 0; i < empList.size(); i++) {
            if (removeName.equals(empList.get(i).getName())) {
                empList.remove(i);
                JOptionPane.showMessageDialog(null, removeName + " has been removed from the Employees List");
            }
        }
    }

    public void displayEmployee(ArrayList<Employee> empList, JTextArea area) {
        area.setText("Employee List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (Employee e : empList) {
            area.append(e.toString() + "\n");
        }

        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

    public void searchEmployee(ArrayList<Employee> empList, String searchName, boolean found) {
        searchName = JOptionPane.showInputDialog("Please enter the employees name that you are looking for: \n");
        for (int i = 0; i < empList.size(); i++) {
            if (searchName.equals(empList.get(i).getName())) {
                System.out.println("Found!" + empList.get(i).getName());
                found = true;
                System.out.println("Details: " + "Employee ID: "
                        + empList.get(i).getEmployeeID() + "\nEmployee's Name: "
                        + empList.get(i).getName() + "\nEmployee's Age: "
                        + empList.get(i).getAge() + "\nEmployee's Gender: "
                        + empList.get(i).getGender()
                        + "\nEmployee's Address: "
                        + empList.get(i).getEmployeeAddress()
                        + "\nEmployee's Phone Number: "
                        + empList.get(i).getEmployeePhoneNo());
            }
        }
    }

    public void sortEmployee(ArrayList<Employee> empList) {
        Set<Employee> sortEmployee = new TreeSet<Employee>(Person.NameComparator);
        sortEmployee.addAll(empList);
        System.out.println("\nSorted by name\n" + sortEmployee);
    }



}
