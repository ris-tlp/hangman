import java.util.Scanner;

public class HangmanMain {

    public static void main(String[] args) {

        String word = "";

        while ("".equals(word)) {
            word = getWord();
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

        for (int i = 0; i < word.length(); i ++) {
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

}