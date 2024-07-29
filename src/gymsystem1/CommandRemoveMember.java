package gymsystem1;

import java.util.ArrayList;

public class CommandRemoveMember implements Command {
    private MemberManager memberManager;
    private ArrayList<Member> memList;

    public CommandRemoveMember(MemberManager memberManager, ArrayList<Member> memList) {
        this.memberManager = memberManager;
        this.memList = memList;
    }

    @Override
    public void execute() {
        memberManager.removeMember(memList);
    }
}