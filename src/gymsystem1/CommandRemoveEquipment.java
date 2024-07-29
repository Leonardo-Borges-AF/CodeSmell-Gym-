package gymsystem1;

import java.util.ArrayList;

public class CommandRemoveEquipment implements Command {
    private EquipmentManager equipmentManager;
    private ArrayList<Equipment> equipList;

    public CommandRemoveEquipment(EquipmentManager equipmentManager, ArrayList<Equipment> equipList) {
        this.equipmentManager = equipmentManager;
        this.equipList = equipList;
    }

    @Override
    public void execute() {
        equipmentManager.removeEquipment(equipList);
    }
}