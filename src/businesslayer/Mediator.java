package businesslayer;

import businesslayer.controller.*;
import businesslayer.model.Collection;
import businesslayer.model.IOutfit;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import presentationlayer.LoginScreen;
import presentationlayer.MainScreen;
import presentationlayer.SeeUsersScreen;
import presentationlayer.UserCollectionsScreen;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

    private LoginController loginController;
//    private LoginScreen loginView;

    private MainController mainController;
//    private MainScreen mainView;

    private UserCollectionsController userCollectionsController;  // TODO shouldn't this be a local variable?
    private SeeUsersController seeUsersController;
    private StatisticsController statisticsController;

    private List<User> userList;
    private List<Outfit> outfitList;

    public Mediator() {
        this.userList = new ArrayList<User>();
        this.outfitList = new ArrayList<Outfit>();
    }



    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setOutfitList(List<Outfit> outfitList) {
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

    public void navigateToUsersCollectionsScreen(User loggedInUser) {
        UserCollectionsScreen screen = new UserCollectionsScreen();
        loggedInUser.attach(screen);
        userCollectionsController = new UserCollectionsController(loggedInUser, screen, this);
        userCollectionsController.showView();
    }

    public void navigateToSeeUsersScreen(User loggedInUser) {
//        SeeUsersScreen screen = new SeeUsersScreen();
        // TODO no need to attach cuz no data change?
        seeUsersController = new SeeUsersController(userList, loggedInUser, this);
        seeUsersController.showView();
    }

    public void navigateToStatisticsScreen(User loggedInUser) {
//        SeeUsersScreen screen = new SeeUsersScreen();
        // TODO no need to attach cuz no data change?
        statisticsController = new StatisticsController(userList, outfitList, loggedInUser, this);
        statisticsController.showView();
    }
}
