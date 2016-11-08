import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends  JFrame implements ActionListener
{
	public JPanel[] row = new JPanel[5];
	public JButton[] button = new JButton[19];
	public String[] buttonString = {"7", "8", "9", "+",
							 "4", "5", "6", "-",
							 "1", "2", "3", "*",
							 ".", "/", "C", "√",
							 "+/-", "=", "0"};
	public int[] dimW = {300,45,100,90};
	public int[] dimH = {35, 40};
	public Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
	public Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
	public Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
	public Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);
	public boolean[] function = new boolean[4];
	public double[] temporary = {0, 0};
	public JTextArea display = new JTextArea(1,20);
	public Font font = new Font("Times new Roman", Font.BOLD, 14);

	Calculator()
	{
		super("Title");
		setDesign();
		setSize(380, 250);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(5,5);
		setLayout(grid);
		for(int i = 0; i < 4; i++)
			function[i] = false;
		FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
		FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
		
		for(int i = 0; i < 5; i++)
			row[i] = new JPanel();
		
		row[0].setLayout(f1);
		
		for(int i = 1; i < 5; i++)
			row[i].setLayout(f2);
		
		for(int i = 0; i < 19; i++) 
		{
			button[i] = new JButton();
			button[i].setText(buttonString[i]);
			button[i].setFont(font);
			button[i].addActionListener(this);
		}
		
		display.setFont(font);
		display.setEditable(false);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setPreferredSize(displayDimension);
		
		for(int i = 0; i < 14; i++)
			button[i].setPreferredSize(regularDimension);
		
		for(int i = 14; i < 18; i++)
			button[i].setPreferredSize(rColumnDimension);
		
		button[18].setPreferredSize(zeroButDimension);
		row[0].add(display);
		add(row[0]);
		
		for(int i = 0; i < 4; i++)
			row[1].add(button[i]);
		
		row[1].add(button[14]);
		add(row[1]);
		
		for(int i = 4; i < 8; i++)
			row[2].add(button[i]);
		
		row[2].add(button[15]);
		add(row[2]);
		         
		for(int i = 8; i < 12; i++)
			row[3].add(button[i]);
		
		row[3].add(button[16]);
		add(row[3]);
		row[4].add(button[18]);
		
		for(int i = 12; i < 14; i++)
			row[4].add(button[i]);
		row[4].add(button[17]);
		add(row[4]);
		setVisible(true);
	}
	
	public final void setDesign() 
	{
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e) {}
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == button[0])
			display.append("7");
		if(ae.getSource() == button[1])
			display.append("8");
		if(ae.getSource() == button[2])
			display.append("9");
		if(ae.getSource() == button[3])
		{
			temporary[0] = Double.parseDouble(display.getText());
			function[0] = true;
			display.setText("");
		}
		if(ae.getSource() == button[4])
			display.append("4");
		if(ae.getSource() == button[5])
			display.append("5");
		if(ae.getSource() == button[6])
			display.append("6");
		if(ae.getSource() == button[7])
		{
			temporary[0] = Double.parseDouble(display.getText());
			function[1] = true;
			display.setText("");
		}
		if(ae.getSource() == button[8])
			display.append("1");
	    if(ae.getSource() == button[9])
	        display.append("2");
	    if(ae.getSource() == button[10])
	        display.append("3");
	    if(ae.getSource() == button[11]) {
	        //multiply function[2]
	        temporary[0] = Double.parseDouble(display.getText());
	        function[2] = true;
	        display.setText("");
	    }
	    if(ae.getSource() == button[12])
	        display.append(".");
	    if(ae.getSource() == button[13]) {
	        //divide function[3]
	        temporary[0] = Double.parseDouble(display.getText());
	        function[3] = true;
	        display.setText("");
	    }
	    if(ae.getSource() == button[14])
	        clear();
	    if(ae.getSource() == button[15])
	        //todo
	    if(ae.getSource() == button[16])
	       //todo
	    if(ae.getSource() == button[17])
	        //todo
	    if(ae.getSource() == button[18])
	        display.append("0");
	}
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
	public void clear() 
	{
		try{
			display.setText(""); //Sets the display to being blank
			for(int i = 0; i<4; i++)
				function[i] = false; //sets the functions back to false
			for(int i = 0; i < 2; i++)
				temporary[i] = 0; //sets temp vars back to 0
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		Calculator calc = new Calculator();
		
		/*
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
		*/
	}

	
}