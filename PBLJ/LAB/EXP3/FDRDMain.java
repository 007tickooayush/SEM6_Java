package PBLJ.LAB.EXP3;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static PBLJ.LAB.EXP3.InvalidAmountException.*;

abstract class Account{
    double interestRate,amount;
    abstract double calculateInterest();
}

class FD extends Account{
    Integer numDays,age;

    @Override
    double calculateInterest() {
        return amount*interestRate/100;
    }
}

class SB extends Account{

    @Override
    double calculateInterest() {
        return amount*interestRate;
    }
}

class RD extends Account{
    Integer numMonths;
    double amountMonthly;

    @Override
    double calculateInterest() {
        return amount*interestRate/100;
    }
}


class InvalidAmountException extends Exception{
    InvalidAmountException(String exception){
        super(exception);
    }
    static void checkAmount(double amount) throws InvalidAmountException {
        if(amount<0){
            throw new InvalidAmountException("Invalid Amount");
        }
    }
    static void checkAge(double amount) throws InvalidAmountException {
        if(amount<0){
            throw new InvalidAmountException("Invalid Age");
        }
    }

    static void checkMonths(int amount) throws InvalidAmountException {
        ArrayList<Integer>months = new ArrayList<>(6);//{6, 9, 12, 15, 18, 21};
        months.add(0,6);
        months.add(0,9);
        months.add(0,12);
        months.add(0,15);
        months.add(0,18);
        months.add(0,21);
        if(!months.contains(amount)){
            throw new InvalidAmountException("Invalid time");
        }
    }
}


class Calculate{
    private final Scanner scan = new Scanner(System.in);
    private final PrintStream print = new PrintStream(System.out);

    void calculate() {
        print.println();
        print.format("%3s. %-10s", "1", "Calculate Interest SB");
        print.println();
        print.format("%3s. %-10s", "2", "Calculate Interest FD");
        print.println();
        print.format("%3s. %-10s", "3", "Calculate Interest RD");
        print.println();
        print.format("%3s. %-10s", "4", "EXIT");
        print.println();


        print.println("Enter the task: ");
        int choice = scan.nextInt();

        Account account;
        double amount;
        try {
            switch (choice) {
                case 1:
                    account = new SB();

                    System.out.print("Enter account type [1.Normal | 2.NRI]: ");
                    int n = scan.nextInt();

                    System.out.println("Enter average amount in account: ");
                    amount = scan.nextInt();

                    if(n == 1) account.interestRate = 0.04;
                    else if(n == 2) account.interestRate = 0.06;
                    else System.out.println("Invalid selection.");

                    checkAmount(amount);

                    account.amount = amount;

                    System.out.println("Interest gained : "+account.calculateInterest());
                    break;

                case 2:
                    account = new FD();
                    System.out.print("Enter account type [1.General | 2.Senior Citizen]: ");
                    int t = scan.nextInt();

                    System.out.println("Enter FD amount: ");
                    amount = scan.nextDouble();

                    checkAmount(amount);
                    account.amount = amount;

                    System.out.println("Enter number of days: ");
                    int days = scan.nextInt();

                    checkAmount(days);
                    ((FD) account).numDays = days;

                    System.out.println("Enter the age: ");
                    int age = scan.nextInt();

                    checkAge(age);
                    ((FD)account).age = age;

                    if(amount <= 100000000){
                        if(t == 1){
                            if(days >=7 && days<=14)
                                account.interestRate = 4.50;
                            if(days >=15 && days<=29)
                                account.interestRate = 4.75;
                            if(days >=30 && days<=45)
                                account.interestRate = 5.50;
                            if(days >=46 && days<=60)
                                account.interestRate = 7.0;
                            if(days >=61 && days<=184)
                                account.interestRate = 7.50;
                            if(days >=185 && days<=365)
                                account.interestRate = 8.00;
                        }
                        if(t == 2){
                            if(days >=7 && days<=14)
                                account.interestRate = 5.00;
                            if(days >=15 && days<=29)
                                account.interestRate = 5.25;
                            if(days >=30 && days<=45)
                                account.interestRate = 6.00;
                            if(days >=46 && days<=60)
                                account.interestRate = 7.50;
                            if(days >=61 && days<=184)
                                account.interestRate = 8.00;
                            if(days >=185 && days<=365)
                                account.interestRate = 8.50;
                        }
                    }
                    else {
                        if(days >=7 && days<=14)
                            account.interestRate = 6.50;
                        if(days >=15 && days<=29)
                            account.interestRate = 6.75;
                        if(days >=30 && days<=45)
                            account.interestRate = 6.75;
                        if(days >=46 && days<=60)
                            account.interestRate = 8.00;
                        if(days >=61 && days<=184)
                            account.interestRate = 8.50;
                        if(days >=185 && days<=365)
                            account.interestRate = 10.00;
                    }

                    System.out.println("Interest gained : "+account.calculateInterest());
                    break;
                case 3:
                    // TODO: 02-03-2021 implement RD calculation system ;

                    account = new RD();

                    System.out.println("Enter account type [1.General | 2.Senior Citizen]: ");
                    t = scan.nextInt();

                    System.out.println("Enter FD amount: ");
                    amount = scan.nextDouble();

                    checkAmount(amount);
                    account.amount = amount;

                    System.out.println("Enter the time period in months [06,09,12,15,18,21]: ");
                    int months = scan.nextInt();
                    checkMonths(months);
                    ((RD)account).numMonths = months;


                    if(t==1){
                        if(months == 6)
                            account.interestRate = 7.50;
                        if(months == 9)
                            account.interestRate = 7.75;
                        if(months == 12)
                            account.interestRate = 8.00;
                        if(months == 15)
                            account.interestRate = 8.25;
                        if(months == 18)
                            account.interestRate = 8.50;
                        if(months == 21)
                            account.interestRate = 8.75;
                    }
                    if(t==2){
                        if(months == 6)
                            account.interestRate = 8.00;
                        if(months == 9)
                            account.interestRate = 8.25;
                        if(months == 12)
                            account.interestRate = 8.50;
                        if(months == 15)
                            account.interestRate = 8.75;
                        if(months == 18)
                            account.interestRate = 9.00;
                        if(months == 21)
                            account.interestRate = 9.25;
                    }
                    System.out.println("Interest gained : "+account.calculateInterest());
                    break;
                case 4:
                    System.out.println("System closed.");
                    break;
                default:
                    break;
            }
        }
        catch(InvalidAmountException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            print.println("Exception");
        }
        finally {
            scan.close();
            print.close();
        }

    }
}


public class FDRDMain {
//    final private static PrintStream print = new PrintStream(System.out);
//    final private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Calculate cal = new Calculate();
        cal.calculate();


//        print.close();
//        scan.close();
    }
}
