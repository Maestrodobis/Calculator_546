public class Calculator 
{
	public double add(double a, double b) 
	{
	    return a+b;          
	}

	public double subtract(double a, double b) 
	{
	    return a-b;          
	}

	public double multiply(double a, double b) 
	{
	    return a*b;       
	}

	public double divide(double a, double b) 
	{
	    return a/b;          
	}

	public static void main(String args[])
	{
		Calculator calc = new Calculator();
		double number1 = 0;
		double number2 = 0;
		
		if(args.length == 3)
		{	
			try {
	            // Parse the string argument into an integer value.
				number1 = Double.parseDouble(args[2]);
	        }
	        catch (NumberFormatException nfe) {
	            // The second argument isn't a valid double.  Print
	            // an error message, then exit with an error code.
	            System.out.println("The first number must be a double.");
	            System.exit(1);
	        }
			try {
	            // Parse the string argument into an integer value.
				number2 = Double.parseDouble(args[3]);
	        }
	        catch (NumberFormatException nfe) {
	            // The third argument isn't a valid double.  Print
	            // an error message, then exit with an error code.
	            System.out.println("The second number must be a double.");
	            System.exit(1);
	        }
			
			System.out.println(calc.add(number1, number2));
			System.out.println(calc.subtract(number1, number2));
			System.out.println(calc.multiply(number1, number2));
			System.out.println(calc.divide(number1, number2));
		}
		else
		{
			System.out.println("USAGE: ./calculator.java <double> <double>");
			System.exit(0);
		}
	}
}
