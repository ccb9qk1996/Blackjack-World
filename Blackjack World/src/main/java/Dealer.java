package java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {

	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		ArrayList<String> deck = new ArrayList<String>();
		String test = dealer.dealOneCard(deck);
		System.out.println(test);
	}
	// Field deck is a an ArrayList that holds cards from the class Cards.
	// Field counter controls how any times dealOneCard() gets accessed.  
	
	private ArrayList<String> deck;
	private int counter;
	// This is the constructor for the Dealer class.
	public Dealer(){
		
		this.deck = deck;
		this.counter = 0;
		}
	// getDeck() calls the makeDeck() from the  Cards class
	// Returns an ArrayList
	public ArrayList<String> getDeck(){
		Cards cards = new Cards();
		cards.setNumbers();
		cards.setSuit();
		// calls makeDeck() to set deck ArrayList
		this.deck = cards.makeDeck();
		return deck;
	} // end of getDeck()
	// shuffle() puts the elements of deck ArrayList in a random order
		// Does not return a value
		// Has no parameters
		public void shuffle(ArrayList<String> deck){
			Collections.shuffle(deck);
		}
		// dealOnecard() returns the first element in the ArrayList deck
		// It has one paramenter which is the ArrayList deck
		public String dealOneCard(ArrayList<String> deck){
			if(counter < 53){
					String cards = deck.get(0);
					//removes the card that was dealt
					deck.remove(counter);
					//adds to counter
					counter++;
					return cards;
				}
			
				return("There are no more cards.");
				}// end of dealsOneCard()
		
	}// end of Dealer() class
		


