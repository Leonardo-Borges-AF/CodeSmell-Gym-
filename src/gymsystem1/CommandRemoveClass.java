package gymsystem1;

import java.util.ArrayList;

public class CommandRemoveClass implements Command {
    private ClassManager classManager;
    private ArrayList<FitnessClasses> fitClassList;

    public CommandRemoveClass(ClassManager classManager, ArrayList<FitnessClasses> fitClassList) {
        this.classManager = classManager;
        this.fitClassList = fitClassList;
    }

    @Override
    public void execute() {
        classManager.removeClass(fitClassList);
    }
}