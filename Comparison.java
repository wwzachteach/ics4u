import java.util.Scanner;
public class Comparison {
    static String s1; //3 strings
    static String s2;
    static String s3;
    static String storage[] = new String[3]; //makes array that stores strings
    private Scanner keyboard = new Scanner(System.in); //gives ability to ask user for string
    public void sets1 () {
        System.out.println ("Input a string"); //asks user to type a string
        String t1 = keyboard.next(); //next string they put in = s1
        s1 = t1; //setter method for s1
    }
    public void sets2 () {
        System.out.println ("Input a string"); //asks user to type a string
        String t2 = keyboard.next(); //next string they put in = s2
        s2 = t2; //setter method for s2
    }
    public void sets3 () {
        System.out.println ("Input a string"); //asks user to type a string
        String t3 = keyboard.next(); //next string they put in = s3
        s3 = t3; //setter method for s3
    }
    public String gets1 () {
        return s1; //getter method for t1
    }
    public String gets2 () {
        return s2; //getter method for t2
    }
    public String gets3 () {
        return s3; //getter method for t3
    }
    public static void main (String[]args) {
        Comparison c = new Comparison();
        
        c.sets1 (); //gives the strings bodies
        c.sets2 ();
        c.sets3 ();
        storage[0] = s1; //stores the string bodies in array slots
        storage[1] = s2;
        storage[2] = s3;
        System.out.println ("This is a program used to determines which string is longer.");
        System.out.println ("If the answer is greater than 0, then the the first string is longer. ");
        System.out.println ("If the answer is less than 0, the second is longer. ");
        System.out.println ("Finally, they are the same if the answer is 0.");
        System.out.println ("In comparing s1 and s2, the answer is " + s1.compareTo(s2) + "."); //compares strings 1 and 2
        System.out.println ("In comparing s1 and s3, the answer is " + s1.compareTo(s3) + "."); //compares strings 1 and 3
        System.out.println ("In comparing s2 and s3, the answer is " + s2.compareTo(s3) + "."); //compares strings 2 and 3
        System.out.println ("The first string is " + storage[0]); //prints string 1
        System.out.println ("The second string is " + storage[1]); //prints string 2
        System.out.println ("The third string is " + storage[2]); //prints string 3
    }
}