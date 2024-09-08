package lab1;

/*
 * Phemelo Moloi
 * ID:22001164
 */
import java.util.Scanner;

public class Question4 {

    public static void main(String[] args) {

        // declarations
        Scanner console = new Scanner(System.in);
        int gpa;

        // User Inputs
        System.out.print("Enter you GPA :");
        gpa = console.nextInt();

        // switch case for each value
        switch (gpa) {
            case 0:
                System.out.println("Work Hard");
                break;

            case 2:
                System.out.println("Observation");
                break;

            case 3:
                System.out.println("Average");
                break;

            case 4:
                System.out.println("Well Done");
                break;

            case 5:
                System.out.println("distinction");
                break;

            default:
                System.out.println("Enter a valid GPA value");
                break;
        }
    }
}
