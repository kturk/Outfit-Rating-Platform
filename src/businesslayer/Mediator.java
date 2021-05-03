package businesslayer;

import businesslayer.controller.*;
import businesslayer.model.Collection;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import businesslayer.model.Users;
import dataaccesslayer.DataHandler;
import presentationlayer.*;

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
    private FollowedUsersCollectionsController followedUsersCollectionsController;
    private SeeOutfitsController seeOutfitsController;
    private UserCollectionDetailsController userCollectionDetailsController;
    private FollowedCollectionDetailsController followedCollectionDetailsController;
    private OutfitCommentController outfitCommentController;

    private List<User> userList;
    private List<Outfit> outfitList;

    private User loggedUser;
    private DataHandler dataHandler;

    public Mediator() {
        this.userList = new ArrayList<User>();
        this.outfitList = new ArrayList<Outfit>();
        this.dataHandler = new DataHandler("testXML.xml", "testJson.json");
        this.readXML();
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setOutfitList(List<Outfit> outfitList) {
        this.outfitList = outfitList;
    }

    public void readXML() {
        Users users = dataHandler.readXML();
        this.userList = users.getUserList();
    }

    public void writeXML() {
        Users users = new Users();
        users.setUserList(this.userList);
        this.dataHandler.writeXML(users);
    }

    public void start(){
        navigateToLoginScreen();
    }

    public void navigateToLoginScreen() {
        loginController = new LoginController(userList, new LoginScreen(), this);
        loginController.showView();
    }

    public void setLoggedUser(User loggedUser){
        this.loggedUser = loggedUser;
    }

    public void navigateToMainScreen() {
        mainController = new MainController(loggedUser, new MainScreen(), this);
        mainController.showView();
    }

    public void navigateToUsersCollectionsScreen() {
        UserCollectionsScreen screen = new UserCollectionsScreen();
        loggedUser.attach(screen);
        userCollectionsController = new UserCollectionsController(loggedUser, screen, this);
        userCollectionsController.showView();
    }

    public void navigateToCollectionDetailsScreen(Collection collection) {
        UserCollectionDetailScreen screen = new UserCollectionDetailScreen();
        collection.attach(screen);
        userCollectionDetailsController = new UserCollectionDetailsController(collection, outfitList ,screen, this);
        userCollectionDetailsController.showView();
    }

    public void navigateToSeeUsersScreen(User loggedInUser) {
        SeeUsersScreen screen = new SeeUsersScreen();
        loggedInUser.attach(screen);
        seeUsersController = new SeeUsersController(userList, loggedInUser, screen,this);
        seeUsersController.showView();
    }

    public void navigateToFollowedUsersCollectionsScreen() {
        FollowedUsersCollectionsScreen screen = new FollowedUsersCollectionsScreen();
        followedUsersCollectionsController = new FollowedUsersCollectionsController(loggedUser, screen, this);
        followedUsersCollectionsController.showView();
    }

    public void navigateToFollowedCollectionDetailsScreen(Collection collection) {
        FollowedUserCollectionDetailScreen screen = new FollowedUserCollectionDetailScreen();
        followedCollectionDetailsController = new FollowedCollectionDetailsController(collection, outfitList ,screen, this);
        followedCollectionDetailsController.showView();
    }

    public void navigateToStatisticsScreen() {
        // TODO no need to attach cuz no data change?
        StatisticsScreen screen = new StatisticsScreen();
        statisticsController = new StatisticsController(userList, outfitList, screen,this);
        statisticsController.showView();
    }

    public void navigateToSeeOutfitsScreen(User loggedInUser) {
        SeeOutfitsScreen screen = new SeeOutfitsScreen();
        loggedInUser.attach(screen);
        seeOutfitsController = new SeeOutfitsController(outfitList, loggedInUser, screen, this);
        seeOutfitsController.showView();
    }

    public void navigateToOutfitCommentScreen(User loggedInUser, Outfit outfit) {
        OutfitCommentScreen screen = new OutfitCommentScreen();
        outfit.attach(screen);
        outfitCommentController = new OutfitCommentController(loggedInUser, outfit, screen, this);
        outfitCommentController.showView();
    }
}
