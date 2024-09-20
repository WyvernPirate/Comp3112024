package lab2;
/*
 * @Phemelo Moloi
 * @22001164
 */
public class Question7 {
    public static void main(String[] args) {
        // Create an instance of Question6, passing "Phemelo" and 234 as arguments
        Question6 art = new Question6("Phemelo", 234);

        // Call the getName() method on the art object
        String word = art.getName();

        // Print the length of the word to the console
        System.out.println("The length of "+ word+" is "+word.length());
    }
}