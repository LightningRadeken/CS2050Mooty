
public class ArraySortTest 
{
	public static void main(String[] args)
	{
		int[] arr1 = {1,2,4,5,6,10,13,18,21,28,30};
		double half = arr1.length/2.0;
		String mid = String.valueOf(half);
		if(mid.contains(".5"))
		{
			half=half-.5;
		}
		System.out.println("The middle index is index #" +(int)half);
	}
}
