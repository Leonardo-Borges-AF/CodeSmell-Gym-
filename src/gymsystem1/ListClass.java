package gymsystem1;

import java.util.ArrayList;

public class ListClass {

    ArrayList<Member> memList;
    ArrayList<Employee> empList;
    ArrayList<Equipment> equipList;
    ArrayList<FitnessClasses> fitClassList;
    ArrayList<MemberClass> classList;

    public ListClass(ArrayList<Member> memList, ArrayList<Employee> empList, ArrayList<Equipment> equipList,
            ArrayList<FitnessClasses> fitClassList, ArrayList<MemberClass> classList) {
        this.memList = memList;
        this.empList = empList;
        this.equipList = equipList;
        this.fitClassList = fitClassList;
        this.classList = classList;
    }

}
