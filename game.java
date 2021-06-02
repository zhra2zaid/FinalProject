package finalproject1;


import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;



public class game {

	static ArrayList<Integer> Set = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		//this is the size of pile the players will split (positive size) which is randomly chosen by the computer
		System.out.println("enter a pile size :");
		int pilesize = scanner.nextInt();
		Set.add(pilesize);


		

		int count =1;
		int i; //shows which player plays now
		do {
			if(count%2 ==0) {
				i=2;
			}else {
				i=1;
			}

			play(i);
			System.out.println();
			count ++;
			canPlay(Set);
		}while(!Set.isEmpty());

		//count the numbers we played and since the count starts from 1 and the player1 started the game
		//so if we played even number times player2 won else the player1 won.
		if(count%2==0) {
			System.out.println("player1 won");
		}
		else {
			System.out.println("player2 won");
		}

	}



	//function that starts the game ; to know which player turn is now
	public static void play(int i) {

		Scanner scanner = new Scanner(System.in);

		System.out.println(Set);

		System.out.println("its player " +i+ " turn");

		playHelper(i);
	}


	//helper function to choose a number from the set of numbers and check if its legal
	public static void playHelper(int i) {
		Scanner scanner = new Scanner(System.in);	
		System.out.println("choose one number from the set of numbers shown above :"); 
		int pnum = scanner.nextInt();
		if(!Set.contains(pnum)) {
			System.out.println("there is no number like this!");
			playHelper(i);
		}
		else {
			System.out.println("split the number you chose into two numbers that at least one of them is even and smaller than the chosen number");
			playHelper2(pnum);
		}
	}

	
	
	/*
	* another helper function that splitting the chosen number according to our rules 
	* that at least one of the numbers is even (and both of them must be smaller than the chosen one)
    */
	public static void playHelper2(int pnum) {
		Scanner scanner = new Scanner(System.in);	
		System.out.println("enter the numbers you want to split to :"); 
		int pnum1 = scanner.nextInt();
		int pnum2 = pnum-pnum1;
		System.out.print(pnum1);
		System.out.println("," + pnum2);

		if(pnum1!= pnum2 && (pnum1%2==0 || pnum2%2==0) && pnum > pnum1  && pnum > pnum2) {
			Set.remove(Set.indexOf(pnum));
			Set.add(pnum1);
			Set.add(pnum2);
		}
		else {
			System.out.println("there is no even number,, try again");
			//check how can i make it back to chose again from point2
			playHelper2(pnum);
		}
	}

	
	/*check if we can play ,, since the smaller number we can get to is 1 or 2 
	 * and we can't split the 4 ; I decided that the game stops when the set is empty 
	 * so i remove these numbers automatically from the set whenever its appears.
	 */
	public static void canPlay(ArrayList<Integer> set) {		

		while(set.contains(1))
			set.remove(set.indexOf(1));
		while(set.contains(2))
			set.remove(set.indexOf(2));
		while(set.contains(4))
			set.remove(set.indexOf(4));
	}


}