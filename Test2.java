public class Test2 extends GetNumber {
    public static void main (String[]args) {
        GetNumber z = new GetNumber(); //new object of class GetNumber
        z.setg();
        z.seth();
        z.seti();
        z.setj();
        z.add (g, i); //calls add method with an int and a double, it determines which to use based on parameters
    }
}
        
        