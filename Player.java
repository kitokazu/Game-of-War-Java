import java.util.LinkedList;
import java.util.Collections;
/** This class represents a player that is playing the game
 * @author Kai Itokazu
*/
public class Player {
  /**A LinkedList of Cards that represents the player's current hand of cards*/
  private LinkedList<Card> currentHand;
  /**An array of cards that represents the three cards drawn and is used for the war logger*/
  private Card[] activeHand;
  /**A LinkedList of cards that represents the card pile*/
  private static LinkedList<Card> pile;
  /**An int that represents the player number 1 or 2*/
  private int playerNum;
  /**A Deck object that represents the deck class*/
  private static Deck newCard;
  /**An int that counts to keep track of the cards*/
  private int count;

  /** This is a default constructor
  */
  public Player() {
    currentHand = new LinkedList<Card>();
    pile = new LinkedList<Card>();
    activeHand = new Card[0];
    playerNum = 0;
    count = 0;
    newCard = new Deck();
  }
  /** Overloaded player constructor
  * @param pNum int represneting the player number
  */
  public Player(int pNum) {
    currentHand = new LinkedList<Card>();
    pile = new LinkedList<Card>();
    activeHand = new Card[3];
    playerNum = pNum;
    count = 0;
    newCard = new Deck();
    }

  /** Returns the array of three cards that are drawn
  * @return active hand cards
  */
  public Card[] getActiveHand() {
    return activeHand;
  }

  /** Returns the list of cards of the players current hand
  * @return current hand of cards
  */
  public LinkedList<Card> getCurrentHand() {
    return currentHand;
  }

  /** Deals a random card from the deck and adds to current hand
  */
  public void addCard() {
    currentHand.add(newCard.deal());
  }

  /** Sets the players active hand
  */
  public void setActiveHand() {
  }

  /** Sets the players total current hand
  */
  public void setCurrentHand() {
  }

  /** Collects the cards from the pile and adds it
  * to the players curent hand
  */
  public void collect() {
    Collections.shuffle(pile);
    for (int i = 0; i < pile.size(); ++i) {
      Card p = pile.get(i);
      getCurrentHand().add(p);
    }
    pile.clear();
  }


  /** Returns the median of the 3 cards drawn
  * @return median of the 3 cards
  */
  public int getMedian() {
    int median = 0;
    if(getCurrentHand().size() >= 3) {
      Card c1 = flip();
      Card c2 = flip();
      Card c3 = flip();
      int value1 = c1.getRankNumber();
      activeHand[0] = c1; //Adds the card to the array of activehand
      int value2 = c2.getRankNumber();
      activeHand[1] = c2;
      int value3 = c3.getRankNumber();
      activeHand[2] = c3;

      if (value1 > value2) {
        if (value2 > value3){
            median = value2;
        } else if (value1 > value3) {
            median = value3;
        } else {
           median = value1;
         }
      }
      else {
        if (value1 > value3) {
          median = value1;
        } else if (value2 > value3) {
          median = value3;
        } else
          median = value2;
        }
  }
  else if (getCurrentHand().size() == 2) {
    Card c1 = flip();
    Card c2 = flip();
    int value1 = c1.getRankNumber();
    activeHand[0] = c1;
    int value2 = c2.getRankNumber();
    activeHand[1] = c2;
    if (value1 > value2) {
      median = value1;
    }
    else {
      median = value2;
    }


  } else {
    Card c1 = flip();
    int value1 = c1.getRankNumber();
    activeHand[0] = c1;
    median = value1;
  }
  return median;
  }

  /** Returns the top card of the current Hand
  * @return top card of the current hand of cards
  */
  public Card flip() {
    pile.add(currentHand.get(0));
    return currentHand.remove(0);
  }

  /** Returns true or false if the player has won
  * @return true if the player has 52 cards and false otherwise
  */
  public boolean hasWon() {
    if (currentHand.size() == 52) {
      return true;
    }
    else {
      return false;
    }
  }

  /** Returns the rank number of the top card for war
  * @return the rank number of the top card for war
  */
  public int war() {
    return(flip().getRankNumber());
  }
}
