import java.util.Scanner;

public class Arraying2D 
{
	public static void main(String[] args)
	{
		//2d int array with size 5 by 5
		int[][] nums = new int[5][5];
		//calls to populate the array
		nums = populateArray(nums);
		//displays array
		DisplayArray(nums);
	}
	public static int[][] populateArray(int[][]arr)
	{
		//placeholder array
		int[][] numbers = arr;
		//holds entered value to add to array
		int holder;
		//scanner to allow user input
		Scanner input = new Scanner(System.in);
		//loops the first bracket
		for(int r = 0; r < numbers.length; r++)
		{
			//loops the second bracket
			for(int c = 0; c < numbers[0].length; c++)
			{
				//asks user to input a number
				System.out.printf("Enter the number you want in slot[%d][%d]: ",r,c);
				//takes number user entered and puts it into holder
				holder = input.nextInt();
				//adds value of holder to the array
				numbers[r][c] = holder;
			}
		}
		//closes scanner
		input.close();
		//returns the numbers array
		return numbers;
	}
	public static void DisplayArray(int[][] nums)
	{
		//new loop to print each value
		for(int r = 0; r < nums.length;r++)
		{
			//line for formating array display
			System.out.println("");
			for(int c = 0; c < nums[0].length;c++)
			{
				//displays the array value at the set location
				System.out.print(nums[r][c] +", ");
			}
		}
	}
}
