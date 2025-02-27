
public class setup 
{
	public static void main(String[] args)
	{
		int[] array = {23,4,67,36,9,100,36,50,21,-10};
		int key = 36;
		int i = 0;
		boolean existing = false;
		while(i < array.length - 1)
		{
			if(array[i] == key)
			{
				System.out.println("36 exists at index " + i);
				existing = true;
			}
			i++;
		}
		if(existing ==false)
		{
			System.out.println("36 doesn't exist");
		}
	}
}
