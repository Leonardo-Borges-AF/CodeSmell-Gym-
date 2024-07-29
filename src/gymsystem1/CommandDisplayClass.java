package gymsystem1;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class CommandDisplayClass implements Command {
    private ClassManager classManager;
    private ArrayList<FitnessClasses> fitClassList;
    private JTextArea area;

    public CommandDisplayClass(ClassManager classManager, ArrayList<FitnessClasses> fitClassList, JTextArea area) {
        this.classManager = classManager;
        this.fitClassList = fitClassList;
        this.area = area;
    }

    @Override
    public void execute() {
        classManager.displayClass(fitClassList, area);
    }
}