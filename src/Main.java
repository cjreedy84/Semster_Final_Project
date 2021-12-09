//Connor Reedy
//CSC160-179
//Semester Final Project
//December 7, 2021
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Establish score variables for the players
        int player1Score = 0;
        int player2Score = 0;


        //Ask for name of players and prompt input for the names
        System.out.println("Thank you for joining us today! We will start by asking for the names of each player so we can get to know you better. The name of the game we will be playing is 30 or bust. After both players introduce themselves, we will begin by explaining the rules of the game.");

        System.out.println("Player 1, introduce yourself and tell us your name! ");
        String player1Name = input.nextLine();
        System.out.println("Alright Player 2, your turn! Tell us your name!");
        String player2Name = input.nextLine();

        //Print a greeting message and game summary for the players
        System.out.println("Let's welcome players " + player1Name + " and " + player2Name + "!\n");
        System.out.println("The goal of this game is to reach a player score of exactly 30. The first player to score exactly 30 will be victorious.\n");

        System.out.println("Each player will roll a pair of dice, then they must choose the score of one of the dice or the total of the two dice. This value will added to your player score. If your score exceeds 30, your score will be reset to zero. The player turn will change after each roll of the dice. You will claim victory when a score of exactly 30 is reached.\n");

        System.out.println("Take all the time necessary to understand the rules, and then we shall start. When you are ready,press any number or letter key to begin!");


        String startCondition = input.nextLine();



        System.out.println("Let's get started!");

        //Use a while loop to set a guardian condition for the game. In this case, the game shall continue as long as neither of the players score is equal to 30.
        while (player1Score != 30 && player2Score!= 30) {
            System.out.println("Player " + player1Name +"," + " take your turn!");
            System.out.println("Your score is " + player1Score);
            System.out.println("Your roll:");

            //Create new dice objects
            Dice player1dice1 = new Dice();
            Dice player1dice2 = new Dice();

            //Set the value of each dice equal to the random rolling of each dice using diceRoll() function created in Dice.java
            int player1dice1Val = player1dice1.diceRoll();
            int player1dice2Val = player1dice2.diceRoll();

            //Print out the value of each dice, as well as the total using the sumDice() function created in Main.java
            System.out.println(player1Name +"'s" + " Dice 1: " + player1dice1Val);
            System.out.println(player1Name +"'s" + " Dice 2: " + player1dice2Val);
            System.out.println("Total: " + sumDice(player1dice1Val, player1dice2Val));
            System.out.println("Will you (1) Keep die 1, (2) Keep die 2, (3) Keep the total? (Respond with 1 or 2 or 3):");
            int player1Selection = input.nextInt();

            //Switch between the player's possible selection
            switch (player1Selection) {
                case 1: player1Score += player1dice1Val; break;
                case 2: player1Score += player1dice2Val; break;
                case 3: player1Score += sumDice(player1dice1Val, player1dice2Val); break;

            }

            //If the player's score is more than 30, reset score. If it is equal to 30, the player wins
            if (player1Score >30){
                System.out.println("Your total: " + player1Score + "," + "your score has been reset to zero!");
                player1Score =0;

            }else if(player1Score == 30){
                System.out.println("Your total: 30! Congratulations, you are the winner!");
                System.out.println(player1Name + " has achieved victory! The game is now finished.");
                break;

            }

            //Print the player's new total after their turn
            System.out.println("Your total:" + player1Score + "\n" + "------------------------------------");


            //Start processing player 2's turn
            System.out.println("Player " + player2Name +"," + " take your turn!");
            System.out.println("Your score is " + player2Score);
            System.out.println("Your roll:");

            //Create two new dice objects for player 2
            Dice player2dice1 = new Dice();
            Dice player2dice2 = new Dice();

            //Set the value of each dice equal to the value returned by the diceRoll() function created in Dice.java
            int player2dice1Val = player2dice1.diceRoll();
            int player2dice2Val = player2dice2.diceRoll();

            //Display the value of each die, as well as the total of te values
            System.out.println(player2Name + "'s" + " Dice 1: " + player2dice1Val);
            System.out.println(player2Name + "'s" + " Dice 2: " + player2dice2Val);
            System.out.println("Total: " + sumDice(player2dice1Val, player2dice2Val));
            System.out.println("Will you (1) Keep die 1, (2) Keep die 2, (3) Keep the total? (Respond with 1 or 2 or 3):");
            int player2Selection = input.nextInt();

            //Switch between the player's possible selection
            switch (player2Selection) {
                case 1: player2Score += player2dice1Val; break;
                case 2: player2Score += player2dice2Val; break;
                case 3: player2Score += sumDice(player2dice1Val, player2dice2Val); break;

            }
            //If the player's score is more than 30, reset the score. If the score is equal to 30, then the player wins.
            if (player2Score > 30){
                System.out.println("Your total:" + player2Score + "," + "your score has been reset to zero!");
                player2Score = 0;
            }else if(player2Score == 30){
                System.out.println("Your total: 30! Congratulations, you are the winner!");
                System.out.println(player2Name + " has achieved victory! The game is now finished!.");
            }
            //Display the player's total after their turn.
            System.out.println("Your total:" + player2Score + "\n" + "------------------------------------");






        }
    }



    //Method for adding the value of two dice and then returning the sum of those values. Accepts two integer values.
    public static int sumDice(int dice1, int dice2) {
        return (int)(dice1 + dice2);
    }

}