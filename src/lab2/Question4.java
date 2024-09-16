package lab2;
/*
 * @Phemelo Moloi
 * @ID: 22001164
 */
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        //Declarations
        Scanner scanner = new Scanner(System.in);
        int row, column;

        System.out.print("Enter the number of rows: ");
        row = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        column = scanner.nextInt();

        int[][] arr = new int[row][column];


        for(int i = 0; i < row; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = (int) (Math.random() * 100);
            }
        }

        // Printing the array
        System.out.println("Elements of the Array :");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j]+" ");
            }
            System.out.println( " ");
        }

        
    }
}
