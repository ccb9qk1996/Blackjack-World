package java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack extends Dealer {

	//Set fields. 
	//The field deck is an ArrayList that  holds the cards whiare strings
	//the field hand in=s an Arraylist that holds the cards from the deck
	//The field jackpot is an integer that represents the players money that they can bet
	
	private static  ArrayList<String> deck;
	private ArrayList<String> hand;
	private static int jackpot;		
	private  int bet;
	
	//The constructor for the Blackjack class
	public Blackjack(){
		this.hand = new ArrayList<String>();
		//sets jackpot at beginning total
		this.jackpot = 100;
		this.deck = new ArrayList<String>();
	    this.bet = 0;
}
	// main methos=d calls start() method to begin game

	public static void main(String[] args) {
		Blackjack start = new Blackjack();
		//call to start() method
		start.start();
	}
	// start() goes through steps of the game.
	//Returns nothing
	//No parameters
	public void start(){
		//creates new Blackjack object
		Blackjack blackjack = new Blackjack();
		//creates a new Dealer object
		Dealer dealer = new Dealer();
		//ArrayList playersHand is the hand of player AFTER the player has chosen to Hit, Stand, or Double Down
		ArrayList<String> playersHand = new ArrayList<String>();
		//ArrayList startingPlayersHand is the hand of the player at the beginning of the game
		ArrayList<String> startingPlayersHand = new ArrayList<String>();		
		//Starting dialouge
				System.out.println(" Hello! Welcome to Blackjack Town!\n");
				System.out.println(" To win this game, you must either hit 21 \n\n or get a number higher than the dealer without busting!\n");
				System.out.println(" You will begin with $100 in your Jackpot.\n");
				//Gets input from user 
				Scanner input = new Scanner(System.in);  
				System.out.println(" If you would like to play, enter the word 'play'.\n");
				String exit = input.next();
				//while loop allows the user to exit game after finisshing a round 
				// also ends game if jackpot is equal to 0
				while (!exit.toLowerCase().equals("e")&& jackpot > 0){
					//Gets the deck
					deck = dealer.getDeck();
					System.out.println(" Please, place your bet!\n");
					//calls bet to get the user's bet
					this.bet = bet();
					//calls createHand() to pull two cards from the top of deck to create the hand
					startingPlayersHand = blackjack.createHand();
					//calls totalPoints to calculate the total number of points in the player's hand
					int startingTotal = blackjack.totalPoints(startingPlayersHand);
					//displays the total and starting hand
					System.out.println(" This is your starting hand: " + startingPlayersHand + "\n");
					System.out.println(" This is your starting total: " + startingTotal + "\n");
					//if the total is greater than 21 the player has busted
					if(startingTotal > 21){
						//calls computerPlayer() to get the CPU hand
						int dealersFinalTotal = computerPlayer(deck);
						//displays dealers total 
						System.out.println(" Dealer's total: " + dealersFinalTotal + "\n");
						System.out.println(" Because you busted, the dealer automatically wins \n unless he bust too.");
						if(dealersFinalTotal > 21){
							System.out.println(" You win!");
						}

					}
					//if starting total is not greater than 21 then action() is called to 
					//ask user what action she would like to take and return the new hand
					playersHand = blackjack.action(bet);
					//calculate the toatal points of the new hand
					int newTotal = blackjack.totalPoints(playersHand);
					//displays new hand an new total
					System.out.println("This is your final hand: " + playersHand + "\n");
					System.out.println("This is final total: " + newTotal + "\n");
					//if newTotal is equal to 21 prints out Blackjack
					if(newTotal == 21){
						System.out.println(" BLACKJACK!!!");
					}
					//calls computerPlayer() to get the total for the players hand and also display the palyes hand
					int dealersFinalTotal = computerPlayer(deck);
					//displays the dealer's totsl
     				System.out.println(" Dealer's final total: " + dealersFinalTotal+ "\n");
//					
					if(dealersFinalTotal > 21){
						System.out.println(" Dealer Busted\n");
					}
					if(newTotal > 21){
						System.out.println(" Bust! You Lose.\n");
					}
					if(newTotal < dealersFinalTotal){
						System.out.println(" You Lose\n");
					}
					if(newTotal > dealersFinalTotal && newTotal < 21 && dealersFinalTotal < 21){
						System.out.println(" You win!\n");
					}
					//gets input from the user 
					///ask if the user wants to exit the game
					Scanner input1 = new Scanner(System.in);
					System.out.println(" If you would like to exit the game, enter e. \n\n Otherwise enter play.\n\n");  
					exit  = input.next( );
					//if the input is e, then the games ends
					if(exit.equals("e")){
						//prints out jackpot and end message
						System.out.println(" Your final Jackpot value is " + jackpot + ". Thank you for playing! \n GAME OVER");
					}
					//if the input is not e, then the another round starts
					else{
						System.out.println(" Your current jackpot is " + jackpot + ".\n");
						//clear the playersHand ArrayList and the startingPlayersHand ArrayList
						playersHand.clear();
						startingPlayersHand.clear();
					}
				}
				//if jackpot is empty then ends game
				if(jackpot == 0){
					System.out.println(" Your jackpot is empty.\n GAME OVER");
				}
			}//end of start()
			
			//gets input from user
			//ask user for bet
			public static int bet(){
				//makes sure that bet is valid
				boolean validBet = false;
				//while the bet entered by the user is valid
				while(validBet == false){
					System.out.println(" Enter bet here: ");
					//ask user for bet
					Scanner input = new Scanner(System.in);  
					int newBet = input.nextInt();
					//if the jackpot is less than bet then the bet is returned
					if(newBet<=jackpot){
						return newBet; 
					}
					//if the bet is more than jackpot the following is printed out
					else{
						System.out.println(" You currently, have $"+ jackpot+ " in your jackpot.\n");
						System.out.println(" Your bet must be less than or equal to the value in your jackpot.\n");
						System.out.println(" Please, enter a valid  bet.\n");
						validBet = false;
					}
				}
				return 0;
			}//end of bet()

			//createHand() makes the player's hand
			//returns an ArrayList
			//no parameters
			public ArrayList<String> createHand(){
				//counts how many cards are pulled
				int pullTwoCards = 0;
				Dealer dealer = new Dealer();
				ArrayList<String> deck = new ArrayList<String>();
				//gets deck
				deck = dealer.getDeck();
				//shuffles deck
				dealer.shuffle(deck);
				//while there are less than or equal two cards
				// add to the hand
				while( pullTwoCards <= 1){
					//sets the object c first card on the top of the deck, first element in the ArrayList
					String card = dealer.dealOneCard(deck);
					//adds the object card to the player's hand
					this.hand.add(card);
					pullTwoCards++;
				}
				return this.hand;
			}
			public int totalPoints(ArrayList<String> hand){
				int total = 0;
				//for loop goes through the hand and adds the face value to total points
				for(int i = 0; i < hand.size();i++ ){
					int indexOfSpace = hand.get(i).indexOf(" ");
					//tellingChar is a character that is a value
					char tellingChar = hand.get(i).charAt(indexOfSpace + 1);
					if(tellingChar == 'A'){
						//adds 1 to the total number of points
						total = total + 1;
					}
					if( tellingChar == 'Q' || tellingChar == 'K' || tellingChar == 'J'){
						//adds 10 to the total points 
						total = total + 10;
					}
					if( tellingChar == '1'){
						if(hand.get(i).charAt(hand.get(i).indexOf('1') + 1)  == '0'){
							//adds 10 to the total points if the tellingChar is 10
							total = total + 10;
						}
						else{
							total = total + 1;
						}
					}
					if(tellingChar !='Q' && tellingChar != 'K' && tellingChar != 'J' && tellingChar != 'A'&& tellingChar != '1'){
						int charToInt= Character.getNumericValue(tellingChar);
						//adds the tellingChar to the total is tellignChar is an integer
						total = total + charToInt;
					}
					} 

				return total;
			}//end of totalPoints()
			
			//action() method allows the user to choose if they want to hit or stand
			public ArrayList<String> action(int bet){
				Dealer dealer = new Dealer();
				Blackjack blackjack = new Blackjack();
				deck = dealer.getDeck();
				Collections.shuffle(deck);
				
					System.out.println(" Would you like to hit or stand?\n");
					System.out.println(" H = hit  S = stand\n");
					System.out.println(" You get a maximum of 3 hits!\n");
					//ask for users input
					Scanner input = new Scanner(System.in);  
					String newAction = input.next();	
					int countHits = 0;
					//if user wants to hit the card is added to the hand
					while(newAction.equals("H" ) ||newAction.equals("h" )&& countHits < 2 ){
						int i = 0;
						String newCardHit = dealer.dealOneCard(deck);
						while( i < hand.size() ){
							
							if(newCardHit.equals(hand.get(i))){
								newCardHit = dealer.dealOneCard(deck);
								i = -1;
							}
						i++	;
					   
						}
						 countHits++;
						//add card to hand
						this.hand.add(newCardHit);
						//returns new hand
						System.out.println("This is your new hand: " + hand + "\n");
						System.out.println("Your new total is " + blackjack.totalPoints(hand)+ "\n");
						System.out.println("Would you like to hit or stand?\n");
						System.out.println("H = hit  S = stand\n");
						Scanner input1 =new Scanner(System.in);  
						 newAction = input1.next();
						
					}
				//returns hand
				return hand;
					
				}
			//computerPlayer() makes the dealers hands and also ask for an action
			//returns an integer
			//parameter of an ArrayList
			public static int computerPlayer(ArrayList<String>deck){
				//dealersHand adds hand 
				ArrayList<String> actionCPU = new ArrayList<String>();
				ArrayList<String> dealersHand = new ArrayList<String>();																																															 
				Dealer dealerCard = new Dealer();
				Blackjack black = new Blackjack();
				int	 count = 0;
				int	 index = 0;
				//while loop adds the cards to dealersHand
				while(count < 2){
					Collections.shuffle(deck);
					//adds cards to dealersCard ArrayList
					String card = dealerCard.dealOneCard(deck);																																																																		  
					dealersHand.add(card);
					count++;																																											 
				}
				//adds the different actions to the actionCPU ArrayList
				System.out.println("The dealer's hand: " + dealersHand + "\n");	
				//hit action
				actionCPU.add("H");
				//stand action
				actionCPU.add("S");
				//double hit action
				actionCPU.add("DH");
				Collections.shuffle(actionCPU);
				//if the first element in the ArraryList actionCPU is equal tothe string H then 
				//add another card from the top of the deck
				if(actionCPU.get(index).equals("H")){ 
					Collections.shuffle(deck);
					String nextCard = dealerCard.dealOneCard(deck);
					dealersHand.add(nextCard);	
					System.out.println("The dealer has decided to hit.\n");
				}
				if(actionCPU.get(index).equals("DH")){
					Collections.shuffle(deck);
					String nextCard = dealerCard.dealOneCard(deck);
					dealersHand.add(nextCard);	
					System.out.println("The dealer has decided to hit.\n");
					Collections.shuffle(deck);
					nextCard = dealerCard.dealOneCard(deck);
					dealersHand.add(nextCard);	
					System.out.println("The dealer has decided to hit again.\n");
				}
				//if the element is not equal to H then the dealer stands and no card is added 
				else{
					System.out.println("The dealer has decided to stand.\n");																														 
				}																								

				System.out.println("The dealer's final hand: " + dealersHand + "\n");
				//calls totalPoints to add up points from the dealers final hand and returns it
				return(black.totalPoints(dealersHand));

			}//end of computerPlayer()
			
			//setter for the deck
			public static void setDeck(ArrayList<String> deck) {
				Blackjack.deck = deck;
			}
			//setter for the hand
			public void setHand(ArrayList<String> hand) {
				this.hand = hand;
			}
			//setter for the jackpot
			public static void setJackpot(int jackpot) {
				Blackjack.jackpot = jackpot;
			}

		}
