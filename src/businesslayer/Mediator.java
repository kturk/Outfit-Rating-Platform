package businesslayer;

import businesslayer.controller.LoginController;
import businesslayer.controller.MainController;
import businesslayer.controller.UserCollectionsController;
import businesslayer.model.Collection;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import presentationlayer.LoginScreen;
import presentationlayer.MainScreen;
import presentationlayer.UserCollectionsScreen;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

    private LoginController loginController;
//    private LoginScreen loginView;

    private MainController mainController;
//    private MainScreen mainView;

    private UserCollectionsController userCollectionsController;

    private ArrayList<User> userList;
    private ArrayList<Outfit> outfitList;

    public Mediator() {
        this.userList = new ArrayList<User>();
        this.outfitList = new ArrayList<Outfit>();
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void setOutfitList(ArrayList<Outfit> outfitList) {
        this.outfitList = outfitList;
    }

    public void start(){
        navigateToLoginScreen();
    }

    public void navigateToLoginScreen() {
        loginController = new LoginController(userList, new LoginScreen(), this);
        loginController.showView();
    }

    public void navigateToMainScreen(User loggedInUser) {
        mainController = new MainController(loggedInUser, new MainScreen(), this);
        mainController.showView();
    }

    public void navigateToUsersCollectionsScreen(User loggedInUser){
        UserCollectionsScreen screen = new UserCollectionsScreen();
        loggedInUser.attach( screen);
        userCollectionsController = new UserCollectionsController(loggedInUser, screen, this);
        userCollectionsController.showView();
    }
}
