package gymsystem1;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EquipmentManager {
    boolean valid;
    double equipmentSize;

    public void addEquipment(ArrayList<Equipment> equipList) {
        String name = JOptionPane.showInputDialog(null, "Please enter name of new Equipment");
        String description = JOptionPane.showInputDialog(null, "Please enter a description of Equipment");

        do {
            valid = false;
            String equipmentSizeAsString = JOptionPane.showInputDialog(null, "Please Enter Equipment Size");

            try {

                equipmentSize = (double) Double.parseDouble(equipmentSizeAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + equipmentSizeAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch
        } while (!valid);

        equipList.add(new Equipment(name, description, equipmentSize));
    }

    public void removeEquipment(ArrayList<Equipment> equipList) {
        String removeEquipment = JOptionPane.showInputDialog(null, "Please enter the Equipment you wish to remove");

        for (int i = 0; i < equipList.size(); i++) {
            if (removeEquipment.equals(equipList.get(i).getequipmentName())) {
                equipList.remove(i);
                JOptionPane.showMessageDialog(null, removeEquipment + " has been removed from the Equipment List");
            }
        }
    }

    public void displayEquipment(ArrayList<Equipment> equipList, JTextArea area) {
        area.setText("Equipment List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (Equipment e : equipList) {
            area.append(e.toString() + "\n");
        }

        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

    public void searchEquipment(ArrayList<Equipment> equipList, String searchName, boolean found) {
        searchName = JOptionPane.showInputDialog("Please enter the equipment name that you are looking for: \n");
        for (int i = 0; i < equipList.size(); i++) {
            if (searchName.equals(equipList.get(i).getequipmentName())) {
                System.out.println("Found!" + equipList.get(i).getequipmentName());
                found = true;
                System.out.println("Details: " + "Equipment Name: " + equipList.get(i).getequipmentName()
                        + "\nEquipment Description: " + equipList.get(i).getequipmentDescription()
                        + "\nEquipment Size: " + equipList.get(i).getequipmentSize());
            }
        }
    }

}
