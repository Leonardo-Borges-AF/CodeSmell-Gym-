package gymsystem1;

import java.util.ArrayList;

public class CommandRemoveEmployee implements Command {
    private EmployeeManager employeeManager;
    private ArrayList<Employee> empList;

    public CommandRemoveEmployee(EmployeeManager employeeManager, ArrayList<Employee> empList) {
        this.employeeManager = employeeManager;
        this.empList = empList;
    }

    @Override
    public void execute() {
        employeeManager.removeEmployee(empList);
    }
}