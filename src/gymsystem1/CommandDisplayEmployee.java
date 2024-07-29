package gymsystem1;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class CommandDisplayEmployee implements Command {
    private EmployeeManager employeeManager;
    private ArrayList<Employee> empList;
    private JTextArea area;

    public CommandDisplayEmployee(EmployeeManager employeeManager, ArrayList<Employee> empList, JTextArea area) {
        this.employeeManager = employeeManager;
        this.empList = empList;
        this.area = area;
    }

    @Override
    public void execute() {
        employeeManager.displayEmployee(empList, area);
    }
}