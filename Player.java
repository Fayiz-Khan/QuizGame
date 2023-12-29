
/**
 * Player class will hold the names of the players and the number of points they have 
 *
 * @author (Fayiz Khan)
 * @version (Wednesday, June 14, 2023)
 */

//importing the scanner 
import java.util.Scanner; 

public class Player
{
    //instance variables
    String strName; 
    byte bytPoints; 

    //default constructor
    public Player ()

    {
        bytPoints = 0; 
        strName = null; 

    }

    //constructor initializes the user's name and sets their number of points to zero
    public Player (String strName)

    {

        this.strName = strName; 
        bytPoints = 0; 

    }

    //constructor initializes all values 
    public Player (String strName, byte bytPoints)

    {

        this.strName = strName; 
        this.bytPoints = bytPoints; 

    }

    //method will store and return the values of the player names by calling the playerName method from the input class 
    public static Player[] playerPopulation() {
        //constant to hold the number of players 
        final byte NUM_PLAYERS = 2; 

        //String array to hold the 2 names of the players from the playerName method
        String[] strPlayerNames = Input.playerName();

        //array of type Player to hold the names 
        Player[] players = new Player[NUM_PLAYERS];

        //assigning indexes of players to hold the 2 names of the players
        players[0] = new Player(strPlayerNames[0]);
        players[1] = new Player(strPlayerNames[1]);

        //returning the names of the players
        return players;
    } 

    //toString method to print username and number of points
    public String toString ()

    {

        return "\nPlayer: " + this.strName + "\nPoints: " + this.bytPoints  + "\n"; 

    }

}
