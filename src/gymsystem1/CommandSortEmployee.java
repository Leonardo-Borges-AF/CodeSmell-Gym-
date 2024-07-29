package gymsystem1;

import java.util.ArrayList;

public class CommandSortEmployee implements Command {
    private EmployeeManager employeeManager;
    private ArrayList<Employee> empList;

    public CommandSortEmployee(EmployeeManager employeeManager, ArrayList<Employee> empList) {
        this.employeeManager = employeeManager;
        this.empList = empList;
    }

    @Override
    public void execute() {
        employeeManager.sortEmployee(empList);
    }
}