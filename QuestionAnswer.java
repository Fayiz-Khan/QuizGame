
/**
 * This class stores pre dictated easy and hard questions. It will generate either an easy or hard question depending on the difficulty that the user
 * has decided and then prompt the question. It will also update the scores of the players and alternate questions between the players. 
 *
 * @author (Fayiz Khan)
 * @version (Wednesday, June 14, 2023)
 */

//importing Random
import java.util.Random; 

public class QuestionAnswer
{
    //string to hold the questions
    String strQuestion; 
    //array of type string to hold the possible answers
    String strAnswers [];
   
    //boolean to help check if a question has been generated previously
    boolean bolChosen;
    
    //byte to hold the index of the correct answer from the array of possible answers 
    byte bytCorrect; 

    //constructor
    public QuestionAnswer (String strQuestion, String strAnswers [], byte bytCorrect)
    {   this.strQuestion = strQuestion; 
        this.strAnswers = strAnswers; 
        this.bytCorrect = bytCorrect; 
        this.bolChosen = false;
    }
    
    //method where easy questions are being populated 
    public static QuestionAnswer[] easyQuestions () 
    {
        //constant that holds the number of questions 
        final byte NUM_QUESTIONS = 6; 
        //constant array variable of type QuestionAnswer [] being initialized
        final QuestionAnswer [] EASY_QUESTIONS = new QuestionAnswer [NUM_QUESTIONS]; 
        
        //populating each index of EASY_QUESTIONS with a question, possible answers, and the index of the correct answer
        EASY_QUESTIONS[0] = new QuestionAnswer("What is 1 + 1?", new String[]{"1. 2", "2. 3", "3. 4", "4. 5"}, (byte) 0);
        EASY_QUESTIONS[1] = new QuestionAnswer("What is Obama's last name?", new String[]{"1. Barack", "2. Obama", "3. Fayiz", "4. None of the Above"}, (byte) 1);
        EASY_QUESTIONS[2] = new QuestionAnswer("Who is the Canadian Prime Minister?", new String[]{"1. Fayiz", "2. Imran Khan", "3. Trudeau", "4. Obama"}, (byte) 2);
        EASY_QUESTIONS[3] = new QuestionAnswer("What school does Fayiz go to?", new String[]{"1. John McDonald", "2. Fayiz has graduated", "3. HelloWorld Academy", "4. John McCrae"}, (byte) 3);
        EASY_QUESTIONS[4] = new QuestionAnswer("What is 3 x 5?", new String[]{"1. 14", "2. 15", "3. 16", "4. 17"}, (byte) 1);
        EASY_QUESTIONS[5] = new QuestionAnswer("What is 3 x 2?", new String[]{"1. 6", "2. 10", "3. 11", "4. 12"}, (byte) 0);
        
        //returning the easy questions 
        return EASY_QUESTIONS; 
    }

    //method where hard questions are being populated 
    public static QuestionAnswer [] hardQuestions () 
    {
        //constant that holds the number of questions 
        final byte NUM_QUESTIONS = 6; 
        //constant array variable of type QuestionAnswer [] being initialized
        final QuestionAnswer [] HARD_QUESTIONS = new QuestionAnswer [NUM_QUESTIONS]; 
        HARD_QUESTIONS[0] = new QuestionAnswer("What is the capital of Switzerland?", new String[]{"1. Benin", "2. Lasaur", "3. Geneva", "4. Bern"}, (byte) 3);
        HARD_QUESTIONS[1] = new QuestionAnswer("When was Kanye West's first album released?", new String[]{"1. 2003", "2. 2004", "3. 1999", "4. 2006"}, (byte) 1);
        HARD_QUESTIONS[2] = new QuestionAnswer("Napoleon suffered defeat at Waterloo in what year?", new String[]{"1. 1809", "2. 1813", "3. 1865", "4. 1815"}, (byte) 3);
        HARD_QUESTIONS[3] = new QuestionAnswer("Emetophobia is the fear of what?", new String[]{"1. Heights", "2. Vomit", "3. Bats", "4. Fear itself"}, (byte) 1);
        HARD_QUESTIONS[4] = new QuestionAnswer("What sea is next to Saudi Arabia?", new String[]{"1. Mediterranean Sea", "2. Coral Sea", "3. Red Sea", "4. Caribbean Sea"}, (byte) 2);
        HARD_QUESTIONS[5] = new QuestionAnswer("What is Fayiz's middle name?", new String[]{"1. Idris", "2. Mohammed", "3. Khan", "4. Doesn't have one"}, (byte) 3);
        
        //returning the hard questions 
        return HARD_QUESTIONS; 
    }

