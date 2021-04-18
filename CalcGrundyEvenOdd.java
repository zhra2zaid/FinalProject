package Final_Project;

import java.util.HashSet;

public class CalcGrundyEvenOdd {

	//our idea here is to build a new function that calculates the the grundy game/function 
	//with new condition that both numbers(were dividing to) are even or both of them are odd
	//its almost the same as the regular grundy function i showed before 


	public static final int Nmax = 10000;

	public static int[] grundy = new int[Nmax + 1];


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			grundy[i] = -1;
		} 
		
		for (int x = 0; x < 50; x++) {
		 System.out.print(new_sprague_grundy(x) + " ");
		}
		
		//we conclode that it's always 0 in the odd posision (beacause odd numbers are always  even+odd )
		
		/*
		//new condition
		for (int x = 0; x < 50; x++) {
			System.out.print(x +" ");
			System.out.print( " regular:" + sprague_grundy(x) + " ");
			grundy[x] = -1;
			System.out.print(" new: " + new_sprague_grundy(x) + " ");
			System.out.println(" ");
		}
		*/
		
	}

	public static int new_sprague_grundy(int heap_size)
	{
		if (grundy[heap_size] != -1)
		{
			return grundy[heap_size];
		}

		HashSet<Integer> Set = new HashSet<Integer>();

		for (int i = 1; i <= heap_size / 2; ++i)
		{
			if (i != heap_size - i && ( (i%2==0 && (heap_size - i)%2==0) || (i%2!=0 && (heap_size - i)%2!=0) ))
			{
				Set.add(new_sprague_grundy(i) ^ new_sprague_grundy(heap_size - i));
			}
		}

		//mex
		grundy[heap_size] = 0;

		while (Set.contains(grundy[heap_size]))
		{
			grundy[heap_size]++;
		}

		return grundy[heap_size];
	}
	
	/*
	
	public static int sprague_grundy(int heap_size)
	{
		if (grundy[heap_size] != -1)
		{
			return grundy[heap_size];
		}

		HashSet<Integer> Set = new HashSet<Integer>();

		for (int i = 1; i <= heap_size / 2; ++i)
		{
			if (i != heap_size - i)
			{
				Set.add(sprague_grundy(i) ^ sprague_grundy(heap_size - i));
			}
		}


		//mex
		grundy[heap_size] = 0;

		while (Set.contains(grundy[heap_size]))
		{
			grundy[heap_size]++;
		}

		return grundy[heap_size];
	}
	*/
	

}
