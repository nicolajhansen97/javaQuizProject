import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class main {

    static Scanner in = new Scanner(System.in);
    static int playerOnePoint = 0; //Counter of the points for player 1
    static int playerTwoPoint = 0; //Counter of the points for player 2
    static int playerTreePoint = 0; //Counter of the points for player 3
    static int playerFourPoint = 0; //Counter of the points for player 4
    static int playerCount = 1; //Counter for which players turn it is
    static int questionNumber = -1; //Indicate the question that is gonna be used
    static int twoPlayerQuestionAmount = 10; //Decides how many questions a 2 player game should have
    static int treePlayerQuestionAmount = 15; //Decides how many questions a 3 player game should have
    static int fourPlayerQuestionAmount = 20; //Decides how many questions a 4 player game should have
    static ArrayList<Integer> questionUsed = new ArrayList<>(); //An ArrayList to store all the questions that is already used
    static Random RandomNumber = new Random(); //To generate a random number
    static int checkNumber = RandomNumber.nextInt(20); //Makes the bound of how many question that should be generated
    static String answer = ""; //Takes the users input if the question is true or false
    static String[] questions = {"JAVA is an object-oriented programming language", "&& is an Unary Operator", ">= is an relational operator", "The Random Generator is 100% random", "If we declare int [ ] ar = {1,2,3,4,5,6}; The size of array ar is: 5", "A loop can run a specified amount of times", "A class can be transient", "The default statement of a switch is always executed", "A class is an abstract definition of an object", "Given the declaration: int[ ] ar = {1,2,3,4,5}; The value of ar[4]? is 4", "The size of a Char in Java is 16 bits", "The following statement: String word = \"abcde\"; for (int i = 0; i <4; i+=2) System.out.print(word[i]); will print out: Ac", "Inner classes can be defined within methods", "The following code: int num = 6.7; will make the number 6.7", "Java keywords are written in lowercase as well as uppercase", "You can compare a boolean to an Integer", "The keyword to create a object in Java is:  \"new\"", "An Applet is a java program that run through a web-browser", "Java only runs on Windows and Mac", "Modules gives you the leftover"}; //The questions
    static String[] answers = {"true", "false", "true", "false", "false", "true", "false", "false", "true", "false", "true", "true", "true", "false", "false", "false", "true", "true", "false", "true"}; //The answers to the question

    public static void main(String[] args) {

        int gameOrNot = -1;

        while (true) {
            System.out.println("*------------------------------------------*");
            System.out.println("|        Welcome to the Java Quiz          |");
            System.out.println("*------------------------------------------*");
            System.out.println("|Press 1. to start the quiz for 2 players  |");
            System.out.println("|Press 2. to start the quiz for 3 players  |");
            System.out.println("|Press 3. to start the quiz for 4 players  |");
            System.out.println("|Press 0. to exit                          |");
            System.out.println("*------------------------------------------*");

            if (in.hasNextInt()) {
                gameOrNot = in.nextInt();
            }
            if (gameOrNot == 1) {
                twoPlayerGame();
            }
            if (gameOrNot == 2) {
                treePlayerGame();
            }
            if (gameOrNot == 3) {
                fourPlayerGame();
            } else if (gameOrNot == 0) {
                System.exit(0);
            } else {
                System.out.println("Invalid input, please try again");
                in.next();
                continue;
            }
        }
    }

    public static void questionNumberGenerator() {

        while (true) {
            if ((questionUsed.contains(checkNumber))) {

                checkNumber = RandomNumber.nextInt(20);

            } else {
                questionNumber = checkNumber;
                questionUsed.add(checkNumber);
                break;
            }
        }
    }

    public static void twoPlayerGame() {

        while (true) {

            for (int i = 0; i < twoPlayerQuestionAmount; i++) {
                questionNumberGenerator();
                if (playerCount == 1) {
                    System.out.println("Player 1 - You're turn!");
                } else if (playerCount == 2) {
                    System.out.println("Player 2 - You're turn!");
                }
                System.out.println("The question is : " + questions[questionNumber]);
                answer = in.next();


                if (answer.equals(answers[questionNumber])) {
                    System.out.println("You're right! The answer was: " + answers[questionNumber]);

                    if (playerCount == 1) {
                        playerOnePoint++;
                        System.out.println("Player 1, you now have " + playerOnePoint + " points!");
                        playerCount++;

                        System.out.println("\nPress any key to continue the game");
                        in.next();

                    } else if (playerCount == 2) {
                        playerTwoPoint++;
                        System.out.println("Player 2, you now have " + playerTwoPoint + " points!");
                        playerCount--;

                        System.out.println("\nPress any key to continue the game");
                        in.next();
                    }

                } else {
                    System.out.println("You're wrong the answer was: " + answers[questionNumber]);

                    if (playerCount == 1) {
                        playerCount++;
                    } else if (playerCount == 2) {
                        playerCount--;
                    }

                    System.out.println("\nPress any key to continue the game");
                    in.next();
                }

            }
            winnerTwoPlayer();
            break;
        }
    }

    public static void treePlayerGame() {

        while (true) {

            for (int i = 0; i < treePlayerQuestionAmount; i++) {
                questionNumberGenerator();
                if (playerCount == 1) {
                    System.out.println("Player 1 - You're turn!");
                } else if (playerCount == 2) {
                    System.out.println("Player 2 - You're turn!");
                } else if (playerCount == 3) {
                    System.out.println("Player 3 - You're turn!");
                }
                System.out.println("The question is : " + questions[questionNumber]);
                answer = in.next();


                if (answer.equals(answers[questionNumber])) {
                    System.out.println("You're right! The answer was: " + answers[questionNumber]);

                    if (playerCount == 1) {
                        playerOnePoint++;
                        System.out.println("Player 1, you now have " + playerOnePoint + " points!");
                        playerCount++;

                        System.out.println("\nPress any key to continue the game");
                        in.next();

                    } else if (playerCount == 2) {
                        playerTwoPoint++;
                        System.out.println("Player 2, you now have " + playerTwoPoint + " points!");
                        playerCount++;

                        System.out.println("\nPress any key to continue the game");
                        in.next();
                    } else if (playerCount == 3) {
                        playerTreePoint++;
                        System.out.println("Player 3, you now have " + playerTreePoint + " points!");
                        playerCount = playerCount - 2;

                        System.out.println("\nPress any key to continue the game");
                        in.next();
                    }

                } else {
                    System.out.println("You're wrong the answer was: " + answers[questionNumber]);

                    if (playerCount == 1) {
                        playerCount++;
                    } else if (playerCount == 2) {
                        playerCount++;
                    } else if (playerCount == 3) {
                        playerCount = playerCount - 2;
                    }

                    System.out.println("\nPress any key to continue the game");
                    in.next();
                }

            }
            winnerTreePlayer();
            break;
        }
    }

    public static void fourPlayerGame() {

        while (true) {

            for (int i = 0; i < fourPlayerQuestionAmount; i++) {
                questionNumberGenerator();
                if (playerCount == 1) {
                    System.out.println("Player 1 - You're turn!");
                } else if (playerCount == 2) {
                    System.out.println("Player 2 - You're turn!");
                } else if (playerCount == 3) {
                    System.out.println("Player 3 - You're turn!");
                } else if (playerCount == 4) {
                    System.out.println("Player 4 - You're turn!");
                }
                System.out.println("The question is : " + questions[questionNumber]);
                answer = in.next();


                if (answer.equals(answers[questionNumber])) {
                    System.out.println("You're right! The answer was: " + answers[questionNumber]);

                    if (playerCount == 1) {
                        playerOnePoint++;
                        System.out.println("Player 1, you now have " + playerOnePoint + " points!");
                        playerCount++;

                        System.out.println("\nPress any key to continue the game");
                        in.next();

                    } else if (playerCount == 2) {
                        playerTwoPoint++;
                        System.out.println("Player 2, you now have " + playerTwoPoint + " points!");
                        playerCount++;

                        System.out.println("\nPress any key to continue the game");
                        in.next();

                    } else if (playerCount == 3) {
                        playerTreePoint++;
                        System.out.println("Player 3, you now have " + playerTreePoint + " points!");
                        playerCount++;

                        System.out.println("\nPress any key to continue the game");
                        in.next();

                    } else if (playerCount == 4) {
                        playerFourPoint++;
                        System.out.println("Player 4, you now have " + playerFourPoint + " points!");
                        playerCount = playerCount - 3;

                        System.out.println("\nPress any key to continue the game");
                        in.next();
                    }

                } else {
                    System.out.println("You're wrong the answer was: " + answers[questionNumber]);

                    if (playerCount == 1) {
                        playerCount++;
                    } else if (playerCount == 2) {
                        playerCount++;
                    } else if (playerCount == 3) {
                        playerCount++;
                    } else if (playerCount == 4) {
                        playerCount = playerCount - 3;
                    }

                    System.out.println("\nPress any key to continue the game");
                    in.next();
                }

            }
            winnerFourPlayer();
            break;
        }
    }

    public static void winnerTwoPlayer() {

        System.out.println("*--------------------------------------------------------*");
        System.out.println("|Player one you ended with " + playerOnePoint + " points!                     |");
        System.out.println("*--------------------------------------------------------*");
        System.out.println("|Player two you ended with " + playerTwoPoint + " points!                     |");
        System.out.println("*--------------------------------------------------------*");

        if (playerOnePoint > playerTwoPoint) {
            System.out.println("Player one is the winner! Congratulations you're an real Java expert!");

        } else if (playerTwoPoint > playerOnePoint) {
            System.out.println("Player two is the winner! Congratulations you're an real Java expert!");

        } else {
            System.out.println("It's an draw You're both an real Java expert!");

        }
        System.out.println("\nPress any key to go to the menu.");
        in.next();
        questionUsed.clear();
    }

    public static void winnerTreePlayer() {

        System.out.println("*--------------------------------------------------------*");
        System.out.println("|Player one you ended with " + playerOnePoint + " points!                     |");
        System.out.println("*--------------------------------------------------------*");
        System.out.println("|Player two you ended with " + playerTwoPoint + " points!                     |");
        System.out.println("*--------------------------------------------------------*");
        System.out.println("|Player tree you ended with " + playerTreePoint + " points!                    |");
        System.out.println("*--------------------------------------------------------*");

        if (playerOnePoint > playerTwoPoint && playerOnePoint > playerTreePoint) {
            System.out.println("Player one is the winner! Congratulations you're an real Java expert!");

        } else if (playerTwoPoint > playerOnePoint && playerTwoPoint > playerTreePoint) {
            System.out.println("Player two is the winner! Congratulations you're an real Java expert!");

        } else if (playerTreePoint > playerOnePoint && playerTreePoint > playerTwoPoint) {
            System.out.println("Player tree is the winner! Congratulations you're an real Java expert!");

        } else if (playerOnePoint == playerTwoPoint && playerOnePoint > playerTreePoint) {
            System.out.println("It's an draw between Player 1 and Player 2! Congratulations you're both an real Java expert!");

        } else if (playerOnePoint == playerTreePoint && playerOnePoint > playerTwoPoint) {
            System.out.println("It's an draw between Player 1 and Player 3! Congratulations you're both an real Java expert!");

        } else if (playerTreePoint == playerTwoPoint && playerTreePoint > playerOnePoint) {
            System.out.println("It's an draw between Player 2 and Player 3! Congratulations you're both an real Java expert!");

        } else {
            System.out.println("It's an draw! You're are all three an real Java expert!");

        }
        System.out.println("\nPress any key to go to the menu.");
        in.next();
        questionUsed.clear();
    }

    public static void winnerFourPlayer() {
        System.out.println("*--------------------------------------------------------*");
        System.out.println("|Player one you ended with " + playerOnePoint + " points!                     |");
        System.out.println("*--------------------------------------------------------*");
        System.out.println("|Player two you ended with " + playerTwoPoint + " points!                     |");
        System.out.println("*--------------------------------------------------------*");
        System.out.println("|Player tree you ended with " + playerTreePoint + " points!                    |");
        System.out.println("*--------------------------------------------------------*");
        System.out.println("|Player four you ended with " + playerFourPoint + " points!                    |");
        System.out.println("*--------------------------------------------------------*");

        if (playerOnePoint > playerTwoPoint && playerOnePoint > playerTreePoint && playerOnePoint > playerFourPoint) {
            System.out.println("Player one is the winner! Congratulations you're an real Java expert!");

        } else if (playerTwoPoint > playerOnePoint && playerTwoPoint > playerTreePoint && playerTwoPoint > playerFourPoint) {
            System.out.println("Player two is the winner! Congratulations you're an real Java expert!");

        } else if (playerTreePoint > playerOnePoint && playerTreePoint > playerTwoPoint && playerTreePoint > playerFourPoint) {
            System.out.println("Player tree is the winner! Congratulations you're an real Java expert!");

        } else if (playerFourPoint > playerOnePoint && playerFourPoint > playerTwoPoint && playerFourPoint > playerTreePoint) {
            System.out.println("Player four is the winner! Congratulations you're an real Java expert!");

        } else if (playerOnePoint == playerTwoPoint && playerOnePoint > playerTreePoint && playerOnePoint > playerFourPoint) {
            System.out.println("It's an draw between Player 1 and Player 2! Congratulations you're both an real Java expert!");

        } else if (playerOnePoint == playerTreePoint && playerOnePoint > playerTwoPoint && playerOnePoint > playerFourPoint) {
            System.out.println("It's an draw between Player 1 and Player 3! Congratulations you're both an real Java expert!");

        } else if (playerTreePoint == playerTwoPoint && playerTreePoint > playerOnePoint && playerTreePoint > playerFourPoint) {
            System.out.println("It's an draw between Player 2 and Player 3! Congratulations you're both an real Java expert!");

        } else if (playerFourPoint == playerOnePoint && playerFourPoint > playerTwoPoint && playerFourPoint > playerTreePoint) {
            System.out.println("It's an draw between Player 1 and Player 4! Congratulations you're both an real Java expert!");

        } else if (playerFourPoint == playerTwoPoint && playerFourPoint > playerOnePoint && playerFourPoint > playerTreePoint) {
            System.out.println("It's an draw between Player 2 and Player 4! Congratulations you're both an real Java expert!");

        } else if (playerFourPoint == playerTreePoint && playerFourPoint > playerOnePoint && playerFourPoint > playerTwoPoint) {
            System.out.println("It's an draw between Player 3 and Player 4! Congratulations you're both an real Java expert!");

        } else if (playerOnePoint == playerTwoPoint && playerOnePoint == playerTreePoint && playerOnePoint > playerFourPoint) {
            System.out.println("It's an draw between Player 1, Player 2 and Player 3! Congratulations you're all tree an real Java expert!");

        } else if (playerOnePoint == playerTwoPoint && playerOnePoint == playerFourPoint && playerOnePoint > playerTreePoint) {
            System.out.println("It's an draw between Player 1, Player 2 and Player 4! Congratulations you're all tree an real Java expert!");

        } else if (playerOnePoint == playerTreePoint && playerOnePoint == playerFourPoint && playerOnePoint > playerTwoPoint) {
            System.out.println("It's an draw between Player 1, Player 3 and Player 4! Congratulations you're all tree an real Java expert!");

        } else if (playerTwoPoint == playerTreePoint && playerTwoPoint == playerFourPoint && playerTwoPoint > playerOnePoint) {
            System.out.println("It's an draw between Player 2, Player 3 and Player 4! Congratulations you're all tree an real Java expert!");

        } else {
            System.out.println("It's an draw! You're are all four an real Java expert!");

        }
        System.out.println("\nPress any key to go to the menu.");
        in.next();
        questionUsed.clear();
    }  

}






