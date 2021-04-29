package businesslayer;
import businesslayer.controller.Controller;
import businesslayer.model.IUser;
import businesslayer.model.User;
import presentationlayer.LoginScreen;
import presentationlayer.MainScreen;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        System.out.println("Test");

//        MainScreen mainScreen = new MainScreen();
        LoginScreen loginScreen = new LoginScreen();
//        MainScreen mainScreen = new MainScreen();
        Controller controller = new Controller(null, loginScreen);


    }



}
