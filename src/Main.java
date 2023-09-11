// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import Abstraction.Chess.Pawn;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


interface Address{
    void getStreetName();
    void getCity();
    void getState();
}



class Counter{
    static int empId = 0;
    static int projectId = 0;
    static int roleId = 0;

    int getEmpId(){
        return ++empId;
    }

    int getProjectId(){
        return ++projectId;
    }

    int getUniqueRoleId(){
        return ++roleId;
    }
}

class Project extends Counter{
    private final String title;
    private final String desc;
    private int id;

    Project(String title,String desc){
        this.id = getProjectId();
        this.title = title;
        this.desc = desc;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "\nProject Id : "+id+"\nProject Title : "+title+"\nProject Description : "+desc+"\n";
    }

}

class Employee extends Counter implements Address {
    private int id;
    private String name;
    private int age;
    private String street;
    private String city;
    private String state;
    private ArrayList<Project> projects;
    private Role role;


    Scanner scanner = new Scanner(System.in);


    Employee(Role role){
        assignId();
        getName();
        getAge();
        getStreetName();
        getCity();
        getState();
        projects = new ArrayList<>();
        setRole(role);
    }



    ArrayList<Project> getProject(){
        return this.projects;
    }

    public void getStreetName(){
        System.out.println("Enter street name : ");
        street = scanner.nextLine();
    }

    public void getCity(){
        System.out.println("Enter city name : ");
        city = scanner.nextLine();
    }

    public void getState(){
        System.out.println("Enter state name : ");
        state = scanner.nextLine();
    }

    void assignId(){
        id = getEmpId();
    }

    void getName(){
        System.out.println("Enter employee name : ");
        name = scanner.nextLine();
    }

    void getAge(){
        System.out.println("Enter employee age : ");
        age = scanner.nextInt();
        scanner.nextLine();
    }

    int getId(){
        return id;
    }

    void currentStatus(){
        System.out.println("Not assigned any role");
    }

    void setProjects(Project project){
        projects.add(project);
    }

    void setRole(Role role){
        this.role = role;
    }

    @Override
    public String toString() {
        return "\nId : "+id+"\nName : "+name+"\nAge : "+age+"\nRole : "+role+"\nProjects : "+projects;
    }
}

interface RoleInterface{
    void roleId();
    void roleTitle();
    void roleDescription();
}

class Role extends Counter implements RoleInterface{
    private String roleTitle;
    private String roleDescription;
    private int roleId;
    Scanner scanner = new Scanner(System.in);

    Role(){
        roleId();
        roleTitle();
        roleDescription();
    }

    public void roleId(){
        this.roleId = getUniqueRoleId();
    }

    public void roleTitle(){
        System.out.println("Enter role title : ");
        this.roleTitle = scanner.nextLine();
    }

    public void roleDescription(){
        System.out.println("Enter role description : ");
        this.roleDescription = scanner.nextLine();
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public int getRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return "Role Id : "+roleId+" Role Title : "+roleTitle;
    }
}

//class Developer extends Employee{
//
//    Developer(){
//        super();
//    }
//
//    void currentStatus(){
//        System.out.println("I'm a Developer");
//    }
//}
//

//class Manager extends  Employee{
//
//    Manager(){
//        super();
//    }
//
//    void currentStatus(){
//        System.out.println("I'm a Manager");
//    }
//}


//class Parent{
//    void method1(){
//        System.out.println("Method 1");
//    }
//}
//
//class Child1 extends Parent{
//    void method2(){
//        System.out.println("Method 2");
//    }
//    void method3(){
//        System.out.println("Method 3");
//    }
//
//}
//
//
//class Main{
//    public static void main(String[] args) {
//        Parent p = new Child1();
//        p.method2();
//        if(p instanceof Child1){
//            p.met
//        }
//    }
//}

public class Main {
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Project> projects = new ArrayList<>();
    static ArrayList<Role> roles = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    static void initializeProjects(){
        String[] projectNames = new String[]{"Mobile","Web","Cyber Security","UI/UX","DevOps","Full Stack"};

        for(int projectCounter = 0;projectCounter<6;projectCounter++){
            projects.add(new Project(projectNames[projectCounter],"Sample description"));
        }

    }

