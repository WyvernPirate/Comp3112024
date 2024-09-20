package lab2;

/*
 * @Phemelo Moloi
 * @ID: 22001164
 */
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        // Declarations
        Scanner scanner = new Scanner(System.in);
        int row, column, sum = 0;

        System.out.print("Enter the number of rows: ");
        row = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        column = scanner.nextInt();
        scanner.close();

        int[][] arr = new int[row][column];

        // Randomizing and adding values to the array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100);
            }
        }

        // Printing the array 
        System.out.println("Elements of the Array :");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println(" ");
        }

        // Finding largest and smallest in array and calculating sum
        int largest = arr[0][0];
        int smallest = arr[0][0];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > largest) {
                    largest = arr[i][j];
                }
                if (arr[i][j] < smallest) {
                    smallest = arr[i][j];
                }
                sum += arr[i][j]; // calculating sum of all numbers
            }
        }

        // Outputs
        System.out.println("The Sum of all numbers :" + sum);
        System.out.println("The largest number in array :" + largest);
        System.out.println("The smallest number in array :" + smallest);

    }
}
