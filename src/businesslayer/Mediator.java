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

    private List<User> userList;
    private List<Outfit> outfitList;
    private User loggedUser;
    private final DataHandler dataHandler;

    public Mediator() {
        this.userList = new ArrayList<User>();
        this.outfitList = new ArrayList<Outfit>();
        this.dataHandler = new DataHandler("testXML.xml", "testJson.json");
        this.readXML();
        this.readJSON();
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

    public void readJSON() {
        this.outfitList = dataHandler.readJson();
    }

    public void writeJSON() {
        dataHandler.writeJson(this.outfitList);
    }

    public void start(){
        navigateToLoginScreen();
    }

    public void navigateToLoginScreen() {
        LoginController loginController = new LoginController(userList, new LoginScreen(), this);
        loginController.showView();
    }

    public void setLoggedUser(User loggedUser){
        this.loggedUser = loggedUser;
    }

    public void navigateToMainScreen() {
        MainController mainController = new MainController(loggedUser, new MainScreen(), this);
        mainController.showView();
    }

    public void navigateToUsersCollectionsScreen() {
        UserCollectionsScreen screen = new UserCollectionsScreen();
        loggedUser.attach(screen);
        UserCollectionsController userCollectionsController = new UserCollectionsController(loggedUser, screen, this);
        userCollectionsController.showView();
    }

    public void navigateToCollectionDetailsScreen(Collection collection) {
        UserCollectionDetailScreen screen = new UserCollectionDetailScreen();
        collection.attach(screen);
        UserCollectionDetailsController userCollectionDetailsController = new UserCollectionDetailsController(collection, outfitList, screen, this);
        userCollectionDetailsController.showView();
    }

    public void navigateToSeeUsersScreen() {
        SeeUsersScreen screen = new SeeUsersScreen();
        loggedUser.attach(screen);
        SeeUsersController seeUsersController = new SeeUsersController(userList, loggedUser, screen, this);
        seeUsersController.showView();
    }

    public void navigateToFollowedUsersCollectionsScreen() {
        FollowedUsersCollectionsScreen screen = new FollowedUsersCollectionsScreen();
        FollowedUsersCollectionsController followedUsersCollectionsController = new FollowedUsersCollectionsController(loggedUser, screen, this);
        followedUsersCollectionsController.showView();
    }

    public void navigateToFollowedCollectionDetailsScreen(Collection collection) {
        FollowedUserCollectionDetailScreen screen = new FollowedUserCollectionDetailScreen();
        FollowedCollectionDetailsController followedCollectionDetailsController = new FollowedCollectionDetailsController(collection, outfitList, screen, this);
        followedCollectionDetailsController.showView();
    }

    public void navigateToStatisticsScreen() {
        // TODO no need to attach cuz no data change?
        StatisticsScreen screen = new StatisticsScreen();
        StatisticsController statisticsController = new StatisticsController(userList, outfitList, screen, this);
        statisticsController.showView();
    }

    public void navigateToSeeOutfitsScreen() {
        SeeOutfitsScreen screen = new SeeOutfitsScreen();
        loggedUser.attach(screen);
        SeeOutfitsController seeOutfitsController = new SeeOutfitsController(outfitList, loggedUser, screen, this);
        seeOutfitsController.showView();
    }

    public void navigateToOutfitCommentScreen(Outfit outfit) {
        OutfitCommentScreen screen = new OutfitCommentScreen();
        outfit.attach(screen);
        OutfitCommentController outfitCommentController = new OutfitCommentController(outfit, screen, this);
        outfitCommentController.showView();
    }
}
