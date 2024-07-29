package gymsystem1;

import java.util.ArrayList;

public class CommandAddEmployee implements Command {
    private EmployeeManager employeeManager;
    private ArrayList<Employee> empList;

    public CommandAddEmployee(EmployeeManager employeeManager, ArrayList<Employee> empList) {
        this.employeeManager = employeeManager;
        this.empList = empList;
    }

    @Override
    public void execute() {
        employeeManager.addEmployee(empList);
    }
}
