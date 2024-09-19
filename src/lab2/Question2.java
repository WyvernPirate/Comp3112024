package lab2;
/*
 * @Phemelo Moloi
 * @ID:22001164
 */

import java.io.FileReader;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) throws Exception {
        FileReader file = new FileReader("C:\\VS\\Java\\Comp3112024\\src\\lab2\\counsel.txt");
        Scanner f = new Scanner(file);

        if (f.hasNextLine()) {
            System.out.print(f.nextLine());
            
        }

    }
}
