package proj5;
/**
 * <p>Title: The Project5 class
</p>
 *a
 * <p>Description: The Project5 class tests the constructor and various methods
 * in the DiceArray class, and displays the result.   </p>
 *
 * @author Jason Diaz
 */

import javax.swing.JOptionPane;

public class Project5 {
	public static void main(String[] args)
	{

		//variable
		DiceArray test1 = new DiceArray(10);
		System.out.println(test1.toString());

		//testing roll method
		test1.roll();
		System.out.println("\nTesting roll method \n" + test1.toString());

		//testing keep method
		int num;
		num = Integer.parseInt(JOptionPane.showInputDialog("Which I number would you like to keep?"));
		test1.keep(num);
		test1.roll();
		System.out.println("\nTesting keep method\n" + test1.toString());
		num = Integer.parseInt(JOptionPane.showInputDialog("Which I number would you like to keep?"));
		test1.keep(num);
		test1.roll();
		System.out.println("\nTesting keep method with diffrent number\n" + test1.toString());

		//testing calculateTotal method
		int num2;
		num2 = Integer.parseInt(JOptionPane.showInputDialog("Which number would you like to add up?"));
		System.out.println("\nTesting calculateTotal method\n" + test1.calculateTotal(num2));

		//testing reset method
		test1.reset();
		System.out.println("\nTesting reset method\n" + test1.toString());

		//testing getDice method
		int[] test1Copy = test1.getDice();
		System.out.println("\n" + "Testing getDice method");
		for(int i = 0; i < test1Copy.length; i++)
			System.out.println("Dice " + (i + 1) + ":" + test1Copy[i]);

	}
}