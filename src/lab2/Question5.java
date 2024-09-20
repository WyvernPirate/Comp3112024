package lab2;
/*
 * @Phemelo Moloi
 * @22001164
 */

import java.util.*;

public class Question5 {

    public static void main(String[] args) {
        // Declarations
        int sum = 0, count = 0;
        String sentence, word, longest = " ";
        Scanner scanner = new Scanner(System.in);

        //Get sentence from the user and tokenize it
        System.out.println("Tell me something about yourself :");
        sentence = scanner.nextLine();
        StringTokenizer string = new StringTokenizer(sentence, " ");
        scanner.close();


        // Print each word in a single line
        while (string.hasMoreTokens()) {
            word = string.nextToken();
            System.out.println(word + " : "+ word.length());
            sum++;
            count = word.length();
            if( count <= word.length()){
                count = word.length();
                longest = word;

            }

        }
        System.out.println("The number of words: " + sum);
        System.out.println("The longest word is "+longest +" by "+ count+" letters in it");
       
        
    }
}
