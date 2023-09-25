/*
 * Near Miss, Fermat's Last Theorem
 * File name holds the program: FermatNearMiss.java
 * 
 * Programmer Names: 
 * 		Syed Zeeshan Nusrathi || Email Address: SyedZeeshanNusrath@lewisu.edu
 * 		Gopalakrishna Perla || Email Address: GopalakrishnaPerla@lewisu.edu
 * 
 * Course: 
 * 		FA23-CPSC-60500-002
 * 
 * Date of Submission:
 * 		September 24, 2023
 * 
 * take the k and n from user, while loop is there to make sure that values are in given range
 * left hand side: x power n + y power n is calculated
 * the value get from the above equation, take nth root of that value and we get value of z
 * To calculate near miss "left hand side - z power n", also calculated "(z+1) power n - left hand side"
 * whichever difference will be less that will be our near miss
 * Then calculate the relative miss
 * then compare relative miss with smallest miss to retrieve the smallest possible miss
 *  
 * No help taken from any outside source.
 * 
 * understood the requirements and then followed them
 * 
 * In this program long data type can be seen with many variables, purpose is to get the right values for as much combinations as we can since value gets very large as range or power n increases.
 * 
 *
 * 
 */
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class FermatNearMiss {
	
	/*
	 * main function: It computes all the calculations from start to end.
	 */

	public static void main(String[] args) 
	{ 
		double smallest_miss = 9999999999999999.99;
		
		int lowerlimit = 10;
		//variables k and n, k is for range and n is for power
		int k = 0;
	    int n = 0;
		
	    //long data type variables for x and y and z because it can get very very large number and if we don't use it program will crash or it will overflow.
		long x = lowerlimit;
	    long y = 0;
	    long z = 0;
	    
	    // Scanner object to take the user input
	    Scanner userinput = new Scanner(System.in);
	    
	    //loop to get the right values from user
	    do {
	    	System.out.println("USER iNPUT for setting the Upper limit for K, (K must be greater or equal to 10 ): ");
		    k = userinput.nextInt();
	    }while(k<10);
	    
	    //loop to get the right values from user
	    do {
	    	System.out.println("USER INPUT for taking the n value, n cant be lower than 3 and greater than 11: ");
		    n = userinput.nextInt();
	    }while(n<3 || n>11); 
	    
	    //Every x value will be computed with all the values of y
	    while(x<=k) 
	    {
	    	for (y = lowerlimit; y<=k; y++)
	    	{	
	    		System.out.println("*********************************");
	        	System.out.println("x = " + x);
	        	System.out.println("y = " + y);
	        	System.out.println("n = " + n);
	        	System.out.println();
	        	//lefthandside = x power n + y power n
	        	long lefthandside = (long)((Math.pow (x, n))+(Math.pow (y, n)));
	        	System.out.println("x^"+n+" + y^"+n+" = "+lefthandside);
	        
	        	//taking nth root of left hand side to get the z value
	        	z = (int) Math.pow (lefthandside, 1.0/n);
	        	System.out.println("z = "+z);
	        	System.out.println();
	        
	        	//Calculating near miss for z and z+1
	        	long nearmiss = (long)(lefthandside - Math.pow (z, n));
	        	if(((long)(Math.pow (z+1, n) - lefthandside))<nearmiss)
	        	{
	        		nearmiss = (long)(Math.pow (z+1, n) - lefthandside);
	        	}
	        	System.out.println("Near Miss= "+nearmiss);
	        
	        	//calculating the relative miss
	        	double relativemiss = 100. * nearmiss / lefthandside;
	        	System.out.println("Relative Miss= "+relativemiss);
	        
	        
	        	//finding smallest miss
	        	if(relativemiss<smallest_miss)
	        	{
	        		smallest_miss = relativemiss;
	        	}
	        	System.out.println("Smallest Miss= "+smallest_miss);
	           
	        }
	    	x++;
	    }
	}
}


