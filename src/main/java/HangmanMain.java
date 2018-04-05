import java.util.Scanner;

public class HangmanMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = getWord();

        while ("".equals(word)) {
            word = getWord();
        }
        int validTurns = 6;

        String solution = word;

        int length = solution.length();

        char[] guess = new char[length];

        //setting the character array guess with the same number of underscores as the length of solution
        for (int i = 0; i < length; i++){
            guess[i] = '_';
        }
        System.out.println("Player 2, you can only enter one character and only the alphabet (a-z, A-Z).");
        System.out.println("Please enter your character.");

        char P2input = scan.next().charAt(0);

        //performing character validity check
        boolean state = isCharacterValid(P2input);
        while (!state) {
            System.out.println("The character you have entered is invalid. Please try again.");
            char P2input = scan.next().charAt(0);
        }

        // checking if the string solution contains the character input by player two
        for (int i = 0; i < length; i++) {


            if (validTurns == 0) {
                System.out.println("You are out of turns! Better luck next time.");
                System.out.println("GAME OVER!");
            }

            if (solution.indexOf(P2input) >= 0){
                updateDash(P2input,solution,guess);
            }

            else {
                System.out.println("This character is not present in the word given by Player one. Please try again.");
                validTurns--;
                System.out.println("You have " + validTurns + " remaining.");
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

    public static String getWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: please enter you word. ");
        System.out.println("You may only enter alphabets (a-z, A-Z) and your word may contain 3-10 characters.");
        System.out.println("Type 0 to exit the program.");

        String word = scan.nextLine();

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



}