import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RollDice {

	public static void main(String[] args) {
		int n = 0;
		int MAX_DICE_VAL = 6;
		int MIN_DICE_TOT = 2;
		int MAX_DICE_TOT = 12;
		
		//Get the input number from user
		
		System.out.println("Enter the number of rolls: " + "\n");
		Scanner scan = new Scanner(System.in);
		try {
			n = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid non-zero number");
			System.exit(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		if(n == 0) {
			System.out.println("Please enter a valid non-zero number");
			System.exit(0);
		}
		scan.close();
		
		//Roll the dice
		
		Random r = new Random();
		int totals[] = new int[n];
		ArrayList<Integer> aTotals = new ArrayList<Integer>(Collections.nCopies(13, 0));
		
		for (int i = 0; i < n; i++) {
			int dice1 = r.nextInt(MAX_DICE_VAL) + 1;
			int dice2 = r.nextInt(MAX_DICE_VAL) + 1;
			int total = dice1 + dice2;
			System.out.println("Iteration " + (i+1) + ":");
			System.out.println("Rolling dice 1: " + dice1);
			System.out.println("Rolling dice 2: " + dice2);
			System.out.println("Total: " + total);
			totals[i] = total;
			aTotals.set(total, aTotals.get(total) + 1);
		}
		System.out.println("Totals: ");
		for (int i = 0; i < totals.length; i++) {
			System.out.print(totals[i] + " ");
			
		}
		System.out.println("\n");
		
		// Print the bar chart
		
		for (int j = Collections.max(aTotals); j > 0; j--) {
			String str = "";
			for (int i = MIN_DICE_TOT; i <= MAX_DICE_TOT; i++) {
				if(aTotals.get(i) >= j) {
					str = str + "*\t";
				} else {
					str = str + " \t";
				}
			}
			System.out.println(str);
		}
		
		for(int i = MIN_DICE_TOT; i <= MAX_DICE_TOT; i++) {
			System.out.print(i + " \t");
		}
		
	}

}
