package gymsystem1;

import java.util.ArrayList;

public class CommandSortMember implements Command {
    private MemberManager memberManager;
    private ArrayList<Member> memList;

    public CommandSortMember(MemberManager memberManager, ArrayList<Member> memList) {
        this.memberManager = memberManager;
        this.memList = memList;
    }

    @Override
    public void execute() {
        memberManager.sortMember(memList);
    }
}