package lab2;
/*
@Phemelo Moloi
@ID: 22001164
*/
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        //Declarations
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        // Gettting numbers from user
        System.out.print("Enter the first number :");
        num1 = scanner.nextInt();// a
        System.out.print("Enter the second number:");
        num2 = scanner.nextInt();// b

        // Function for printing even numbers between a and b
        System.out.println("Even numbers between "+ num1+" and "+num2);
       for(int i = (num1 + 1) ; i < num2; i++ )
        if(i%2 == 0){
            System.out.println(i); 
        }
        
    }
}
