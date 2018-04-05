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
}
