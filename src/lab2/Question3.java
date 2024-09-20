package lab2;
/*
 * Phemelo Moloi
 * 22001164
 * 
 * 
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Question3 {
    //Declarations
    public static void main(String[] args) throws Exception {
        //Variables
        FileReader question2 = new FileReader("C:\\VS\\Java\\Comp3112024\\src\\lab2\\counsel.txt");
        FileReader file = new FileReader("C:\\VS\\Java\\Comp3112024\\src\\lab2\\rgbn.txt");
        FileWriter writer = new FileWriter("C:\\VS\\Java\\Comp3112024\\src\\lab2\\rbgn.txt");
        Scanner read = new Scanner(question2);

        writer.write("Output for Question 3");
        writer.write("\n");

        while (read.hasNextLine()) {
            
        }
            
        }


        






    }
}
