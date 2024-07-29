package gymsystem1;

import java.util.ArrayList;

public class CommandmemberToClass implements Command {
    private ClassManager classManager;
    private ArrayList<FitnessClasses> fitClassList;
    private ArrayList<Member> memList;
    private ArrayList<MemberClass> classList;

    public CommandmemberToClass(ClassManager classManager, ArrayList<FitnessClasses> fitClassList, ArrayList<Member> memList, ArrayList<MemberClass> classList) {
        this.classManager = classManager;
        this.fitClassList = fitClassList;
        this.memList = memList;
        this.classList = classList;
    }

    @Override
    public void execute() {
        classManager.memberToClass(fitClassList, memList, classList);
    }
}