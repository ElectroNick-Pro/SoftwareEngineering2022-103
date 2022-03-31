package MainApp;

import MainApp.models.Models;
import MainApp.pages.Pages;

public class App {
    
    public static void main(String[] args) {
        new App();
    }

    public App() {
        GlobalData.init();
        Models.init();
        Pages.init();
    }
}
