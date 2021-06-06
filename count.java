package Final_Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class count {


	public static final int Nmax = 10000;

	public static int[] grundy = new int[Nmax + 1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10000; i++) {
			grundy[i] = -1;

		} 

		int[] num = new int[10000];
		//int[] num2 = new int[5000]; //to handle the values of the new sprague grundy 
		//print the grundy values		
		System.out.println();
		for (int x = 0; x < 10000; x++) {
			num[x]=  Even_sprague_grundy(x);
		//	num2[x] =Even_sprague_grundy(x);
		}

		System.out.println("How many times each number appears in the");
		System.out.println("set ot the results in the original grundy game :");
		System.out.println();
		
		
	//	count how many time each number appears in the array
		
		int[] count = new int[num.length];
		int i,temp = 0;
		for(i = 0; i < num.length; i++){
			temp = num[i];
			count[temp]++;
		}
		


		for(i=0; i < count.length; i++){

			if(count[i] > 0 && count[i] == 1){
				System.out.printf("%d occurs %d time\n",i, count[i]);
			}
			else if(count[i] >=2){
				System.out.printf("%d occurs %d times\n",i, count[i]);
			}
		}

	}
	


	/*function that calculates the new grundy values
	  with an additional condition which is that
	  we can split the number to two numbers that at least one of them is even 
	 */

	public static int Even_sprague_grundy(int heap_size)
	{
		if (grundy[heap_size] != -1)
		{
			return grundy[heap_size];
		}

		HashSet<Integer> Set = new HashSet<Integer>();

		for (int i = 1; i <= heap_size / 2; ++i)
		{
			if (i != heap_size - i && ((i%2==0 || (heap_size - i)%2==0)))
			{
				Set.add(Even_sprague_grundy(i) ^ Even_sprague_grundy(heap_size - i));
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


	//function that calculates the basic grundy values
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

