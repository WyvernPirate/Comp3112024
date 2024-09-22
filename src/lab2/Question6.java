package lab2;
/*
 * @Phemelo Moloi
 * @22001164
 */

public class Question6 {
    
    private String name;

    // constructor 
        public Question6(String a, double b) {
        this.name = a;

        // print the name in uppercase
        System.out.println("The name " + name + " in uppercase is " + a.toUpperCase());

        // print the result of multiplying number by 2
        System.out.println("The number " + b + " * 2 = " + b * 2);
    }

    // getter method to retrieve the name
    String getName() {
        return name;
    }


    
}
