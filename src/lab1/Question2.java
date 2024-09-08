package lab1;
/*
 * Phemelo Moloi
 * ID:22001164
 */

import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        //Declarations
        Scanner console = new Scanner(System.in);
        String name;
        double Salary, tax, deduction, netSalary;

        // User Inputs
        System.out.print("Enter your full names :");
        name = console.nextLine();

        System.out.print("Enter you salary :");
        Salary = console.nextDouble();

        System.out.print("Enter your tax deductions in % :");
        tax = console.nextDouble();

        // net salary calculation
        deduction = Salary * (tax / 100);
        netSalary = Salary - deduction;

        //Outputs
        System.out.println("Names :"+name.toUpperCase());
        System.out.println("Net Salary :P"+ netSalary);

    }
}
