package gymsystem1;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class CommandDisplayClassMembers implements Command {
    private ClassManager classManager;
    private ArrayList<MemberClass> classList;
    private JTextArea area;

    public CommandDisplayClassMembers(ClassManager classManager, ArrayList<MemberClass> classList, JTextArea area) {
        this.classManager = classManager;
        this.classList = classList;
        this.area = area;
    }

    @Override
    public void execute() {
        classManager.displayClassMembers(classList, area);
    }
}