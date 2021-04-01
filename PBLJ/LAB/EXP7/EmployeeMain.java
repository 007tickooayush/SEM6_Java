package PBLJ.LAB.EXP7;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

class Employee{
    int employeeID,age;
    double salary;
    String name;
    Employee(){
        employeeID = 1000;
        age = 21;
        salary = 15000;
        name = "";
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

}

class Manage{
    static final Scanner s = new Scanner(System.in);
    static final PrintStream p = new PrintStream(System.out);
    ArrayList<Employee> empList;

    Manage(){
        this(13);
    }
    Manage(int size){
        empList = new ArrayList<>(size);
    }
    void manageEmployees(){

        int choice=1;

        while(choice!=3 && choice>0 && choice<4){
            p.println("--ENTER TASK TO DO:");
            p.format("|1. %-20s|\n","ADD EMPLOYEE");
            p.format("|2. %-20s|\n","SHOW EMPLOYEES");
            p.format("|3. %-20s|\n","EXIT");

            choice = s.nextInt();
            s.nextLine();

            Employee emp;

            switch (choice){
                case 1:
                    emp = new Employee();
                    p.format("--%-30s","ENTER EMPLOYEE ID: ");
                    emp.setEmployeeID(s.nextInt());
                    s.nextLine();

                    p.format("--%-30s","ENTER EMPLOYEE NAME: ");
                    emp.setName(s.nextLine());

                    p.format("--%-30s","ENTER EMPLOYEE SALARY: ");
                    emp.setSalary(s.nextDouble());

                    p.format("--%-30s","ENTER EMPLOYEE AGE: ");
                    emp.setAge(s.nextInt());

                    empList.add(emp);
                    break;
                case 2:
                    p.format("|%20s| |%20s| |%20s| |%20s|\n","EMPLOYEE ID","EMPLOYEE NAME","EMPLOYEE AGE","EMPLOYEE SALARY");
                    for(Employee e:empList){
                        p.format("|%20s| |%20s| |%20s| |%20s|\n",e.employeeID,e.name,e.age,e.salary);
                    }
                    p.println("--COMPLETE EMPLOYEE LIST--");
                    break;
                case 3:
                    p.println("--SHUTTING DOWN--");
                    break;
                default:
                    p.println("--TERMINATED--");
                    break;
            }
            p.println();
        }
        s.close();
        p.close();
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Manage e = new Manage();

        e.manageEmployees();

    }
}
