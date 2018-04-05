import java.util.Scanner;

public class HangmanMain {
    public static void main(String[] args) {

        String word = getWord();

        if ("".equals(word)) {
            word = getWord();
        }
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
            System.out.println("Your word is invalid, please try again.");
            return "";
        }
    }
}