/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem1;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author David
 */
public class GymScreen extends JFrame implements ActionListener {

    JMenu fileMenu, memberMenu, employeeMenu, equipmentMenu, fitnessClassMenu, classMenu;
    ArrayList<Member> memList;
    ArrayList<Employee> empList;
    ArrayList<Equipment> equipList;
    ArrayList<FitnessClasses> fitClassList;
    ArrayList<MemberClass> classList;
    ListClass listClass;
    JTextArea area;

    String searchName;
    boolean found = false;

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;
    private static final int FRAME_X_ORIGIN = 250;
    private static final int FRAME_Y_ORIGIN = 200;

    private JLabel response;
    private MemberManager memberManager;
    private EmployeeManager employeeManager;
    private EquipmentManager equipmentManager;
    private ClassManager classManager;
    private DataManager dataManager;

    private final Map<String, Command> commandMap; // hashmap

    public static void main(String args[]) throws IOException {
        GymScreen win = new GymScreen();
        win.setVisible(true);
    }

    /**
     * Creates a new instance of <code> GymScreen </code>.
     */
    public GymScreen() {

        Container contentPane;

        // Setting the Frame Properties
        setTitle("O' Connor's GYM");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        memberManager = new MemberManager();
        employeeManager = new EmployeeManager();
        equipmentManager = new EquipmentManager();
        classManager = new ClassManager();
        dataManager = new DataManager();

        /**
         * Creating menus and their menu items Adding the menu&menuItems to the
         * menu bar
         */
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        createFileMenu();
        bar.add(fileMenu);
        createMemberMenu();
        bar.add(memberMenu);
        createEmployeeMenu();
        bar.add(employeeMenu);
        createEquipmentMenu();
        bar.add(equipmentMenu);
        createFitnessClassMenu();
        bar.add(fitnessClassMenu);
        createClassMenu();
        bar.add(classMenu);

        memList = new ArrayList<Member>();
        empList = new ArrayList<Employee>();
        equipList = new ArrayList<Equipment>();
        fitClassList = new ArrayList<FitnessClasses>();
        classList = new ArrayList<MemberClass>();
        listClass = new ListClass(memList, empList, equipList, fitClassList, classList);
        area = new JTextArea();

        // Criando o mapeamento de comandos
        commandMap = new HashMap<>();
        commandMap.put("Load All Data", new CommandData(dataManager, listClass));
        commandMap.put("Save All Data", new CommandsaveAllData(dataManager, listClass));

        commandMap.put("Add a New Member", new CommandAddMember(memberManager, listClass.memList));
        commandMap.put("Remove Member", new CommandRemoveMember(memberManager, listClass.memList));
        commandMap.put("Display All Members", new CommandDisplayMember(memberManager, listClass.memList, area));
        commandMap.put("Search a Member", new CommandSearchMember(memberManager, listClass.memList, searchName, found));
        commandMap.put("Sort Members by Name", new CommandSortMember(memberManager, listClass.memList));

        commandMap.put("Add a New Employee", new CommandAddEmployee(employeeManager, listClass.empList));
        commandMap.put("Remove Employee", new CommandRemoveEmployee(employeeManager, listClass.empList));
        commandMap.put("Display All Employees", new CommandDisplayEmployee(employeeManager, listClass.empList, area));
        commandMap.put("Search an Employee", new CommandSearchEmployee(employeeManager, listClass.empList, searchName, found));
        commandMap.put("Sort Employees by Name", new CommandSortEmployee(employeeManager, listClass.empList));

        commandMap.put("Add New Equipment", new CommandAddEquipment(equipmentManager, listClass.equipList));
        commandMap.put("Remove Equipment", new CommandRemoveEquipment(equipmentManager, listClass.equipList));
        commandMap.put("Display All Equipment", new CommandDisplayEquipment(equipmentManager, listClass.equipList, area));
        commandMap.put("Search Equipment", new CommandSearchEquipment(equipmentManager, listClass.equipList, searchName, found));

        commandMap.put("Add a New Class", new CommandAddClass(classManager, listClass.fitClassList));
        commandMap.put("Remove Fitness Class", new CommandRemoveClass(classManager, listClass.fitClassList));
        commandMap.put("Display All Classes", new CommandDisplayClass(classManager, listClass.fitClassList, area));
        commandMap.put("Search a Class", new CommandSearchClass(classManager, listClass.fitClassList, searchName, found));

        commandMap.put("Add a Member to Class", new CommandmemberToClass(classManager, listClass.fitClassList, listClass.memList, listClass.classList));
        commandMap.put("Display All Class Members", new CommandDisplayClassMembers(classManager, listClass.classList, area));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createFileMenu() {
        fileMenu = new JMenu("File");
        JMenuItem item = new JMenuItem("Load All Data");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Save All Data");
        item.addActionListener(this);
        fileMenu.add(item);

        fileMenu.addSeparator(); // ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); // EXITS THE PROGRAM
        item.addActionListener(this);
        fileMenu.add(item);

    }

    private void createMemberMenu() {
        memberMenu = new JMenu("Member");
        JMenuItem item = new JMenuItem("Add a New Member");
        item.addActionListener(this);
        memberMenu.add(item);

        item = new JMenuItem("Remove Member");
        item.addActionListener(this);
        memberMenu.add(item);

        item = new JMenuItem("Display All Members");
        item.addActionListener(this);
        memberMenu.add(item);

        item = new JMenuItem("Search a Member");
        item.addActionListener(this);
        memberMenu.add(item);

        item = new JMenuItem("Sort Members by Name");
        item.addActionListener(this);
        memberMenu.add(item);

        memberMenu.addSeparator(); // ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); // EXITS THE PROGRAM
        item.addActionListener(this);
        memberMenu.add(item);

    }

    private void createEmployeeMenu() {
        employeeMenu = new JMenu("Employee");
        JMenuItem item = new JMenuItem("Add a New Employee");
        item.addActionListener(this);
        employeeMenu.add(item);

        item = new JMenuItem("Remove Employee");
        item.addActionListener(this);
        employeeMenu.add(item);

        item = new JMenuItem("Display All Employees");
        item.addActionListener(this);
        employeeMenu.add(item);

        item = new JMenuItem("Search an Employee");
        item.addActionListener(this);
        employeeMenu.add(item);

        item = new JMenuItem("Sort Employees by Name");
        item.addActionListener(this);
        employeeMenu.add(item);

        employeeMenu.addSeparator(); // ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); // EXITS THE PROGRAM
        item.addActionListener(this);
        employeeMenu.add(item);

    }

    private void createEquipmentMenu() {
        equipmentMenu = new JMenu("Equipment");
        JMenuItem item = new JMenuItem("Add New Equipment");
        item.addActionListener(this);
        equipmentMenu.add(item);

        item = new JMenuItem("Remove Equipment");
        item.addActionListener(this);
        equipmentMenu.add(item);

        item = new JMenuItem("Display All Equipment");
        item.addActionListener(this);
        equipmentMenu.add(item);

        item = new JMenuItem("Search Equipment");
        item.addActionListener(this);
        equipmentMenu.add(item);

        item = new JMenuItem("Sort Equipment by Name");
        item.addActionListener(this);
        equipmentMenu.add(item);

        equipmentMenu.addSeparator(); // ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); // EXITS THE PROGRAM
        item.addActionListener(this);
        equipmentMenu.add(item);
    }

    private void createFitnessClassMenu() {
        fitnessClassMenu = new JMenu("Fitness Class");
        JMenuItem item = new JMenuItem("Add a New Class");
        item.addActionListener(this);
        fitnessClassMenu.add(item);

        item = new JMenuItem("Remove Fitness Class");
        item.addActionListener(this);
        fitnessClassMenu.add(item);

        item = new JMenuItem("Display All Classes");
        item.addActionListener(this);
        fitnessClassMenu.add(item);

        item = new JMenuItem("Search a Class");
        item.addActionListener(this);
        fitnessClassMenu.add(item);

        item = new JMenuItem("Sort Classes by Name");
        item.addActionListener(this);
        fitnessClassMenu.add(item);

        fitnessClassMenu.addSeparator(); // ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); // EXITS THE PROGRAM
        item.addActionListener(this);
        fitnessClassMenu.add(item);

    }

    private void createClassMenu() {
        classMenu = new JMenu("Class");
        JMenuItem item = new JMenuItem("Add a Member to Class");
        item.addActionListener(this);
        classMenu.add(item);

        item = new JMenuItem("Display All Class Members");
        item.addActionListener(this);
        classMenu.add(item);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String commandKey = e.getActionCommand();
        Command command = commandMap.get(commandKey);
        if (command != null) {
            command.execute();
        } else {
            System.exit(0);
        }
    }

    /*
     * public void actionPerformed(ActionEvent e) {
     * String c = e.getActionCommand();
     * if (c.equalsIgnoreCase("Load All Data")) {
     * dataManager.loadAllData(listClass);
     * } else if (c.equalsIgnoreCase("Save All Data")) {
     * dataManager.saveAllData(listClass);
     * }
     * 
     * else if (c.equalsIgnoreCase("Add a New Member")) {
     * memberManager.addMember(listClass.memList);
     * } else if (c.equalsIgnoreCase("Remove Member")) {
     * memberManager.removeMember(listClass.memList);
     * } else if (c.equalsIgnoreCase("Display All Members")) {
     * memberManager.displayMember(listClass.memList, area);
     * } else if (c.equalsIgnoreCase("Search a Member")) {
     * memberManager.searchMember(listClass.memList, searchName, found);
     * } else if (c.equalsIgnoreCase("Sort Members by Name")) {
     * memberManager.sortMember(listClass.memList);
     * }
     * 
     * else if (c.equalsIgnoreCase("Add a New Employee")) {
     * employeeManager.addEmployee(listClass.empList);
     * } else if (c.equalsIgnoreCase("Remove Employee")) {
     * employeeManager.removeEmployee(listClass.empList);
     * } else if (c.equalsIgnoreCase("Display All Employees")) {
     * employeeManager.displayEmployee(listClass.empList, area);
     * } else if (c.equalsIgnoreCase("Search an Employee")) {
     * employeeManager.searchEmployee(listClass.empList, searchName, found);
     * } else if (c.equalsIgnoreCase("Sort Employees by Name")) {
     * employeeManager.sortEmployee(listClass.empList);
     * }
     * 
     * else if (c.equalsIgnoreCase("Add New Equipment")) {
     * equipmentManager.addEquipment(listClass.equipList);
     * } else if (c.equalsIgnoreCase("Remove Equipment")) {
     * equipmentManager.removeEquipment(listClass.equipList);
     * } else if (c.equalsIgnoreCase("Display All Equipment")) {
     * equipmentManager.displayEquipment(listClass.equipList, area);
     * } else if (c.equalsIgnoreCase("Search Equipment")) {
     * equipmentManager.searchEquipment(listClass.equipList, searchName, found);
     * }
     * // else if (c.equalsIgnoreCase("Sort Equipment by Name")) {
     * // equipmentManager.sortEquipment(equipList);
     * // }
     * 
     * else if (c.equalsIgnoreCase("Add a New Class")) {
     * classManager.addClass(listClass.fitClassList);
     * } else if (c.equalsIgnoreCase("Remove Fitness Class")) {
     * classManager.removeClass(listClass.fitClassList);
     * } else if (c.equalsIgnoreCase("Display All Classes")) {
     * classManager.displayClass(listClass.fitClassList, area);
     * } else if (c.equalsIgnoreCase("Search a Class")) {
     * classManager.searchClass(listClass.fitClassList, searchName, found);
     * }
     * // else if (c.equalsIgnoreCase("Sort Classes by Name")) {
     * // sortClass();
     * // }
     * else if (c.equalsIgnoreCase("Add a Member to Class")) {
     * classManager.memberToClass(listClass.fitClassList, listClass.memList,
     * listClass.classList);
     * } else if (c.equalsIgnoreCase("Display All Class Members")) {
     * classManager.displayClassMembers(listClass.classList, area);
     * } else {
     * System.exit(0);
     * }
     * 
     * }
     */
}
