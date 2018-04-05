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
        Assert.assertEquals("Function call 1 with test", result);
    }

    //write test for anotherCall
    @Test
    public void test_anotherCall() {
        int result = HangmanMain.anotherCall();
        Assert.assertEquals(47,result);
    }
}