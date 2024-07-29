package gymsystem1;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class CommandDisplayMember implements Command {
    private MemberManager memberManager;
    private ArrayList<Member> memList;
    private JTextArea area;

    public CommandDisplayMember(MemberManager memberManager, ArrayList<Member> memList, JTextArea area) {
        this.memberManager = memberManager;
        this.memList = memList;
        this.area = area;
    }

    @Override
    public void execute() {
        memberManager.displayMember(memList, area);
    }
}