package proj5;
/**
 * <p>Title: The Project5p2 class
</p>
 *a
 * <p>Description: The Project5p2 class is code to play the game Yahtzee. 
 * The computer rolls five dice and displays them on the screen, then asks the user
 * to choose which die they would like to keep. The dice is rolled three times per 
 * round, and there is six rounds. At the end of each round the user is asked Which 
 * location they would like to record their roll. A location cannot be used more than once.   </p>
 *
 * @author Jason Diaz
 */
import javax.swing.JOptionPane;

public class Project5p2 {
	public static void main(String[] args)
	{
		DiceArray test2 = new DiceArray(5);
		GUI display = new GUI();
		int[] keepVal = new int[2];
		int[] scoreCard = new int[6];
		boolean[] boolScoreCard = new boolean[6];

		for(int i = 0; i < 6; i++)
		{ 
			test2.reset();
			test2.roll();
			display.showDice(test2);

			{
				for(int j = 0; j < 2; j++)
				{	

					keepVal[j] = Integer.parseInt(JOptionPane.showInputDialog("Which die value would you like to keep?"));

					if((j != 0) &&(keepVal[j] != keepVal[j - 1]))
						test2.reset();


					test2.keep(keepVal[j]);
					test2.roll();
					display.showDice(test2);
				}
			}

			int num = Integer.parseInt(JOptionPane.showInputDialog("Which location would you like to record this round?" +  "\nScores:" + "\nOnes: " + scoreCard[0] + " points" + "\nTwos: " + scoreCard[1] + " points" +
					"\nThree: " + scoreCard[2] + " points " + "\nFours: " + scoreCard[3] + " points " + "\nFives: " + scoreCard[4] + " points" +
					"\nSixes: " + scoreCard[5] + " points")); 

			int total = test2.calculateTotal(num);

			if(boolScoreCard[num - 1] == true)
			{
				while(boolScoreCard[num - 1] == true)
				{
					num = Integer.parseInt(JOptionPane.showInputDialog("There is already a score for location " + num + "\nChoose another location" + "\nScores:" +
							"\nOnes: " + scoreCard[0] + " points" + "\nTwos: " + scoreCard[1] + " points" + "\nThree: " + scoreCard[2] + " points " + "\nFours: " + 
							scoreCard[3] + " points " + "\nFives: " + scoreCard[4] + " points" + "\nSixes: " + scoreCard[5] + " points"));
				}

				total = test2.calculateTotal(num);
				scoreCard[num - 1] = total;
			}
			else
			{
				scoreCard[num - 1] = total;
				boolScoreCard[num-1] = true;
			}

			JOptionPane.showMessageDialog(null,"Round " + (i + 1) + " complete." +  "\nScores:" + "\nOnes: " + scoreCard[0] + " points" + "\nTwos: " + scoreCard[1] + " points" +
					"\nThree: " + scoreCard[2] + " points " + "\nFours: " + scoreCard[3] + " points " + "\nFives: " + scoreCard[4] + " points" +
					"\nSixes: " + scoreCard[5] + " points","Score",JOptionPane.INFORMATION_MESSAGE);
		}

		int totalScore = 0;
		for(int t = 0; t < 6; t++)
			totalScore = totalScore + scoreCard[t];

		JOptionPane.showMessageDialog(null,"Game over! Your total score is " + totalScore,"Total Score",JOptionPane.INFORMATION_MESSAGE);
	}
}

