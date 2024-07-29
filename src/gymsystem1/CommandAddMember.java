package gymsystem1;

import java.util.ArrayList;

public class CommandAddMember implements Command {
    private MemberManager memberManager;
    private ArrayList<Member> memList;

    public CommandAddMember(MemberManager memberManager, ArrayList<Member> memList) {
        this.memberManager = memberManager;
        this.memList = memList;
    }

    @Override
    public void execute() {
        memberManager.addMember(memList);
    }
}