    //method that generates an easy question by calling the easyQuestionsMethod and then returns a question 
    public static QuestionAnswer generateEasy(QuestionAnswer[] easyQuestion) {
        //constant to hold the range of the random generated integer. Set at 5 because thats the max index of the easy and hard questions
        final int RANDOM_NUMBER = 6; 
        //integer to hold random generated index
        int intRandIndex; 
        //variable of typeQuestionAnswer that calls the easyQuestions method and holds the easy questions
        
        //generating random number and having it equal intRandIndex
        //ensuring same question won't be generated again
        Random rand = new Random();
        do {
            intRandIndex = rand.nextInt(RANDOM_NUMBER);
        } while (easyQuestion[intRandIndex].bolChosen);
        
        //returning a random easyQuestion
        easyQuestion[intRandIndex].bolChosen = true;
        return easyQuestion[intRandIndex];
    }
    
    //method that generates a hard question by calling the hardQuestionsMethod and then returns a question 
    public static QuestionAnswer generateHard(QuestionAnswer[] hardQuestion)
    {
        //constant to hold the range of the random generated integer. Set at -0-5 because thats the max index of the easy and hard questions
        final int RANDOM_NUMBER = 6; 
        //integer to hold random generated index
        int intRandIndex; 
        
        //variable of typeQuestionAnswer that calls the hardQuestions method and holds the hard questions
        
        //generating random number and having it equal intRandIndex
        //ensuring same question won't be generated again
        Random rand = new Random();
        do {
            intRandIndex = rand.nextInt(RANDOM_NUMBER);
        } while (hardQuestion[intRandIndex].bolChosen);
        
        //returning a random easyQuestion
        hardQuestion[intRandIndex].bolChosen = true;
        return hardQuestion[intRandIndex];
    }

    //method will print either an easy or hard depending on the parameters of what difficulty the user selected
    //questions will alternate between player 1 and player 2 and update their points
    public static void questionsPrompt (byte bytDifficultySelect, Player player1, Player player2) {
        
        //this byte will compare the user's input to the correct index of the question to verify if the question is correct or not
        byte bytAnswerVerification = 0;
        //variable of type QuestionAnswer that will hold the randomly generated question 
        QuestionAnswer randomQuestion = null;
        // variable of type player to keep track of which player's turn it is (either player 1 or 2)
        Player currentPlayer;
        
        // variables easyQuestions and hardQuestions of type QuestionAnswer[] cslling the easyQuestions and HardQuestions methods
        QuestionAnswer[] easyQuestions = easyQuestions();
        QuestionAnswer[] hardQuestions = hardQuestions();
        
        //looping through the questions 
        for (byte bytCounter = 0; bytCounter < 6; bytCounter++) {
            
            //if statement makes the players alternate questions because there will be a remainder of 1 whenever the counter is an odd number
            //which is half the time
            if (bytCounter % 2 == 0) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            
            
            //if statement taking in the user's selected difficulty to then either assign randomQuestion to either and easy 
            //or hard question
            if (bytDifficultySelect == 1) {
                randomQuestion = generateEasy(easyQuestions);
            } else {
                randomQuestion = generateHard(hardQuestions);
            }
            
            //printing the question for the designated player
            System.out.println("\nQuestion " + (bytCounter + 1) + " for " + currentPlayer.strName);
            System.out.println("\n" + randomQuestion.strQuestion);
            
            //for each loop going through all the possible answers to the question 
            for (String strPossibleAnswers : randomQuestion.strAnswers) {
                System.out.println(strPossibleAnswers);
            }
            
            //prompting userAnswer method to take in the user's response to the mc question and setting the returned value to bytAnswerVerification 
            bytAnswerVerification = Input.userAnswer();

            //compares the users inputted answer to the correct index of the question 
            //updates the points of the player
            if (bytAnswerVerification == randomQuestion.bytCorrect) {
                System.out.println("You get a point because that's right :)");
                currentPlayer.bytPoints++;
            } else {
                System.out.println("That's incorrect :(");
            }
        }
    }
}

