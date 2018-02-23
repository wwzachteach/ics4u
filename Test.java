public class Test extends DoMath {
    static double g; //placeholder variable to put the numbers in the right spot
    static double h; //placeholder variable to put the numbers in the right spot
    static double i; //placeholder variable to put the numbers in the right spot
    static double[] answers = new double[2]; //stores the answers to the equations
    static double[] components = new double[3]; //stores the variables in the equations
    public static void main (String[]args) {
        DoMath d = new DoMath(); //object of class DoMath
        d.setx1(); //calls setter for x1
        d.sety1(); //calls setter for y1
        d.setz1(); //calls setter for z1
        g = d.getx1(); //gives placeholder variable a value
        h = d.gety1(); //gives placeholder variable a value
        i = d.getz1(); //gives placeholder variable a value
        components[0] = g; //variable #1 put in array
        components[1] = h; //variable #2 put in array
        components[2] = i; //variable #3 put in array
        answers[0] = d.simple (g , h); //sets first array slot to answer from simple method, calls simple method
        answers[1] = d.complex (g, h, i); //sets second array slot to answer complex method, calls complex method
        System.out.println ("The number in the first array slot is " + answers[0]); //prints number in answers[0]
        System.out.println ("The number in the second array slot is " + answers[1]); //prints number in answers[1]
    }
}