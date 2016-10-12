
public class Calculator 
{
	public static double add(double a, double b) 
	{
	    return a+b;          
	}

	public static double subtract(double a, double b) 
	{
	    return a-b;          
	}

	public static double multiply(double a, double b) 
	{
	    return a*b;       
	}

	public static double divide(double a, double b) 
	{
	    return a/b;          
	}

	public static double power(double a, double b)
	{
		double result =a;

	    for (int x=2; x<=b; x++)
	    	result *= a;

	    return result;
	}

}
