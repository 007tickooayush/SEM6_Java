package PBLJ.LAB.EXP1;

import java.io.PrintStream;
import java.util.*;

public class Employee {

    private static final Scanner scan = new Scanner(System.in);
    private static final PrintStream print = new PrintStream(System.out);
    private static final int size = 8;

    static class Details {
        String emp_name = "";
        String join_date = "";
        Character desig_code = ' ';
        String dept = "";
        Integer emp_no = 1001;

        Integer total_emp = 6000;
        Integer total_sal = 0;

        HashMap<Character, String> desig = new HashMap<Character, String>() {{
            put('e', "Engineer");
            put('c', "Consultant");
            put('k', "Clerk");
            put('r', "Receptionist");
            put('m', "Manager");
            put('i', "Finance");
        }};

        HashMap<Character,Integer> sal_basic = new HashMap<Character,Integer>(){{
            put('e',190000);
            put('c',87000);
            put('k',12000);
            put('r',15000);
            put('m',55000);
            put('i',67000);
        }};

        HashMap<Character,Integer> sal_hra = new HashMap<Character,Integer>(){{
            put('e',15000);
            put('c',8000);
            put('k',3000);
            put('r',2000);
            put('m',5500);
            put('i',10000);
        }};

        HashMap<Character,Integer> sal_it = new HashMap<Character,Integer>(){{
            put('e',1500);
            put('c',1800);
            put('k',300);
            put('r',1200);
            put('m',2500);
            put('i',1100);
        }};

        Details(int emp_no, String emp_name, String join_date, char desig_code, String dept){
            this.emp_no = emp_no;
            this.emp_name = emp_name;
            this.join_date = join_date;
            this.desig_code = desig_code;
            this.dept = dept;

            this.total_sal = sal_basic.get(desig_code) + sal_hra.get(desig_code) - sal_it.get(desig_code);
        }

        public Details() {

        }

        void printDetails(Details[] employee) {

            print.format("%-10s %-20s %-10s %-15s %-15s %-10s %-10s %-10s %-10s %-20s",
                    "EMP_ID", "EMPLOYEE_NAME", "JOIN_DATE", "DESIG_CODE", "DESIGNATION", "DEPT", "BASIC_SAL", "HRA_SAL", "IT_SAL", "TOTAL_SAL");

            for (Details details : employee) {
                print.println();
                Character ic = details.desig_code;
                print.format("%-10d %-20s %-10s %-15s %-15s %-10s %-10d %-10d %-10d %-20d",
                        details.emp_no, details.emp_name, details.join_date, details.desig_code, details.desig.get(ic), details.dept, details.sal_basic.get(ic), details.sal_hra.get(ic), details.sal_it.get(ic), details.total_sal);
            }


        }

        void getEmployee(Details[] employee) {

            int id = 0;

            while (id != -1) {
                print.println("Enter employee ID: ");
                id = scan.nextInt();

                if (isValid(id)) {
                    print.format("%-10s %-20s %-10s %-15s %-10s %-20s",
                            "EMP_ID", "EMPLOYEE_NAME", "JOIN_DATE", "DESIGNATION", "DEPT",  "TOTAL_SAL");
                    print.println();

                    for (Details details : employee) {
                        if (details.emp_no.equals(id)) {
                            print.format("%-10d %-20s %-10s %-15s %-10s %-20d",
                                    details.emp_no, details.emp_name, details.join_date, details.desig.get(details.desig_code), details.dept,  details.total_sal);
                            break;
                        }
                    }
                    print.println();
                } else {
                    print.println("Employee ID code not Valid");
                }

            }
        }

        private boolean isValid(int id) {
            return (id > 1000 && id <= 6000);
        }


        public static void main(String[] args) {


            Details[] employee = new Details[size];

            employee[0] = new Details(1234, "AYUSH", "10/02/2021", 'e', "CSE");
            employee[1] = new Details(1548, "ANIL", "11/12/2019", 'i', "ACCT");
            employee[2] = new Details(2002, "AKHIL", "11/12/2019", 'r', "DESK");
            employee[3] = new Details(2002, "AKHIL", "11/12/2019", 'r', "DESK");
            employee[4] = new Details(1674, "AYUSH", "10/02/2021", 'e', "CSE");
            employee[5] = new Details(2894, "ARYA", "11/12/2018", 'i', "ACCT");

//        print.println(employee[0].total_sal);

            Details pr = new Details();

//            pr.printDetails(employee);
            pr.getEmployee(employee);

            scan.close();
            print.close();
        }
    }

}
