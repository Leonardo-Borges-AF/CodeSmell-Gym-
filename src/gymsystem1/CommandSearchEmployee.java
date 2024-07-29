package gymsystem1;

import java.util.ArrayList;

public class CommandSearchEmployee implements Command {
    private EmployeeManager employeeManager;
    private ArrayList<Employee> empList;

    public CommandSearchEmployee(EmployeeManager employeeManager, ArrayList<Employee> empList, String searchName, boolean found) {
        this.employeeManager = employeeManager;
        this.empList = empList;
    }

    @Override
    public void execute() {
        String searchName = "";
        boolean found = false;
        employeeManager.searchEmployee(empList, searchName, found);
    }
}
