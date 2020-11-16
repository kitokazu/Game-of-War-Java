import java.util.LinkedList;
import java.util.Scanner;
/** This class represents a Simulation
*   This represents a simulation of games being played
* @author Kai Itokazu
*/
public class Simulation {
  /**An int representing the number of player 1 wins*/
  private static int player1Wins;
  /**An int representing the number of games played*/
  private int numGames;
  /**An int representing the number of player 2 wins*/
  private static int player2Wins;
  /**An int representing the number of wars*/
  private static int numberOfWars;
  /**A double representing the average number of wars*/
  private static double avgNumWars;
  /**int representing the total number of double wars*/
  private static int numberOfDoubleWars;
  /**A double representing the average number of double wars*/
  private static double avgNumDoubleWars;
  /**An int representing the number of double wars*/
  private static int numRounds;
  /**A double representing the average number of rounds*/
  private static double avgNumRounds;
  /**An int that represents the max number of battles*/
  private static int maxNumBattles;
  /**An int that represents the minimum number of battles*/
  private static int minNumBattles;
  /**An int that represents the max number of wars*/
  private static int maxNumWars;
  /**An int that represents the minimum number of wars*/
  private static int minNumWars;
  /**A Game object that represents a game*/
  private Game game;

  /**This is a default constrcutor
  */
  public Simulation() {
    player1Wins = 0;
    player2Wins = 0;
    numGames = 0;  //NUMBER OF GAMES
    numRounds = 0;
    avgNumWars = 0.0;
    avgNumDoubleWars = 0.0;
    avgNumRounds = 0.0;
    maxNumBattles = 0;
    minNumBattles = 1000;
    maxNumWars = 0;
    minNumWars = 1000;
    game = new Game();
  }

  /**This is an overloaded constructor
  * @param n number of games played. Input from user.
  */
  public Simulation(int n) {
    player1Wins = 0;
    player2Wins = 0;
    numGames = n;
    numRounds = 0;
    avgNumWars = 0.0;
    avgNumDoubleWars = 0.0;
    avgNumRounds = 0.0;
    maxNumBattles = 0;
    minNumBattles = 1000;
    maxNumWars = 0;
    minNumWars = 1000;
    game = new Game();
}
  /** Returns the number of player 1 wins
  * @return number of player 1 wins
  */
  public int getPlayer1Wins() {
    return player1Wins;
  }

  /** Returns the number of player 2 wins
  * @return number of player 2 wins
  */
  public int getPlayer2Wins() {
    return player2Wins;
  }

  /** Returns the number of wars fought
  * @return number of wars
  */
  public int getNumberOfWars() {
    return numberOfWars;
  }

  /** Returns the number of double wars fought
  * @return number of double wars
  */
  public int getNumberOfDoubleWars() {
    return numberOfDoubleWars;
  }

  /**Returns the number of rounds
  * @return number of rounds
  */
  public int getNumberOfRounds() {
    return numRounds;
  }

  /**Returns the max number of battles
  * @return max number of battles
  */
  public int getMaxNumOfBattles() {
    return maxNumBattles;
  }

  /**Returns the minimum number of battles
  * @return minimum number of battles
  */
  public int getMinNumOfBattles() {
    return minNumBattles;
  }

  /**Returns the max number of wars
  * @return max number of Wars
  */
  public int getMaxNumOfWars() {
    return maxNumWars;
  }

  /**Returns the minimum number of wars
  * @return minimum number of Wars
  */
  public int getMinNumOfWars() {
    return minNumWars;
  }

  /** Adds the number of player 1 wins per game
  */
  public void setPlayer1Wins() {
    if (game.getWinner() == 1){
      player1Wins++;
    }
  }

  /** Adds the number of player 2 wins per game
  */
  public void setPlayer2Wins() {
    if (game.getWinner() == 2){
      player2Wins++;
    }
  }

  /** Adds the number of wars per game for the total war count
  */
  public void setNumberOfWars() {
    numberOfWars += game.getWarCount();
  }

  /** Adds the number of double wars per game for the total war count
  */
  public void setNumberOfDoubleWars() {
    numberOfDoubleWars += game.getDoubleWarCount();
  }

  /** Adds the number of rounds per game for a total count
  */
  public void setNumberOfRounds() {
    numRounds += game.getRoundCount();
  }

  /** Gets the max number of battles of the simulation
  */
  public void setMaxNumBattles() {
    if (game.getRoundCount() > maxNumBattles) {
      maxNumBattles = game.getRoundCount();
    }
  }

  /** Gets the minimum number of battles of the simulation
  */
  public void setMinNumBattles() {
    if (game.getRoundCount() < minNumBattles) {
      minNumBattles = game.getRoundCount();
    }
  }

  /** Gets the max number of wars of the simulation
  */
  public void setMaxNumWars() {
    if (game.getWarCount() > maxNumWars) {
      maxNumWars = game.getWarCount();
    }
  }

  /** Gets the minimum number of wars of the simulation
  */
  public void setMinNumWars() {
    if (game.getWarCount() < minNumWars) {
      minNumWars = game.getWarCount();
    }
  }

  /** Simulates the game being played
  * Calls the mutators
  * Resets the war count and round count to 0 after the game is done playing
  */
  public void simulate() {
    game.play();
    setPlayer1Wins();
    setPlayer2Wins();
    setNumberOfWars();
    setNumberOfDoubleWars();
    setNumberOfRounds();
    setMaxNumBattles();
    setMinNumBattles();
    setMaxNumWars();
    setMinNumWars();
    game.setWarCount(0);
    game.setDoubleWarCount(0);
    game.setRoundCount(0);
  }

  /** Calculates the average number of wars and avaerage
  * number of rounds per game for the 20 games that were played
  */
  public void calculate() {
    int warTotal = getNumberOfWars();
    avgNumWars = (double)warTotal/numGames;
    int roundTotal = getNumberOfRounds();
    avgNumRounds = (double)roundTotal/numGames;
    int doubleWarTotal = getNumberOfDoubleWars();
    avgNumDoubleWars = (double)doubleWarTotal/numGames;

  }

  /** Prints the Statistics of the game
  * @return a string that represents the stats of the game
  */
  public void print() {
    String ret = "";
    ret += "\nNumber of Games: " + game.getGameCount();
    ret += "\nAverage Number of battles per game: " + avgNumRounds;
    ret += "\nAverage Number of wars per game: " + avgNumWars;
    ret += "\nAverage Number of double wars per game: " + avgNumDoubleWars;
    ret += "\nMax number of battles: " + maxNumBattles;
    ret += "\nMinimum number of battles: " + minNumBattles;
    ret += "\nMax number of wars: " + maxNumWars;
    ret += "\nMin number of wars: " + minNumWars;
    ret += "\nPlayer 1 Wins: " + getPlayer1Wins();
    ret += "\nPlayer 2 Wins: " + getPlayer2Wins() + "\n";
    System.out.println(ret);

  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the number of games to be played: ");
    int n = scan.nextInt();
    Simulation simulation = new Simulation(n);
    for (int i = 0; i < n; ++i){
      simulation.simulate();
    }
    simulation.calculate();
    simulation.print();
    WarLogger.getInstance().release();
  }


}
