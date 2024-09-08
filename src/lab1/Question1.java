package lab1;
/* Name: Phemelo Moloi
 Student Number: 22001164*/

public class Question1 {
    public static void main(String[] args) {
        
    
    //Declarations
    double x = 4, y = 8, z, z2;
    String sentence = "My day is ruined";
    StringBuilder console = new StringBuilder(sentence);


    // part a: calculation of z^2 = x^2 + y^2
    z2 = Math.pow(x, 2) + Math.pow(y, 2);
    z = Math.sqrt(z2);
    
    //Print statements
        //Part a:
   
    System.out.println("X :"+ x +"  Y :"+ y);
    System.out.println(x+"^2 + "+ y+"^2 = "+ z2 +"^2");
    System.out.printf("Z :%.2f",z);

        //Part b:
        // 
        System.out.println("\nThe number of characters :"+ sentence.length());
        System.out.println("The last character :"+ sentence.charAt(sentence.length()-1) );
        System.out.println("Position of 'r' :"+ sentence.indexOf('r'));
        System.out.println("String in reverse :"+ console.reverse());
    }
}
