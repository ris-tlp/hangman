public class HangmanMain {
    public static void main(String[] args) {
        String result = doSomething("arg");
        System.out.println("Test");
        int i = anotherCall();
    }

    static String doSomething(String s) {
        return "Function call 1 with " + s;
    }

    static int anotherCall() {
        return 47;
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
}
