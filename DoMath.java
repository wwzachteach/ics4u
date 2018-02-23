import java.util.Scanner;
public class DoMath implements Math {
    double x1; 
    double y1;
    double z1;
    private Scanner keyboard = new Scanner(System.in); //gives ability to ask user for number
    
    public void setx1 () { //Setter method for x1 value
        System.out.println ("Input a number"); //asks user to type a number
        double d = keyboard.nextDouble(); //next number they put in = d
        x1 = d;
    }
    public void sety1 () { //Setter method for y1 value
        System.out.println ("Input a number"); //asks user to type a number
        double e = keyboard.nextDouble(); //next number they put in = e
        y1 = e;
    }
    public void setz1 () { //Setter method for z1 value
        System.out.println ("Input a number"); //asks user to type a number
        double f = keyboard.nextDouble(); //next number they put in = f
        z1 = f;
    }
    public double getx1 () { //Getter method for x1 value
        return x1;
    }
    public double gety1 () { //Getter method for y1 value
        return y1;
    }
    public double getz1 () { //Getter method for z1 value
        return z1;
    }
    public double simple (double a, double b) { //Body to 2 variable interface method
        a = x1; //internal variable #1
        b = y1; //internat variable #2
        
        if (a - (int) a >= 0.5) { //rounding method. tells program when to round up for a
            a++;
        }
        else {
            a = a;
        }
        
        if (b - (int) b >= 0.5) { //rounding method. tells program when to round up for b
            b++;
        }
        else {
            b = b;
        }
        
        int result = (int) a * (int) b; //equation that uses variables
        System.out.println("The answer is " + result);
        return result;
   }
   public double complex (double a, double b, double c) { //Body to 3 variable interface method
       a = x1; //internal variable #1
       b = y1; //internal variable #2
       c = z1; //internal variable #3
        if (a - (int) a >= 0.5) { //rounding method. tells program when to round up for a
            a++;
        }
        else {
            a = a;
        }
        
        if (b - (int) b >= 0.5) { //rounding method. tells program when to round up for b
            b++;
        }
        else {
            b = b;
        }
        
         if (c - (int) c >= 0.5) { //rounding method. tells program when to round up for c
            c++;
        }
        else {
            c = c;
        }
       int result = ((int) a * (int) b)/(int) c; //equation that uses variables
       System.out.println("The answer is " + result);
       return result;
    } 
}
       