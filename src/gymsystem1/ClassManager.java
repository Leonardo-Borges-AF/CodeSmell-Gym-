package gymsystem1;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class ClassManager {
    boolean valid;
    int classCapacity;
    double price, duration;
    int noOfClasses;

    public void addClass(ArrayList<FitnessClasses> fitClassList) {
        String className = promptForInput("Please enter new fitness class name");
        String activity = promptForInput("Please enter activity");

        int classCapacity = promptForInt("Please enter class capacity");
        double price = promptForDouble("Please enter class price");
        double duration = promptForDouble("Please enter class duration");
        int numberOfClasses = promptForInt("Please enter number of classes");

        fitClassList.add(new FitnessClasses(className, activity, price, duration, numberOfClasses));
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

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void removeClass(ArrayList<FitnessClasses> fitClassList) {
        String removeClass = JOptionPane.showInputDialog(null, "Please enter the Class name you wish to remove");

        for (int i = 0; i < fitClassList.size(); i++) {
            if (removeClass.equals(fitClassList.get(i).getClassName())) {
                fitClassList.remove(i);
                JOptionPane.showMessageDialog(null, removeClass + " has been removed from the Class List");
            }
        }

    }

    public void displayClass(ArrayList<FitnessClasses> fitClassList, JTextArea area) {
        area.setText("Fitness Classes List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (FitnessClasses c : fitClassList) {
            area.append(c.toString() + "\n");
        }

        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

    public void searchClass(ArrayList<FitnessClasses> fitClassList, String searchName, boolean found) {
        searchName = JOptionPane.showInputDialog("Please enter the class name that you are looking for: \n");
        for (int i = 0; i < fitClassList.size(); i++) {
            if (searchName.equals(fitClassList.get(i).getClassName())) {
                System.out.println("Found!" + fitClassList.get(i).getClassName());
                found = true;
                System.out.println("Details: " + "Class Name: " + fitClassList.get(i).getClassName()
                        + "\nClass Capacity: " + fitClassList.get(i).getClassCapacity() + "\nClass Places Taken: "
                        + fitClassList.get(i).getPlacesTaken()
                        + "\nClass Activity: " + fitClassList.get(i).getActivity() + "\nClass Price: "
                        + fitClassList.get(i).getPrice() + "\nClass Duration: " + fitClassList.get(i).getDuration()
                        + "\nNumber of Classes: " + fitClassList.get(i).getNumberOfClasses());
            }
        }
    }

    public void memberToClass(ArrayList<FitnessClasses> fitClassList, ArrayList<Member> memList,
            ArrayList<MemberClass> classList) {
        // pick a member
        int memIdx = Integer.parseInt(JOptionPane.showInputDialog("Enter a member number "
                + " between 1 and " + memList.size()));
        // pick a class
        int classIdx = Integer.parseInt(JOptionPane.showInputDialog("Enter a class number "
                + " between 1 and " + fitClassList.size()));

        // create a new rental object
        MemberClass member = new MemberClass(memList.get(memIdx - 1),
                fitClassList.get(classIdx - 1), "Thursday", 7.5);
        fitClassList.get(classIdx - 1).takeClass();
        // add the member to the class list
        classList.add(member);
    }

    public void displayClassMembers(ArrayList<MemberClass> classList, JTextArea area) {
        // note that this gives a very poor display layout
        // instead of using r.toString(), a better-organised display would be needed
        area.setText("Class List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (MemberClass r : classList) {
            area.append(r.toString());
            if (r.getMClass() instanceof GameClass) {
                area.append(" for Class Name: " + ((GameClass) (r.getMClass())).getClassName() + "\n\n");
            }
        }
        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

}
