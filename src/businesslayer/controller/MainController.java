package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Collection;
import businesslayer.model.User;
import presentationlayer.MainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MainController {

    private User userModel;
//    private Collection collectionModel;

    private MainScreen mainView;

    private Mediator mediator;

    public MainController(User userModel, MainScreen mainView, Mediator mediator) {
        this.userModel = userModel;
//        this.collectionModel = collectionModel;
        this.mainView = mainView;
        this.mediator = mediator;

        mainView.renderUsername(userModel.getUserName());
        mainView.addUserCollectionsButtonListener(new UserCollectionListener());
        mainView.addShowUsersButtonListener(new ShowUsersListener());
        mainView.addShowFollowedUsersCollectionsButtonListener(new ShowFollowedUsersListener());
        mainView.addStatisticsButtonListener(new StatisticsListener());
        mainView.addLogoutButtonListener(new LogoutListener());

    }

    public void showView() {
        mainView.showScreen();
    }

    public void closeView() {
        mainView.closeScreen();
    }

    class UserCollectionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainView.closeScreen();
            mediator.navigateToUsersCollectionsScreen(userModel);
        }
    }

    class ShowUsersListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("ShowUsersScreen");
        }
    }

    class ShowFollowedUsersListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("ShowFollowedUsersCollections");
        }
    }

    class StatisticsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("StatisticsScreen");
        }
    }

    class LogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainView.closeScreen();
            mediator.navigateToLoginScreen();
        }
    }
}
