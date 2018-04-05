import org.junit.*;

public class HangmanMainTest {

    @BeforeClass
    public static void runOnceBeforeClass() {

    }

    @AfterClass
    public static void runOnceAfterClass() {

    }

    @Before
    public void runBeforeTestMethod() {

    }

    @After
    public void runAfterTestMethod() {

    }

    @Test
    public void test_isCharacterValid_True() {

        String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] allowedCharacters = alphabets.toCharArray();

        for(int i=0; i < allowedCharacters.length; i++) {
            Assert.assertTrue(HangmanMain.isCharacterValid(allowedCharacters[i]));
        }

    }

    @Test
    public void test_isInputCharacterValid_False() {

        String nonAlphabeticCharacters = "0123456789`~!@#$%^&*()-=_+[]\\{}|;':,./<>?\"";
        char[] disallowedCharacters = nonAlphabeticCharacters.toCharArray();

        for(int i=0; i < disallowedCharacters.length; i++) {
            Assert.assertFalse(HangmanMain.isCharacterValid(disallowedCharacters[i]));
        }
    }

    @Test
    public void test_isWordValid_True() {
        String apple = "Apple";
        Assert.assertTrue(HangmanMain.isWordValid(apple));
    }

    @Test
    public void test_isWordValid_False() {
        String apple = "Ap!le";
        Assert.assertFalse(HangmanMain.isWordValid(apple));
    }

    @Test
    public void test_isInputValid_True() {
        String word = "Banana";
        String reenterWord = "Banana";
        Assert.assertTrue(HangmanMain.isInputValid(word, reenterWord));
    }

    @Test
    public void test_isInputValid_False() {
        String word = "Banana";
        String reenterWord = "Banan";
        Assert.assertFalse(HangmanMain.isInputValid(word, reenterWord));
    }


    @Test
    public void test_isInputValid_Length2(){
        String word = "as";
        String wordDup = "as";
        Assert.assertFalse(HangmanMain.isInputValid(word,wordDup));

    }

    @Test
    public void getTest_isInputValid_Length11(){
        String word = "punctuation";
        String wordDup = "punctuation";
        Assert.assertFalse(HangmanMain.isInputValid(word,wordDup));
    }
}