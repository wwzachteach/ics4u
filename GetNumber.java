import java.util.Scanner;
public class GetNumber {
    static int g; //first int value
    static int h; //second int value
    static double i; //first double value
    static double j; //second double value
    private Scanner keyboard = new Scanner(System.in); //gives ability to ask user for number
    
    public void setg () { //setter methods
        System.out.println ("Input a number"); //asks user to type a number
        int k = keyboard.nextInt(); //next number they put in = g
        g = k; //setter method for g
    }
    public void seth () {
        System.out.println ("Input a number"); //asks user to type a number
        int l = keyboard.nextInt(); //next number they put in = h
        h = l; //setter method for g
    }
    public void seti () {
        System.out.println ("Input a number"); //asks user to type a number
        double m = keyboard.nextDouble(); //next number they put in = i
        i = m; //setter method for i
    }
    public void setj () {
        System.out.println ("Input a number"); //asks user to type a number
        double n = keyboard.nextDouble(); //next number they put in = j
        j = n; //setter method for j
    }
    public void add (int a, int b) { //int addition method
        a = g;
        b = h;
        int result = a + b;
        System.out.println ("The sum of these numbers is " + result);
    }
    public void add (double a, double b) { //double addition method
        a = i;
        b = j;
        double result = a + b;
        System.out.println ("The sum of these numbers is " + result);
    }
}