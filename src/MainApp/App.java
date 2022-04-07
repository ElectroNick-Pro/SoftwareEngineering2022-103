package MainApp;

import java.util.Scanner;

import MainApp.models.Models;
import MainApp.pages.Pages;

public class App {
    
    public static void main(String[] args) {
        if (args.length > 1) {
            System.err.printf("The number of arguments is %d which is expected to be 1.\nPress Enter to exit.\n", args.length);
            var in = new Scanner(System.in);
            in.nextLine();
            in.close();
            System.exit(1);
        }
        new App(args);
    }

    public App(String[] args) {
        GlobalData.init(args);
        Models.init();
        Pages.init();
    }
}
