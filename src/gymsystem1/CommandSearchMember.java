package gymsystem1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CommandSearchMember implements Command {
    private MemberManager memberManager;
    private ArrayList<Member> memList;

    public CommandSearchMember(MemberManager memberManager, ArrayList<Member> memList, String searchName, boolean found) {
        this.memberManager = memberManager;
        this.memList = memList;
    }

    @Override
    public void execute() {
        String searchName = JOptionPane.showInputDialog("Please enter the member's name that you are looking for: \n");
        boolean found = false;
        memberManager.searchMember(memList, searchName, found);
    }
}