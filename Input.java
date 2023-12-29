
/**
 * This is the Input class where methods will be called to take user input to populate the names of the players, whether the user wants easy 
 * or hard questions, prompt them for their response to the multiple choice questions and take input on whether they want to play again. 
 *
 * @author (Fayiz Khan)
 * @version (Wednesday, June 14, 2023)
 */

//importing scanner 
import java.util.Scanner; 


//this class will store and return the input 
public class Input
{
    //This method will store the names of the players and then return it so that the player names can then by populated in an array in the main
    //using the returned values 
    public static String [] playerName ()
    {
        //constant of type byte that stores the number of players 
        final byte NUM_PLAYERS = 2; 
        
        //Array of type string being declared and initialized with the number of players
        String [] strPlayerName = new String [NUM_PLAYERS]; 
        
        //for loop that cycles through the array that prompts the user and then holds their names in the array
        for (byte bytCounter = 0; bytCounter < strPlayerName.length; bytCounter++)

        {
            System.out.println("Player " + (bytCounter+1) + ": what is your name"); 
            strPlayerName[bytCounter] = new Scanner (System.in).nextLine(); 
        }

        //returning the names 
        return strPlayerName;

    }

    //this method prompts the user to type in whether they would like easy or hard questions and then returns a byte that corresponds to their 
    //decision. Try catch to make sure they type in a byte, if statements to make sure that the byte they enter is a 1 or a 2. 
    //do while loop so that the code keeps going until a valid input is reached
    //method will be called in the main 
    
    public static byte difficultySelection()

    {
        //byte to store if they type in a 1 or 2 (easy or hard)
        byte bytDifficulty = 0; 
        
        //boolean for tryCatch. Makes sure that the do while loop only ends if a valid input is reached. 
        boolean bolTryCatch; 
        
        //prompting the user
        System.out.println("Type 1 for easy questions and 2 for difficult questions");

        //do while loop conditional on the user typing 1 or 2
        do{ 
            try {
                bytDifficulty = new Scanner (System.in).nextByte(); 
                bolTryCatch = true; 

                if (bytDifficulty != 1 && bytDifficulty != 2)

                {

                    System.out.println("Invalid input, type either 1 or 2"); 
                    bolTryCatch = false; 

                }
            }
            catch (Exception e)
            {
                System.out.println("Make sure you're either typing 1 or 2!");
                bolTryCatch = false; 

            }
        } while (bolTryCatch == false); 

        //returning user selection. 
        return bytDifficulty; 
    }

    //method to store the user answer. 
    //user will be prompted to type 1,2,3,4 and do while loop will run until one of these numbers is typed
    // the number they type will be converted to an index so that the user's answer can be compared to the correct answer index of the 
    //multiple choice question being asked.
    
    public static byte userAnswer()
    {
        //byte to store user answer
        byte bytUserAnswer = 0;
        //boolean for try catch 
        boolean bolTryCatch;

        //do while loop with try catch until 1,2,3, or 4 is typed
        do {
            try {
                System.out.println("\nType 1, 2, 3, or 4:");
                bytUserAnswer = new Scanner(System.in).nextByte();
                bolTryCatch = true;

                if (bytUserAnswer < 1 || bytUserAnswer > 4) {
                    System.out.println("\nInvalid input. Type 1, 2, 3, or 4.");
                    bolTryCatch = false;
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input. Type 1, 2, 3, or 4.");
                bolTryCatch = false;
            }
        } while (!bolTryCatch);

        //converting user response to the index of the correct answer in the QuestionAnswer class
        //returning said value
        if (bytUserAnswer == 1) {
            return 0;
        } else if (bytUserAnswer == 2) {
            return 1;
        } else if (bytUserAnswer == 3) {
            return 2;
        } else {
            return 3;
        }
    }

    //method to prompt the user if they wish to play again. There is a try catch to make sure they type either yes or no
    //returning true or false so that when this method is called in the main it's returned value can dictate whether or not to loop the code again
    //if the user wishes to keep playing
    
    public static boolean playAgain() {
        //String to hold yes or no to see if they want to play again
        String strPlayAgain;
        //boolean for error trapping so that the dowhile loop knows if it needs to repeat again depending if there was invalid input
        boolean bolErrorTrap = false;
        //boolean to return true or false to notify whether the user wishes to run the code again.
        boolean bolYesNo = false; 

        // do while loop that prompts the user on whether they want to play again and makes syre they type yes or no
        do {
            System.out.println("Type 'yes' if you wish to play again, or 'no' if you would wish to stop");
            strPlayAgain = new Scanner(System.in).nextLine();

            if (strPlayAgain.equalsIgnoreCase("yes")) {
                bolErrorTrap = true;
                bolYesNo = true;
            } else if (strPlayAgain.equalsIgnoreCase("no")) {
                bolErrorTrap = true;
                bolYesNo = false;
            } else {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
                bolErrorTrap = false; 
            }
        } while (!bolErrorTrap);
        
        //return boolean 
        return bolYesNo; 
    }
}

