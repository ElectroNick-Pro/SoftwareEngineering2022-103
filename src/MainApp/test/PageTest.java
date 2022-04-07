package MainApp.test;

import javax.swing.JFrame;

import org.junit.Test;

import MainApp.pages.FlightInformationFrm;

public class PageTest {
    @Test
    public void testPage() {
        var page = new FlightInformationFrm();
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setVisible(true);
    }
}
