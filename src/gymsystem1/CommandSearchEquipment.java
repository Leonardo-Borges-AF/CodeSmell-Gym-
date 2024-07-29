package gymsystem1;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class CommandSearchEquipment implements Command {
    private EquipmentManager equipmentManager;
    private ArrayList<Equipment> equipList;
    private String searchName;
    private boolean found;

    public CommandSearchEquipment(EquipmentManager equipmentManager, ArrayList<Equipment> equipList, String searchName, boolean found) {
        this.equipmentManager = equipmentManager;
        this.equipList = equipList;
        this.searchName = searchName;
        this.found = found;
    }

    @Override
    public void execute() {
        equipmentManager.searchEquipment(equipList, searchName, found);
    }
}