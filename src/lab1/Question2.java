package lab1;

/**
 * This class calculates the net salary of an employee after deducting tax.
 * 
 * @author Phemelo Moloi
 * @ID 22001164
 */

import java.util.Scanner;

public class Question2 {

    /**
     * This method calculates the net salary of an employee based on the input
     * salary and tax deduction.
     * 
     * @param args Command line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // Declarations
        Scanner console = new Scanner(System.in);
        String name;
        double Salary, tax, deduction, netSalary;

        // User Inputs
        System.out.print("Enter your full names: ");
        name = console.nextLine();

        System.out.print("Enter your salary: ");
        Salary = console.nextDouble();

        System.out.print("Enter your tax deductions in %: ");
        tax = console.nextDouble();

        // net salary calculation
        deduction = Salary * (tax / 100);
        netSalary = Salary - deduction;

        // Outputs
        System.out.println("Names: " + name.toUpperCase());
        System.out.printf("Net Salary: P%.2f",netSalary);

    }
}
