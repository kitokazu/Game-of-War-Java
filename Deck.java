import java.util.LinkedList;
/** This class represents a deck of cards
* @author Kai Itokazu
*/
public class Deck {

  /**A static LinkedList of Cards representing the deck*/
  private static LinkedList<Card> deck;

  /** This is the default constructor
  */
  public Deck() {
    deck = new LinkedList<Card>();
    for (int i = 0; i < 52; ++i) {
      deck.add(new Card(i));
    }
  }

  /** A method that returns a random card from the deck of 52 cards
  * @return the random card from the deck
  */
  public Card deal() {
    int random = (int)(Math.random()*deck.size());
    return deck.remove(random);

    }
}
