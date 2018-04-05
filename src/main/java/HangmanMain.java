import java.util.Scanner;

public class HangmanMain {
    public static void main(String[] args) {
        String result = doSomething("arg");
        System.out.println("Test");
        int i = anotherCall();

        String word = getWord();

        if (word == "false") {
            word = getWord();
        }
        else {}
    }

    static String doSomething(String s) {
        return "Function call 1 with " + s;
    }

    static int anotherCall() {
        return 47;
    }


    public static String getWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: please enter you word. ");
        System.out.println("You may only enter alphabets (a-z, A-Z) and your word may contain 3-10 characters.");

        String word = scan.nextLine();
        System.out.println("Please enter your word again. ");
        String wordDuplicate = scan.nextLine();

        boolean isValid = isInputValid(word, wordDuplicate);

        if (isValid == true) {
            System.out.println("Thank you, it is player 2's turn now!");
            return word;
        }
            else             {
            System.out.println("Your word is invalid, please try again.");
            return "false";

        }
    }