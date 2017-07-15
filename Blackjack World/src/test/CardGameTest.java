import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CardGameTest {

	@Test
	//This method test the makeDeck() method.
	public void testMakeDeck() {
		Cards cards = new Cards();
		cards.setSuit();
		cards.setNumbers();
		ArrayList<String> deck = new ArrayList<String>(); 
		deck = cards.makeDeck();
		System.out.println(deck);
		String supposedToBe = "[Heart Ace, Heart 2, Heart 3, Heart 4, Heart 5, Heart 6, Heart 7, Heart 8, Heart 9, Heart 10, Heart Jack, Heart Queen, Heart King, Spades Ace, Spades 2, Spades 3, Spades 4, Spades 5, Spades 6, Spades 7, Spades 8, Spades 9, Spades 10, Spades Jack, Spades Queen, Spades King, Clubs Ace, Clubs 2, Clubs 3, Clubs 4, Clubs 5, Clubs 6, Clubs 7, Clubs 8, Clubs 9, Clubs 10, Clubs Jack, Clubs Queen, Clubs King, Diamonds Ace, Diamonds 2, Diamonds 3, Diamonds 4, Diamonds 5, Diamonds 6, Diamonds 7, Diamonds 8, Diamonds 9, Diamonds 10, Diamonds Jack, Diamonds Queen, Diamonds King]";
		assertTrue( deck.equals(cards.makeDeck()));
	}
	@Test
	public void testGetDeck(){
		Cards cards = new Cards();
		cards.setSuit();
		cards.setNumbers();
		ArrayList<String> deck = new ArrayList<String>(); 
		deck = cards.makeDeck();
		System.out.println(deck);
		String supposedToBe = "[Heart Ace, Heart 2, Heart 3, Heart 4, Heart 5, Heart 6, Heart 7, Heart 8, Heart 9, Heart 10, Heart Jack, Heart Queen, Heart King, Spades Ace, Spades 2, Spades 3, Spades 4, Spades 5, Spades 6, Spades 7, Spades 8, Spades 9, Spades 10, Spades Jack, Spades Queen, Spades King, Clubs Ace, Clubs 2, Clubs 3, Clubs 4, Clubs 5, Clubs 6, Clubs 7, Clubs 8, Clubs 9, Clubs 10, Clubs Jack, Clubs Queen, Clubs King, Diamonds Ace, Diamonds 2, Diamonds 3, Diamonds 4, Diamonds 5, Diamonds 6, Diamonds 7, Diamonds 8, Diamonds 9, Diamonds 10, Diamonds Jack, Diamonds Queen, Diamonds King]";
		assertTrue( deck.equals(cards.makeDeck()));
	}
	@Test
	public void testDealOneCard(){
		Cards cards = new Cards();
		Dealer dealer = new Dealer();
		ArrayList<String> deck = new ArrayList<String>(); 
		
		deck = dealer.getDeck();
		dealer.shuffle(deck);
		System.out.println(deck);
		String firstCardName = dealer.dealOneCard(deck);
		System.out.println(firstCardName);
		String secondCardName = dealer.dealOneCard(deck);
		System.out.println(secondCardName);
		assertTrue( firstCardName != secondCardName );
		}
	@Test
	public void testDealOneCardSecond(){
				Cards cards = new Cards();
				Dealer dealer = new Dealer();
				ArrayList<String> deck = new ArrayList<String>(); 
				
				int counter = 0;
				String except = "";
				deck = dealer.getDeck();
				dealer.shuffle(deck);
				
				
				while( counter < 54){
					
						except = dealer.dealOneCard(deck);
						System.out.println(except);
						counter++;
					}
				
				assertTrue(except.equals( "There are no more cards."));
		}
	@Test
	public void testCreateHand(){
		Blackjack blackjack = new Blackjack();
		Dealer dealer = new Dealer();
		ArrayList<String> hand = new ArrayList<String>();
		ArrayList<String> deck = new ArrayList<String>();
		
		deck = dealer.getDeck();
		hand = blackjack.createHand();
		
		System.out.println(deck);
		System.out.println(hand);
	}
	@Test
	public void testAction(){
		Blackjack blackjack = new Blackjack();
		Dealer dealer = new Dealer();
		ArrayList<String> hand = new ArrayList<String>();
		ArrayList<String> deck = new ArrayList<String>();
		int bet = 0;
		
		deck = dealer.getDeck();
		hand = blackjack.createHand();
		bet = blackjack.bet();
		
		
		
	}
	@Test
	public void testTotalPoints(){
		Blackjack blackjack = new Blackjack();
		ArrayList <String> startingPlayersHand = new ArrayList<String>();
		ArrayList <String> playersHand = new ArrayList<String>();
		
		int bet = blackjack.bet();
		startingPlayersHand = blackjack.createHand();
		int startingTotal = blackjack.totalPoints(startingPlayersHand);
		
		System.out.println("This is your starting hand: " + startingPlayersHand + "\n");
		System.out.println("This is your starting total: " + startingTotal);
		
		playersHand = blackjack.action(bet);
		int newTotal = blackjack.totalPoints(playersHand);
		
		System.out.println("This is your new hand: " + playersHand);
		System.out.println("This is new total: " + newTotal);
	}
}
