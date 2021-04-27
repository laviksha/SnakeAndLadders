import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLadder {
 public static void main(String args[]) {
	 
	 //1-100 board
	 Map<Integer,Integer> snakesPosition=new HashMap<Integer,Integer>();
	 snakesPosition.put(21, 5);
	 snakesPosition.put(72, 15);
	 snakesPosition.put(98, 11);
	 snakesPosition.put(30, 2);
	 snakesPosition.put(50, 15);

	 Map<Integer,Integer> laddersPosition=new HashMap<Integer,Integer>();
	 laddersPosition.put(10, 31);
	 laddersPosition.put(21, 45);
	 laddersPosition.put(41, 78);
	 laddersPosition.put(50, 60);
	 laddersPosition.put(22, 50);
	 
	 int currentPositionOfA=0;
	 int currentPositionOfB=0;
	 boolean turnOfA=true;
	 
	 Random dice=new Random();
	 while(true) {
		 int rolleDice=dice.nextInt(6)+1;
	 if(turnOfA) {
		 int old=currentPositionOfA;
		 currentPositionOfA=currentPositionOfA+rolleDice;
		 if(currentPositionOfA==100) 
		 {
			 System.out.println("A won. HURRAY!!");
			 break;
			 }
		 if(currentPositionOfA>100) {
			 System.out.println("A cannot move forward. Dice may lead you out of borad>100");
			 currentPositionOfA=old;
			 continue;
		 }
		 if(laddersPosition.containsKey(currentPositionOfA)) {
			 System.out.println("Ladders from "+currentPositionOfA+","+laddersPosition.get(currentPositionOfA));
			 currentPositionOfA=laddersPosition.get(currentPositionOfA);
		 }
		 if(snakesPosition.containsKey(currentPositionOfA)) {
			 System.out.println("Snake from "+currentPositionOfA+","+laddersPosition.get(currentPositionOfA));
			 currentPositionOfA=snakesPosition.get(currentPositionOfA);
		 }
		 System.out.println("A old position:"+old+" new position:"+currentPositionOfA);
		 turnOfA=false;
	 }
	 else{
		 int old=currentPositionOfB;
		 currentPositionOfB=currentPositionOfB+rolleDice;
		 if(currentPositionOfB==100) 
		 {
			 System.out.println("B won. HURRAY!!");
			 break;
			 }
		 if(currentPositionOfB>100) {
			 System.out.println("B cannot move forward. Dice may lead you out of borad>100");
			 currentPositionOfB=old;
			 continue;
		 }
		 if(laddersPosition.containsKey(currentPositionOfB)) {
			 System.out.println("Ladders from "+currentPositionOfB+","+laddersPosition.get(currentPositionOfA));
			 currentPositionOfB=laddersPosition.get(currentPositionOfB);
		 }
		 if(snakesPosition.containsKey(currentPositionOfB)) {
			 System.out.println("Snake from "+currentPositionOfB+","+laddersPosition.get(currentPositionOfA));
			 currentPositionOfB=snakesPosition.get(currentPositionOfB);
		 }
		 System.out.println("B old position:"+old+" new position:"+currentPositionOfB);
		 turnOfA=true;
	 }
	 
	 }
	 
 }
	
}
