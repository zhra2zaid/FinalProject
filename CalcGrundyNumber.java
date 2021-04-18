package Final_Project;

import java.util.HashSet;

public class CalcGrundyNumber {
	
	
	public static final int Nmax = 10000;

	public static int[] grundy = new int[Nmax + 1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10000; i++) {
			grundy[i] = -1;
		}

			System.out.print(sprague_grundy(6));
	}
	
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
	
	

}
