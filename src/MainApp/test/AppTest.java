package MainApp.test;

import MainApp.GUISample;

import org.junit.*;

public class AppTest {
    @Test
    public void testAdd() {
        Assert.assertEquals(19, new GUISample().add(5, 5));
    }
}