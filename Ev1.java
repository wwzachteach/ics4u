
import java.util.*;
public class Ev1 implements AABB{
	//int x = 45;
	//int y = 3;
	static Scanner ky = new Scanner(System.in);
	
	public static void main (String[] args){
		Ev1 ev = new Ev1();
		ev.getAA(ky.nextDouble(), ky.nextDouble());
		ev.getBB(ky.nextDouble(), ky.nextDouble());
	}
	
	public Ev1 (){
			
		}
	
	public double getAA(double x, double y){
		return x+y;
	}
	
	public double getBB(double x, double y){
		return x-y;
	}
	
}
//----------------------------------------------------------------------------------------------
abstract class findBigger{
        public int biggest (int x, int y)  {
                int max;
                if (x > y){ 
                    System.out.println("Compare integer 12 & 300  The bigger number is "+x);
                    return x;
                    
                }
                else{
                    System.out.println("Compare integer 12 & 300  The bigger number is "+y);
                    return y;
                }  
            }
        public double biggest (double x, double y)  {
                double max = 0;
                if (x > y){ 
                    System.out.println("Compare double 234.8 & 125.9  The bigger number is "+x);
                    return x;
                }
                else{
                    System.out.println("Compare double 234.8 & 125.9  The bigger number is "+y);
                    return y;
                }  
        }
    }