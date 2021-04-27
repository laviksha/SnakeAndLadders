import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLaddersWithProperMethodImplementation {
	private static final String SNAKE="snake";
	private static final String LADDER="ladder";
	private static final String HUMAN="human";
	private static Map<Integer,Integer> snakesPosition=new HashMap<Integer,Integer>();
	private static Map<Integer,Integer> laddersPosition=new HashMap<Integer,Integer>();

	public static final String COMPUTER="computer";

	 public static void main(String args[]) {
	 //1-100 board
		 playSnakeAndLadders();
	 
	 
}
	 private static void playSnakeAndLadders() {
		
		 initializePositionForSnakeOrLadder(snakesPosition, SNAKE);

		 initializePositionForSnakeOrLadder(laddersPosition, LADDER);
		 
		 startTheGame();
		
	}
	private static void startTheGame() {
		 int computer=0;
		 int human=0;
		 boolean turnOfComputer=true;
		 while(true) {
			 int rolleDice=rollDice(6);
		 if(turnOfComputer) {
			 System.out.println("Turn of Computer. Dice rolled : "+rolleDice);
			 int old=computer;
			 computer=computer+rolleDice;
			 if(checkIfUserWon(COMPUTER,computer)) {
				 break;
			 }
			 if(computer>100) {
				 System.out.println("Computer cannot move forward. Dice may lead you out of borad>100");
				 computer=old;
				 continue;
			 }
			 if(laddersPosition.containsKey(computer)) {
				 System.out.println("=====YAYYYA Ladders HERE!! Ladders from "+computer+","+laddersPosition.get(computer)+"======");
				 computer=laddersPosition.get(computer);
			 }
			 if(snakesPosition.containsKey(computer)) {
				 System.out.println("============OHOOOO! Snake Bite !! Snake from "+computer+","+laddersPosition.get(computer)+"========");
				 computer=snakesPosition.get(computer);
			 }
			 System.out.println("Computer old position:"+old+" new position:"+computer);
			 turnOfComputer=false;
		 }
		 else{
			 int old=human;
			 human=human+rolleDice;
			 if(checkIfUserWon(HUMAN,human)) {
				 break;
			 }
			 if(human>100) {
				 System.out.println("Human cannot move forward. Dice may lead you out of borad>100");
				 human=old;
				 continue;
			 }
			 if(laddersPosition.containsKey(human)) {
				 System.out.println("Ladders from "+human+","+laddersPosition.get(computer));
				 human=laddersPosition.get(human);
			 }
			 if(snakesPosition.containsKey(human)) {
				 System.out.println("Snake from "+human+","+laddersPosition.get(computer));
				 human=snakesPosition.get(human);
			 }
			 System.out.println("B old position:"+old+" new position:"+human);
			 turnOfComputer=true;
		 }
		 
		 }
		
	}
	private static boolean checkIfUserWon(String user,int position) {
		if(position==100) {
			System.out.println("============= Hurray "+user+" Won========");
			return true;
		}
		return false;
	}
	private static void initializePositionForSnakeOrLadder(Map<Integer,Integer> positionMap, String type) {
		 Random rd=new Random();
		 if(type.equals(LADDER)) {
		 while(positionMap.size()<5) {
			 //random number b/w 98 to 10 random.nextInt(max - min + 1) + min
			 //first find end postion then find startposition to get lower value then this
			 int endPosition=rd.nextInt(89)+11;
			 int startPosition=rd.nextInt(endPosition)+1;//+1 as 0 may occur
			 if(positionMap.containsKey(startPosition)) {
				 continue;
			 }
			 else {
				 positionMap.put(startPosition, endPosition);
			 }		 
		 }
		 }
		 else {
			 //snake + ladder point is not considered
			 while(positionMap.size()<5) {
			 int startPosition=rd.nextInt(89)+11;
			 int endPosition=rd.nextInt(startPosition)+1;//+1 as 0 may occur
			 if(positionMap.containsKey(startPosition)) {
				 continue;
			 }
			 else {
				 positionMap.put(startPosition, endPosition);
			 }
			 }
		 }
		 
	 }
	 private static int rollDice(int n) {
		 Random rd=new Random();
		 return rd.nextInt(n)+1;
	 }
}
