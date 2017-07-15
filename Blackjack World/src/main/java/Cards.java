package java;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cards {
	// Set two fields for the suit and the face of the cards.
	// Both are ArrayList
	// The a=ArrayList suit holds the suits of the cards.	
	// The ArraryList numbers holds the numbers that the cardshave and also the face of the cards.
	
	private String[] suit;
	private String[] numbers;
	//This is the constructor for the Cards class.
	public Cards(){
		
		 this.suit = new String[4];
		 this.numbers = new String[13];
	}
	// setSuit() adds the different suits of cards to the ArrayList suit
	// Has no paramenters
	// Does not return anything
	public  void  setSuit(){
		//adds heart to suit
		this.suit[0] = "Heart"; 
		//adds Spades to suit
		this.suit[1] = "Spades";
		//adds Clubs to suit
		this.suit[2] = "Clubs";
		//adds Diamonds to suit
		this.suit[3] = "Diamonds";
	} //end of setSuit()
	// setNumbers() adds the different numbers and also face, such as Ace, King and Queen, to the ArrayList numbers.
		// Has no parameters
		// Does not return anything
		public  void setNumbers(){
			//for loop allows faces and number to be added too the ArrayList in order
			for(int i = 1; i<14; i++){
				// adds Ace in the first index of the ArrayList
				if (i == 1){
					this.numbers[0] = "Ace";
				}
				// adds integers 2-10 in the indexs 1 to 10 of the ArrayList
				if( i > 1 && i < 11) {
					this.numbers[i-1] = Integer.toString(i);
				}
				// adds the face value Jack to the index 11
				if(i == 11){
					this.numbers[i-1] = "Jack";
				}
				// adds the face value Queen to the index 12
				if(i == 12){
					this.numbers[i-1] = "Queen";
					}
				// adds the face value King to the index 13
				if(i == 13){
					this.numbers[12] = "King";
				}
			}// end of the for loop
		}// end of setNumbers()
		
		// makeDeck() combines the suit and numbers ArrayList elements to make cards
		// and adds the cards to the ArrayList deck
		// returns an ArrayList deck
		
		public ArrayList<String> makeDeck(){
			int counter = 0;// controls the while loop and also lets us know where we are in the numbers[] array.
			ArrayList<String> deck =  new ArrayList<String>(); // ArrayList whos element are cards
			// for loop that combines the elements from suit and numbers
			for(int i = 0; i < 4; i++){
				while(counter < 13){
					String cardName = suit[i] + " " + numbers[counter];
					// add the card to the deck ArrayList
					deck.add(cardName);
					counter++;
					}
					counter = 0;//resets counter
				}
			return deck;
			}// end of makeDeck()
	}// end of Cards class
