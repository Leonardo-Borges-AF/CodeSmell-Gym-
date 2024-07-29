package gymsystem1;

public class CommandsaveAllData implements Command{
    private final DataManager dataManager;
    private final ListClass listclass;

    public CommandsaveAllData(DataManager dataManager, ListClass listclass ){
        this.dataManager = dataManager;
        this.listclass = listclass;
    }

    @Override
    public void execute(){
        dataManager.saveAllData(listclass);
    }

}

