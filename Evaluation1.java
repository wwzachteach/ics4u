/** 
 * Hello, this is what I have done for Computer Science Evaluation 1.
 */
import java.util.*;
// I created an interface and its methods will be used in class in Ev1.
interface AABB{
    public double getAA(double x, double y);
    public double getBB(double x, double y);
}
// this class extends the abstract class "findBigger" and it uses the methods inside it.
public class Evaluation1 extends findBigger{
    public int int1;
    static Scanner keyboard = new Scanner (System.in);
    static public Integer number1;
    static public Integer number2;
    // the main method, calls every methods.
    public static void main (String[] args){
        Evaluation1 e1 = new Evaluation1();
        e1.askuser();
        e1.compareThings();
        Ev1 ev = new Ev1();
        knowBB(ev);
        addAA(ev);
        int onePare=e1.biggest(12,300);
    }
    //ask the user to input an int number then convert it to a long datatype.
    public void askuser(){
        System.out.println("Give a number, I will convert it to a long data type.");
        int int1 = keyboard.nextInt();
        long l = int1;
        System.out.println("Your int is: " + int1);
        System.out.println("Your long is: " + l);
    }
    //aske the user to input a number than the number will be compared to 100.(compareTo)
    public void compareThings(){
        System.out.println("Give a number, I will compare it to 100");
        number1 = keyboard.nextInt();
        number2 = 100;
        System.out.println(number1.compareTo(number2));
    }
    //---------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------
    //This class uses the methods from the the class Ev1 which contains the calculations for the numbers.
    public static void knowBB(AABB k){
        System.out.println("Give me 4 numbers and I will substract the first two and print out the rest two.");
        double o = k.getBB(keyboard.nextDouble(), keyboard.nextDouble());
        double x = keyboard.nextDouble();
        double y = keyboard.nextDouble();
        System.out.println("x-y = " + o);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        
        
    }
    //This class uses the methods from the the class Ev1 which contains the calculations for the numbers.
    public static void addAA(AABB t){
        System.out.println("Give me 2 numbers then I will add them.");
        double p = t.getAA(keyboard.nextDouble(), keyboard.nextDouble());
        System.out.println("The sum of the two numbers is:" + p);
    }
    }
