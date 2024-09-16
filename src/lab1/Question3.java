package lab1;

/*
 * Phemelo Moloi
 * ID:22001164
 */
import java.io.FileReader;
import java.util.Scanner;

public class Question3 {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        // Declarations
        FileReader f = new FileReader("C:\\VS\\Java\\Comp3112024\\src\\lab1\\numbers.txt");
        //FileReader g = new FileReader("C:\\VS\\Java\\Comp3112024\\src\\lab1\\numbers.txt");
        Scanner read = new Scanner(f);
        Scanner cool = new Scanner(f);
       
        
        int i = 0, j = 0, largest, smallest;
        int sum = 0;

        // Printing contents of array and getting array length
        while (read.hasNextInt()) {
            System.out.println(read.nextInt());
            i++;
        }
       f.close();

        // writing contents of file to array
        int[] arr = new int[i];
        
        while (cool.hasNextInt()) {
            arr[j] = cool.nextInt();
            j++;
        }
        

        // Getting sum of all numbers
        for (int k = 0; k < arr.length; k++) {
            sum += arr[k];
        }

        // Largest number in array
        largest = arr[0];
        for (int k = 1; k < arr.length; k++) {
            if (arr[k] > largest) {
                largest = arr[k];
            }
        }

        // Smallest number in array
        smallest = arr[0];
        for (int k = 1; k < arr.length; k++) {
            if (arr[k] < smallest) {
                smallest = arr[k];
            }
        }

        // outputs
        System.out.println("Sum of all numbers: " + sum);
        System.out.println("Largest number: " + largest);
        System.out.println("Smallest number: " + smallest);

    }

}