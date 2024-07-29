package gymsystem1;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class CommandDisplayEquipment implements Command {
    private EquipmentManager equipmentManager;
    private ArrayList<Equipment> equipList;
    private JTextArea area;

    public CommandDisplayEquipment(EquipmentManager equipmentManager, ArrayList<Equipment> equipList, JTextArea area) {
        this.equipmentManager = equipmentManager;
        this.equipList = equipList;
        this.area = area;
    }

    @Override
    public void execute() {
        equipmentManager.displayEquipment(equipList, area);
    }
}