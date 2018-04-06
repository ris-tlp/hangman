import java.util.Scanner;

public class HangmanMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = "";

        while ("".equals(word)) {
            word = getWord();
        }
        int validTurns = 6;

        String solution = word.toLowerCase();
//        System.out.println(solution);
//
        int length = solution.length();

        String guessSoFar = "";

        //setting the character array guess with the same number of underscores as the length of solution
        for (int i = 0; i < length; i++){
            guessSoFar += '_';

        }

        displayDashesForPlayerTwo(guessSoFar);


        System.out.println("\n\nPlayer 2, you can only enter one character and only the alphabet (a-z, A-Z).");
        System.out.println("Please enter your character.");
        displayDashesForPlayerTwo(guessSoFar);

        char P2input = scan.next().charAt(0);
        P2input = Character.toLowerCase(P2input);

        //performing character validity check
        boolean state = isCharacterValid(P2input);
//        System.out.println(state);
        while (state==false) {
            System.out.println("The character you have entered is invalid. Please try again.");
            P2input = scan.next().charAt(0);
            P2input = Character.toLowerCase(P2input);
            state = isCharacterValid(P2input);
        }

        // checking if the string solution contains the character input by player two
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            gameResult(guessSoFar,solution);




            if (solution.indexOf(P2input) >= 0) {

                while (guessSoFar.toLowerCase().indexOf(P2input) >= 0) {

                    System.out.println("You have already guessed this character, please try another one.");
                    P2input = scan.next().charAt(0);
                    P2input = Character.toLowerCase(P2input);
                }

                guessSoFar = updateDashesForPlayerTwo(P2input, solution, guessSoFar);
                displayDashesForPlayerTwo(guessSoFar);

                if (gameResult(guessSoFar,solution)) {
                    P2input = scan.next().charAt(0);
                    P2input = Character.toLowerCase(P2input);
                }


            }

            else {

                System.out.println("This character is not present in the word given by Player one. Please try again.");
                validTurns--;
                System.out.println("You have " + validTurns + " chances remaining.");

                if (validTurns == 0) {
                    System.out.println("You are out of turns! Better luck next time.");
                    System.out.println("GAME OVER!");
                    System.exit(0);
                }

                P2input = scan.next().charAt(0);

            }
        }





    }




    static boolean isInputValid( String word, String reenterWord ) {

        if( !word.equalsIgnoreCase(reenterWord) ) {
            System.out.println("The words entered are not the same");
            return false;
        }
        if( word.length() < 3 || word.length() > 10 ) {
            System.out.println("The word be between 3 to 10 characters long.");
            return false;
        }
        return isWordValid( word );

    }

    static boolean isWordValid( String word ) {

        char[] lettersInWord = word.toCharArray();

        for(int i = 0; i < lettersInWord.length; i++) {
            if( !isCharacterValid(lettersInWord[i]) )
                return false;
        }

        return true;

    }

    static boolean isCharacterValid( char c ) {

        if( c >= 'a' && c <= 'z')
            return true;
        else if ( c >= 'A' && c <= 'Z' )
            return true;
        else
            return false;

    }

    static String getWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: please enter you word. ");
        System.out.println("You may only enter alphabets (a-z, A-Z) and your word may contain 3-10 characters.");
        System.out.println("Type 0 to exit the program.");

        String word = scan.nextLine();
        if(!isWordValid(word) && !"0".equals(word)){
            return "";
        }



        if ("0".equals(word))
        {
            System.exit(0);
        }

        System.out.println("Please enter your word again. ");
        String wordDuplicate = scan.nextLine();


        boolean isValid = isInputValid(word, wordDuplicate);

        if (isValid == true) {
            System.out.println("Thank you, it is player 2's turn now!");
            return word;
        } else {
            return "";
        }
    }

    static void displayDashesForPlayerTwo(String word) {

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '_')
                System.out.print("_ ");
            else
                System.out.print(word.charAt(i) + " ");
        }

    }

    static String updateDashesForPlayerTwo(char guess, String solution, String guessSoFar) {

        char[] solutionCharArray = solution.toCharArray();
        char[] guessSoFarCharArray = guessSoFar.toCharArray();
        for (int i = 0; i < solutionCharArray.length; i++) {
            if(Character.toUpperCase(guess) == Character.toUpperCase(solutionCharArray[i])) {
                guessSoFarCharArray[i] = Character.toUpperCase(guess);
            }
        }
        return new String(guessSoFarCharArray);
    }


    static boolean gameResult(String guessSoFar, String solution) {

        if (guessSoFar.toLowerCase().equals(solution)) {
            System.out.println("\nCongratulations Player two! You guessed the word right!");
            System.exit(0);
        }
            return true;

    }


}