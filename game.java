package Final_Project;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class game extends CalcGrundyEvenOdd{

	public static void main(String[] args) {


		/* Game Description- 
           "A game is played between two players and there is a pile 
           that has certain number of stones. 
           On his/her turn, a player can divide the pile into two piles 
           that at least one of the pile sizes should be even. 
           The player who cannot move is considered to lose the game
		 */

		Scanner scanner = new Scanner(System.in);

		System.out.println("GAME START");


		System.out.println("Choose a the size of pile:");
		int pilesize= scanner.nextInt();

		//hashset to save the splitted numbers
		HashSet<Integer> Set = new HashSet<Integer>();
		Set.add(pilesize);



		while(!Set.isEmpty()) {
			//player chooses to split first :

			String winner = "you won";

			System.out.println("it's your turn ,, choose number:");
			System.out.println("first number :");
			int num1=scanner.nextInt();
			int num2 = pilesize-num1;

			if(num1<pilesize) {
				if ((num1 != num2) && ((num1%2==0 || num2%2==0))){
					Set.remove(pilesize);
					Set.add(num1);	
					Set.add(num2);
					winner = "you won";
				}
				else {
					System.out.println("you have to choose two numbers that both are even or both of them odd, choose again: ");
				}
			}else {
				System.out.println("you intered an illegal number ,, it has to be less than the pilesize ,, try again :");
				num1=scanner.nextInt();
			}


			System.out.println("player splited the pile to " + num1 + "," + num2);

			boolean split = (num1 != num2) && ((num1%2==0 || num2%2==0));
			
			//check all the set elements,, if all of them equal to 1 or 2 it means that there is no way to split more
			int count=0;
			for(int i=0; i<Set.size();i++) {
				if(Set.contains(1) || Set.contains(2)) {
					count ++;
				}
			}
			if(count == Set.size()) {
				break;
			}


			//computer turn to choose a number and split it 
			System.out.println("noe its computer turn:");
			int comsplit =new Random().nextInt( pilesize / 2) + 1;
			if (comsplit == num1) {
				if(split == true && num1>1) {
					int slipto = new Random().nextInt( pilesize / 2) + 1;;
					if(slipto <num1 && slipto >=1) {
						int slipto2 =num1-slipto;
						if((slipto != slipto2) && (slipto%2==0 || slipto2%2==0)) {
							System.out.println("computer chooses to split" + num1 + "to:" + slipto + "," + slipto2);
							Set.remove(num1);
							Set.add(slipto);
							Set.add(slipto2);
							winner ="the computer won !";
						}
						else {
							System.out.println("you have to choose two numbers that both are even or both of them odd, choose again: ");
							slipto =new Random().nextInt( pilesize / 2) + 1;;
						}
					}
				}
			}
			if (comsplit == num2) {
				if(split == true && num2>1) {
					int slipto = new Random().nextInt( pilesize / 2) + 1;
					if(slipto <num2 && slipto >=1) {
						int slipto2 =num2-slipto;
						if((slipto != slipto2) && (slipto%2==0 || slipto2%2==0)) {
							System.out.println("computer chooses to split" + num1 + "to:" + slipto + "," + slipto2);
							Set.remove(num2);
							Set.add(slipto);
							Set.add(slipto2);
							winner ="the computer won !";
						}
						else {
							System.out.println("you have to choose two numbers that both are even or both of them odd, choose again: ");
							slipto = new Random().nextInt( pilesize / 2) + 1;
						}
					}
				}

			}
			else {
				System.out.println("there is no number like this ! choose again");
				comsplit = new Random().nextInt( pilesize / 2) + 1;
			}


			
		//check all the set elements,, if all of them equal to 1 or 2 it means that there is no way to split more
			count=0;
			for(int i=0; i<Set.size();i++) {
				if(Set.contains(1) || Set.contains(2)) {
					count++;
				}
			}
			if(count == Set.size()) {
				break;
			}

		}

	}

}
