
/**
 * Test class where the game will run. Names will be populated, questions will be generated and prompted, a winner will be declared
 * and the user will have the option to play again
 *
 * @author (Fayiz Khan)
 * @version (Wednesday, June 14, 2023)
 */

//importing scanner
import java.util.Scanner; 

public class TriviaGame {
    public static void main(String[] args) {
        //variable of type byte to store the difficulty selection of the user
        byte bytDifficultySelection;

        //array of type player to initialize the players
        Player[] players; 

        //boolean for whether the user wants to play again
        boolean bolPlayAgain = true; 

        //do while loop if they wish to keep playing
        do{
            //clearing 
            System.out.print("\u000C"); 

            //intro message
            introMessage(); 

            //Populating the names of the players
            players = Player.playerPopulation();

            //Selecting the difficulty
            bytDifficultySelection = Input.difficultySelection();

            //Prompting answers to randomly generated questions
            QuestionAnswer.questionsPrompt(bytDifficultySelection, players[0], players[1]);

            //printing out names and scores
            System.out.print("\u000C");  
            System.out.print(players [0]); 
            System.out.println(players [1]); 

            //checking for the winner
            checkWinner(players); 

            //Asking the user if they would like to play again
            bolPlayAgain = Input.playAgain();

        } while(bolPlayAgain); 

        //Exit message before the code ends 
        exitMessage(); 

    }

    //void method that compares the point values of the two players and then announces the one with more points as the winner 
    public static void checkWinner (Player [] players)
    {
        if (players[0].bytPoints > players [1].bytPoints)

        {

            System.out.println("\n" + players[0].strName + " is the winner!"); 

        }
        if (players[1].bytPoints > players [0].bytPoints)
        {
            System.out.println("\n" + players[1].strName + " is the winner!"); 

        }

        else if (players[0].bytPoints == players [1].bytPoints)

        {

            System.out.println("\nIt is a draw!"); 

        }
    } 

    //exiting message to the user
    public static void exitMessage()

    {

        System.out.println("\nThanks for playing, have a great day"); 

    }

    //introduction message to the user 
    public static void introMessage()

    {

        System.out.println("Welcome to Fayiz's 2 player quiz game!\n"); 

    }
}

