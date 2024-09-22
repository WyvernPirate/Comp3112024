package lab2;
/*
 * Phemelo Moloi
 * 22001164
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Question3 {
    // Declarations
    public static void main(String[] args) throws Exception {

        // Declarations
        FileReader question2 = new FileReader("C:\\VS\\Java\\Comp3112024\\src\\lab2\\counsel.txt");
        FileReader file = new FileReader("C:\\VS\\Java\\Comp3112024\\src\\lab2\\counsel.txt");
        FileWriter writer = new FileWriter("C:\\VS\\Java\\Comp3112024\\src\\lab2\\rgbn.txt");
        Scanner read = new Scanner(question2);
        Scanner read2 = new Scanner(file);
        int count = 0, sum = 0;
        String word, longest = " ";

        // writing heading to file
        writer.write("Output for Question 3\n");

        //finding the longest word
        while (read.hasNextLine()) {
            word = read.next();
            if (word.length() > longest.length())
                longest = word;
            read.nextLine();
            count++;// counting number of words
        }
        // Printing words in upper case
        while (read2.hasNext()) {
            word = read2.next();
            writer.write(word.toUpperCase()+"\n");
            sum++;
        }

        //outputs
        writer.write("\nThe number of lines in file counsel is " + count);
        writer.write("\nThe longest word is :" + longest + " with " + longest.length() + " characters");
        writer.write("\nThe number of words in the file is :"+ sum);

        read.close();
        writer.close();
        read2.close();
        file.close();

    }
}
