package gymsystem1;

import java.util.ArrayList;

public class CommandSearchClass implements Command {
    private ClassManager classManager;
    private ArrayList<FitnessClasses> fitClassList;
    private String searchName;
    private boolean found;

    public CommandSearchClass(ClassManager classManager, ArrayList<FitnessClasses> fitClassList, String searchName, boolean found) {
        this.classManager = classManager;
        this.fitClassList = fitClassList;
        this.searchName = searchName;
        this.found = found;
    }

    @Override
    public void execute() {
        classManager.searchClass(fitClassList, searchName, found);
    }
}