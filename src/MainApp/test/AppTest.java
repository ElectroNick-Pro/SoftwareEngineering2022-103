package MainApp.test;

import MainApp.App;

import org.junit.*;

public class AppTest {
    @Test
    public void testAdd() {
        Assert.assertEquals(19, new App().add(5, 5));
    }
}