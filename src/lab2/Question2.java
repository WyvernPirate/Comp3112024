package lab2;
/*
 * @Phemelo Moloi
 * @ID:22001164
 */

import java.io.FileReader;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) throws Exception {

        // Declarations
        FileReader file = new FileReader("C:\\VS\\Java\\Comp3112024\\src\\lab2\\counsel.txt");
        Scanner f = new Scanner(file);

        boolean bool = false;
        int count = 0;
        String word, longest= " ";
        

        System.out.println("The contents of file ;");

        // Loop for all the words in the file
        while (f.hasNext()) {
            word = f.next();

            // print words line by line
            System.out.println(word);
            count++;// words count

            // find longest word
            if (word.length() > longest.length()) longest = word;

            // check if word "Moloi" is in the sentence
            if (word.equals("Moloi")) bool = true; bool = false;
            
        }
        f.close();

        System.out.println("The total number of words in file :" + count);
        System.out.println("The longest word is " + longest + " by " + longest.length() + " characters");
        System.out.println("Is the word \"Moloi\" present? "+ bool);

    }
}
