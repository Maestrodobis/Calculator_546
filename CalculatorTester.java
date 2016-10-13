import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTester {
private static final double DELTA = 1e-15;
	@Test
	public void testAddition() 
	{
		Calculator calc = new Calculator();
		double result = calc.add(1.0, 1.0);
		assertEquals(2.0, result, DELTA);
		
		double result2 = calc.add(123.123, 123.123);
		assertEquals(246.246,result2,DELTA);
	}

	@Test
	public void testSubtraction() 
	{
		Calculator calc = new Calculator();
		double result = calc.subtract(1.0, 1.0);
		assertEquals(0.0, result, DELTA);
		
		double result2 = calc.subtract(246.246, 123.123);
		assertEquals(123.123,result2,DELTA);
	}
	@Test
	public void testMultiplication() 
	{
		Calculator calc = new Calculator();
		double result = calc.multiply(2.0, 1.0);
		assertEquals(2.0, result, DELTA);
		
		double result2 = calc.multiply(123.123, 2.0);
		assertEquals(246.246,result2,DELTA);
	}
	@Test
	public void testDivision() 
	{
		Calculator calc = new Calculator();
		double result = calc.divide(4.0, 2.0);
		assertEquals(2.0, result, DELTA);
		
		double result2 = calc.divide(45.0, 2.0);
		assertEquals(22.5,result2,DELTA);
	}
}