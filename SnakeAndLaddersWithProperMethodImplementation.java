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
		 int computerPosition=0;
		 int humanPosition=0;
		 boolean turnOfComputer=true;
		 while(true) {
			 int rolleDice=rollDice(6);
		 if(turnOfComputer) {
			 System.out.println("Turn of Computer. Dice rolled : "+rolleDice);
			
			 if(checkIfUserWon(COMPUTER,computerPosition+rolleDice)) {
				 break;
			 }
			 
			 if(checkIfUserCanMoveForward(COMPUTER,computerPosition)) {	
				 continue;
			 }
			 int compOldPOsition=computerPosition;
			 computerPosition=computerPosition+rolleDice;
			 
			 if(checkIfLadderExist(computerPosition)) {
				 computerPosition=newPositionAfterLadder(computerPosition);
			 }
			 
			 if(checkIfSnakeExist(computerPosition)) {
				 computerPosition=newPositionAfterSnake(computerPosition);
			 }
			 System.out.println("Computer old position:"+compOldPOsition+" new position:"+computerPosition+"\n\n");
			
			 turnOfComputer=false;
		 }
		 else{
			 System.out.println("Turn of Human. Dice rolled : "+rolleDice);
				
			 if(checkIfUserWon(HUMAN,computerPosition+rolleDice)) {
				 break;
			 }
			 
			 if(checkIfUserCanMoveForward(HUMAN,computerPosition)) {	
				 continue;
			 }
			 int humanOldPosition=humanPosition;
			 humanPosition=humanPosition+rolleDice;
			 
			 if(checkIfLadderExist(humanPosition)) {
				 humanPosition=newPositionAfterLadder(humanPosition);
			 }
			 
			 if(checkIfSnakeExist(humanPosition)) {
				 humanPosition=newPositionAfterSnake(humanPosition);
			 } 
			 System.out.println("Human old position:"+humanOldPosition+" new position:"+humanPosition+"\n\n");
			 turnOfComputer=true;
		 }
		 
		 }
		
	}
	private static int newPositionAfterLadder(int computerPosition) {
		return laddersPosition.get(computerPosition);
	}
	
	private static boolean checkIfLadderExist(int currentPosition) {
		 if(laddersPosition.containsKey(currentPosition)) {
			 System.out.println("=====YAYYYA Ladders HERE!! Ladders from "+currentPosition+","+laddersPosition.get(currentPosition)+"======");
			 return true;
		 }
		 return false;
	}
	
	
	
	private static int newPositionAfterSnake(int position) {
		return snakesPosition.get(position);
	}
	
	private static boolean checkIfSnakeExist(int currentPosition) {
		 if(snakesPosition.containsKey(currentPosition)) {
			 System.out.println("============OHOOOO! Snake Bite !! Snake from "+currentPosition+","+snakesPosition.get(currentPosition)+"========");
			 return true;
		 }
		 return false;
	}
	
	private static boolean checkIfUserCanMoveForward(String user,int position) {
		if(position>100) {
			 System.out.println(user+" cannot move forward. Dice may lead you out of borad>100");
			return true;
		}
		return false;
	}
	
	private static boolean checkIfUserWon(String user,int position) {
		if(position==100) {
			System.out.println("============= Hurray "+user+" Won========");
			return true;
		}
		return false;
	}
	
	private static boolean gameOver(int computerPosition,int humanPOsition) {
		if(computerPosition==100 || humanPOsition==100) {
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
			 int endPosition=rd.nextInt(startPosition-10)+1;//+1 as 0 may occur
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
