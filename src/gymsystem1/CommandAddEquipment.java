package gymsystem1;

import java.util.ArrayList;

public class CommandAddEquipment implements Command {
    private EquipmentManager equipmentManager;
    private ArrayList<Equipment> equipList;

    public CommandAddEquipment(EquipmentManager equipmentManager, ArrayList<Equipment> equipList) {
        this.equipmentManager = equipmentManager;
        this.equipList = equipList;
    }

    @Override
    public void execute() {
        equipmentManager.addEquipment(equipList);
    }
}