
public class SearchingTypes 
{
	public static void main(String[] args)
	{
		int key = 5;
		int[] arr = {1,2,4,5,6,9,10,13,14,15,15,17,18,20};
		int goal = LinearSearch(arr,key);
		if(goal < 0)
		{
			System.out.println("Linear search can't find the key");
		}
		else
		{
			System.out.println("The key is located at index ["+goal+"]");
		}
		goal = BinarySearch(arr,key);
		if(goal < 0)
		{
			System.out.println("Binary search can't find the key");
		}
		else
		{
			System.out.println("The key is located at index ["+goal+"]");
		}
	}
	public static int LinearSearch(int[] arr, int key)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == key)
			{
				return i;
			}
		}
		return -1;
	}
	public static int BinarySearch(int[] arr, int key)
	{
		int low = 0;
		int high = arr.length - 1;
		while (high >= low)
		{
			int mid = (low+high) / 2;
			if(key< arr[mid])
			{
				high = mid -1;
			}
			else if( key == arr[mid])
			{
				return mid;
			}
			else
			{
				low = mid+1;
			}
		}
		return -low -1;
	}
}

