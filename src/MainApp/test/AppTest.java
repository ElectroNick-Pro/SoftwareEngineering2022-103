package MainApp.test;

import MainApp.App;

import org.junit.*;

public class AppTest {
    @Test
    public void testAdd() {
        Assert.assertEquals(10, new App().add(5, 5));
    }
}