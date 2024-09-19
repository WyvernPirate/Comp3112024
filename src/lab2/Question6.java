package lab2;

public class Question6 {
    private String name;

    public Question6( String a, double b){
        this.name = a;
        System.out.println("The name "+name+" in uppercase is "+a.toUpperCase());
        System.out.println("The number "+ b +" * 2 = "+b*2);
    }

    //get method
    String getName(){
        return name;
    }

}
