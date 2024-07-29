package gymsystem1;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemberManager extends Member {
    boolean valid;
    char gender;
    int age, phone, classCapacity;
    double memPrice;

    public void addMember(ArrayList<Member> memList) {
        String name = promptForInput("Please enter new member's name");
        int age = promptForInt("Please Enter Member age");
        char gender = promptForChar("Enter gender:");
        String address = promptForInput("Please Enter Member's address");
        int phone = promptForInt("Please Enter Member's phone number");
        String email = promptForInput("Please enter new member's email address");
        String memType = promptForInput("Please enter Membership Type");
        double memPrice = promptForDouble("Please enter Membership Price");
        String startDate = promptForInput("Please enter Membership Start Date in format dd/mm/yyyy");
        String finishDate = promptForInput("Please enter Membership Finish Date in format dd/mm/yyyy");

        memList.add(new Member(name, age, gender, address, phone, email, memType, memPrice, startDate, finishDate));
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

    private double promptForDouble(String message) {
        boolean valid = false;
        double value = 0.0;

        do {
            String input = JOptionPane.showInputDialog(null, message);
            try {
                value = Double.parseDouble(input);
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

    public void removeMember(ArrayList<Member> memList) {
        String removeName = JOptionPane.showInputDialog(null, "Please enter the Member's name you wish to remove");

        for (int i = 0; i < memList.size(); i++) {
            if (removeName.equals(memList.get(i).getName())) {
                memList.remove(i);
                JOptionPane.showMessageDialog(null, removeName + " has been removed from the Members List");
            }
        }
    }

    public void displayMember(ArrayList<Member> memList, JTextArea area) {
        area.setText("Member List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (Member m : memList) {
            area.append(m.toString() + "\n");
        }
        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

    public void searchMember(ArrayList<Member> memList, String searchName, boolean found) {
        searchName = JOptionPane.showInputDialog("Please enter the members name that you are looking for: \n");
        for (int i = 0; i < memList.size(); i++) {
            if (searchName.equals(memList.get(i).getName())) {
                System.out.println("Found!" + memList.get(i).getName());
                found = true;
                System.out.println("Details: " + "Member ID: " + memList.get(i).getMemberID() + "\nMember's Name: "
                        + memList.get(i).getName() + "\nMember's Age: " + memList.get(i).getAge()
                        + "\nMember's Gender: " + memList.get(i).getGender()
                        + "\nMember's Address: " + memList.get(i).getMemberAddress() + "\nMember's Phone Number: "
                        + memList.get(i).getMemberPhoneNo() + "\nMember's Email Address: "
                        + memList.get(i).getMemberEmail() + "\nMembership Type: " + memList.get(i).getMemberType()
                        + "\nMembership Price: " + memList.get(i).getMembershipPrice() + "\nMembership Start Date: "
                        + memList.get(i).getStartDate() + "\nMembership Finish Date: "
                        + memList.get(i).getFinishDate());
            }
        }
        if (!found) {
            System.out.printf(searchName + " is not in your list of Members");
        }
    }

    public void sortMember(ArrayList<Member> memList) {
        Set<Member> sortMember = new TreeSet<Member>(Person.NameComparator);
        sortMember.addAll(memList);
        System.out.println("\nSorted by name\n" + sortMember);
    }

}
