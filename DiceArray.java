package proj5;

/**
 * <p>Title: The DiceArray class</p>
 *a
 * <p>Description: The DiceArray class can be used to play multiple games with dice.
 * A DiceArray object can contain any number of dice. This class allows DiceArray objects
 * to be manipulated by allowing the user to: roll all or some dice, keep specific dice so
 * they are not rolled, reset all the dice, to sum up certain dice, and to return the address
 * of the dice so they can be displayed.   </p>
 *
 * @author Jason Diaz
 */

public class DiceArray {

	private int[] dice;
	private boolean[] keep;

	/**
	 * DiceArray parameterized constructor--
	 * accepts the number of dice needed for the game. Also gives 0 for the
	 * face values of the dice, and false to indicate that no dice should be kept.
	 * @param num, which indicates how many dice there should be.
	 */
	public DiceArray(int num)
	{
		dice = new int[num];
		keep = new boolean[num];

		for(int i = 0; i < num; i++)
		{
			dice[i] = 0;
			keep[i] = false;
		}
	}

	/**
	 * roll method--
	 * rolls the appropriate dice depending if the dice is being kept or not.
	 */
	public void roll()
	{
		for(int i = 0; i < dice.length; i++)
			if(keep[i] == false)
				dice[i] = (int)(Math.random()*6 + 1);
	}

	/**
	 * getDice method--
	 * @return a reference to the dice array.
	 */
	public int[] getDice()
	{
		return dice;
	}

	/**
	 * reset method--
	 * allows all dice to be rolled the next time the roll method is called 
	 */
	public void reset()
	{
		for(int i = 0; i < dice.length; i++)
			keep[i] = false;
	}

	/**
	 * keep method--
	 * Indicates which of the dice should be kept by setting the keep array values to true. 
	 * @param die, is the number that will be kept. 
	 */
	public void keep(int die)
	{
		for(int i = 0; i < dice.length; i++)
		{
			if(dice[i] == die)
				keep[i] = true;
			else
				keep[i] = false; 
		}
	}

	/**
	 * calculateTotal method--
	 * Calculates and returns the total for the selected face value.
	 * @param num, accepts an integer indicating which of the face values should be summed up.
	 * @return an integer which is total of all the face values summed up.
	 */
	public int calculateTotal(int num)
	{
		int x = 0;
		for(int i = 0; i < dice.length; i++)
			if(dice[i] == num)
				x = x + dice[i];
		return x;
	}

	/**
	 * toString method--
	 * a String containing the values of the dice and indicates which are/are not being kept.
	 * @return the value of all the dice. Underneath it displays T if the dice is being kept
	 * and F if not.
	 */
	public String toString()
	{
		String str = new String();
		String rts = new String();
		for(int i = 0; i < dice.length; i++)
		{	
			str = str + dice[i] + " "; 
			if(keep[i] == true)

				rts = rts + "T ";
			else
				rts = rts + "F ";
		}
		return str + "\n" + rts;
	}

}

