/** This class represents a card
*   it takes in a number from the deck class
*   and returns a card with its unique suit and rank.
*  @author Kai Itokazu
*/
public class Card {
    /**An array of Strings representing each suit in a deck of cards*/
    private final String[] suit = {"Hearts","Diamonds","Spades","Clubs"};
    /**An array of Strings representing the ranks in the deck of cards*/
    private final String[] rank = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
    /**An int representing the cardNumber from 0-51.
    *  This number is used to deteremione what card the
    *  number is referring to.
    */
    private int cardNumber;
    /**This is rank number that determines the cards value from 2-14.*/
    private int rankNumber;

    /** This is a default constructor
    */
    public Card() {
      cardNumber = 0;
      rankNumber = 0;
    }

    /** Overlaoded Card constructor
    * @param cNum int representing the Card Number from 0-51
    */
    public Card(int cNum)  {
      cardNumber = cNum;
      rankNumber = 0;
    }

    /** Returns the card number
    * @return card number
    */
    public int getCardNumber() {
      return cardNumber;
    }

    /** Returns the card suit
    * If the card number is less than 13 it
    * returns hearts. If the number is between
    * 13 and 25, it returns diamonds. If the number
    * is between 26 and 38, it returns Spades. And
    * if the number is over 39, then it returns clubs.
    * @return suit of the card
    */
    public String getSuit() {
      if (cardNumber < 13) {
        return suit[0];
      }
      else if (cardNumber >= 13  && cardNumber < 26) {
        return suit[1];
      }
      else if (cardNumber >= 26  && cardNumber < 39) {
        return suit[2];
      }
      else {
        return suit[3];
      }
    }

    /** Returns the card rank
    * The cardNumber 0-51 is divided by 13
    * and returns the rank depending on the remainder.
    * Therefore it is able to loop every 13 ranks.
    * @return rank of the card
    */
    public String getRank() {
      return rank[cardNumber%13];
    }

    /** Returns the rank number/value as an int
    * The value of the card is the remainder of the card number
    * when it divides by 13, plus 2.
    * @return rank number or value of the card
    */
    public int getRankNumber() {
      rankNumber = (cardNumber%13 + 2);
      return rankNumber;
    }

    /** Sets the card rank
    */
    public void setRank() {
    }

    /** Sets the Card number to cNum
    * @param cNum the unique card number
    */
    public void setCardNumber(int cNum) {
      cardNumber = cNum;
    }

    /** Sets the card suit
    */
    public void setSuit() {
    }

    /** Sets the rank number/value
    */
    public void setRankNumber() {

    }

    /** Creates a string representation of the Card
    * @return A formatted string with the card's attributes
    */
    public String toString() {
      return(getRank()  + " of " + getSuit());
    }

}
