package gymsystem1;


public class CommandData implements Command{
    private final DataManager dataManager;
    private final ListClass listclass;

    public CommandData(DataManager dataManager, ListClass listclass ){
        this.dataManager = dataManager;
        this.listclass = listclass;
    }

    @Override
    public void execute(){
        dataManager.loadAllData(listclass);
    }

}

