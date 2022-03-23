package MainApp;

import MainApp.pages.Welcome;

public class App {
    public static void main(String[] args) {
        var frame = new Welcome();
        frame.setDefaultCloseOperation(Welcome.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
