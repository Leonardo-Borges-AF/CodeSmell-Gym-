package gymsystem1;

import java.util.ArrayList;

public class CommandAddClass implements Command {
    private ClassManager classManager;
    private ArrayList<FitnessClasses> fitClassList;

    public CommandAddClass(ClassManager classManager, ArrayList<FitnessClasses> fitClassList) {
        this.classManager = classManager;
        this.fitClassList = fitClassList;
    }

    @Override
    public void execute() {
        classManager.addClass(fitClassList);
    }
}