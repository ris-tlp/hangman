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
    public void test_doSomething() {
        String result = HangmanMain.doSomething("test");
        Assert.assertEquals("Function call 1 with arg", result);
    }

    //write test for anotherCall

}