import java.util.LinkedList;
/** This class represents a Game
*   This represents a game being played
* @author Kai Itokazu
*/
public class Game {

  /**An int representing the winner 1 if player 1 won and 2 if player 2 won*/
  private int winner;
  /**An int that represents the war count*/
  private int warCount;
  /**An int that represents double wars*/
  private int doubleWarCount;
  /**An int that represents the round count*/
  private int roundCount;
  /**An int that represents the game count*/
  private static int gameCount;

  /** This is a default constructor
  */
  public Game() {
    winner = 0;
    warCount = 0;
    doubleWarCount = 0;
    roundCount = 0;
    gameCount = 0;
  }

  /** Returns the int of the winner
  * @return 1 if player 1 wins and 2 if player 2 wins
  */
  public int getWinner() {
    return winner;
  }

  /** Returns the int of the war count
  * @return the number of wars fought for that game
  */
  public int getWarCount() {
    return warCount;
  }

  /** Returns the int of the war count
  * @return the number of double wars fought for that game
  */
  public int getDoubleWarCount() {
    return doubleWarCount;
  }

  /** Returns the int of the round count
  * @return the number of rounds played for that game
  */
  public int getRoundCount() {
    return roundCount;
  }

  /** Returns the game number that being played
  * @return the game number for that game
  */
  public int getGameCount() {
    return gameCount;
  }

  /** Sets the war count to w
  * @param w war count
  */
  public void setWarCount(int w) {
    warCount = w;
  }

  /** Sets the war count to w
  * @param dw war count
  */
  public void setDoubleWarCount(int dw) {
    doubleWarCount = dw;
  }

  /** Sets the rount count to r
  * @param r round count
  */
  public void setRoundCount(int r) {
    roundCount = r;
  }

  /** Sets the game count
  */
  public void setGameCount() {
  }

  /** The play method where the game is played
  * the cards are distributed and the rounds are played.
  * Also writes to the war logger
  */
  public void play(){

    Player player1 = new Player(1);
    Player player2 = new Player(2);
    for (int i = 0; i < 26; ++i) {
      player1.addCard();
      player2.addCard();
    }
    while(true) {
      if ((player1.hasWon() == false) && (player2.hasWon() == false)) {

        int d1 = player1.getMedian();
        Card[] h1 = player1.getActiveHand();
        int d2 = player2.getMedian();
        Card[] h2 = player2.getActiveHand();
        roundCount++;

        WarLogger.getInstance().logBattle(getRoundCount(),WarLogger.P1,h1);
        WarLogger.getInstance().logBattle(getRoundCount(),WarLogger.P2,h2);

        if (d1 > d2) {
          player1.collect();
          WarLogger.getInstance().logBattleOutcome(getRoundCount(),WarLogger.P1);

        }
        else if (d1 < d2) {
          player2.collect();
          WarLogger.getInstance().logBattleOutcome(getRoundCount(),WarLogger.P2);
        }
        else { //This is where war occurs
          warCount++;
          while(true){
            if (player1.getCurrentHand().size() <= 3) { //If the size of player deck is less than 3, they cannot have cards to war against
              player2.collect();
              WarLogger.getInstance().logWarOutcome(getWarCount(),WarLogger.P2);
              break;
            }
            else if (player2.getCurrentHand().size() <= 3) {
              player1.collect();
              WarLogger.getInstance().logWarOutcome(getWarCount(),WarLogger.P1);
              break;
            }
            int w1 = player1.war();
            int w2 = player2.war();

            if(w1 > w2) {
              player1.collect();
              WarLogger.getInstance().logWarOutcome(getWarCount(),WarLogger.P1);
              break;
            }
            else if(w2 > w1) {
              player2.collect();
              WarLogger.getInstance().logWarOutcome(getWarCount(),WarLogger.P2);
              break;
            } else { //This is where a double war would occur
              doubleWarCount++;
              continue;
            }
          }
        }

      }
      else if (player1.hasWon() == true) {
        winner = 1;
        gameCount++;
        WarLogger.getInstance().logGameOutcome(getGameCount(),WarLogger.P1);
        break;
      } else if (player2.hasWon() == true) {
        winner = 2;
        gameCount++;
        WarLogger.getInstance().logGameOutcome(getGameCount(),WarLogger.P2);
        break;
      }
    }

}

}