    static int checkIfProjectIdIsValid(int projectId){
        int projectCounter = 0;
        for(Project project:projects){
            if(project.getId() == projectId)
                return projectCounter;
            projectCounter++;
        }
        return -1;
    }

    static int checkIfEmployeeExists(int employeeId){
        int empCounter = 0;
        for(Employee employee:employees){
            if(employee.getId() == employeeId)
                return empCounter;
            empCounter++;
        }
        return -1;
    }

    static void addEmployee(){
        System.out.println("Select a role : ");
        if(roles.isEmpty()){
            System.out.println("No roles added. Add role first");
            return;
        }
        for(var role : roles){
            System.out.println("Role id : "+role.getRoleId()+" Role Title : "+role.getRoleTitle());
        }
        System.out.println("Enter role id : ");
        int selectedRoleId = scanner.nextInt();
        scanner.nextLine();

        Role selectedRole = null;

        for(var role : roles){
            if(role.getRoleId() == selectedRoleId){
                selectedRole = role;
                break;
            }
        }

        Employee employee = new Employee(selectedRole);
        employees.add(employee);


//        switch (choice){
//            case 1:{
//                Employee developer = new Developer();
//                employees.add(developer);
//                break;
//            }
//            case 2:{
//                Employee manager = new Manager();
//                employees.add(manager);
//                break;
//            }
//        }
    }

    static void addProject(){
        System.out.println("Enter project title : ");
        String title = scanner.nextLine();
        System.out.println("Enter project description");
        String desc = scanner.nextLine();
        projects.add(new Project(title,desc));
    }

    static void addNewRole(){
        roles.add(new Role());
    }

    static void assignProjectToAnEmployee(){
        System.out.println("Enter employee id : ");
        int empId = scanner.nextInt();
        int checkingEmployee = checkIfEmployeeExists(empId);
        if(checkingEmployee == -1){
            System.out.println("Invalid employee id");
            return;
        }


        System.out.println("Enter project id : ");
        int projectId = scanner.nextInt();
        int checkingProject = checkIfProjectIdIsValid(projectId);
        if(checkingProject == -1){
            System.out.println("Invalid project id");
            return;
        }



        if(checkingProject != -1 && checkingEmployee != -1){
            for(var project:projects){
                if(projectId == project.getId()){
                    employees.get(checkingEmployee).setProjects(project);
                    break;
                }
            }
        }
    }

    static void showEmployeesProject(){
        System.out.println("Enter employee id : ");
        int empId = scanner.nextInt();
        int checkingEmployee = checkIfEmployeeExists(empId);
        if(checkingEmployee != -1){

            for(var employee:employees){
                if(employee.getId() == empId){
                    System.out.println("Employee Details");
                    System.out.println(employee);
                }
            }
        }
        else{
            System.out.println("Invalid employee id");
        }
    }






    public static void main(String[] args) {
        initializeProjects();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the below options : ");
        while(true){
            System.out.println(
                    "1. Add an employee\n" +
                    "2. Add a project\n" +
                    "3. Assign a project to an employee\n" +
                    "4. Show all projects\n" +
                    "5. Show employees projects\n"+
                    "6. Show all employees\n"+
                    "7. Add new role\n"+
                    "8. Show all roles\n"+
                    "0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:{
                    System.exit(0);
                }
                case 1:{
                    addEmployee();
                    break;
                }
                case 2:{
                    addProject();
                    break;
                }
                case 3:{
                    assignProjectToAnEmployee();
                    break;
                }
                case 4:{
                    System.out.println(projects);
                    break;
                }
                case 5:{
                    showEmployeesProject();
                    break;
                }
                case 6:{
                    if(employees.isEmpty())
                        System.out.println("No employees added");
                    else
                        System.out.println(employees);
                    break;
                }
                case 7:{
                    addNewRole();
                    break;
                }
                case 8:{
                    if(roles.isEmpty())
                        System.out.println("No roles added");
                    else
                        System.out.println(roles);
                    break;
                }
            }
        }
    }
}


