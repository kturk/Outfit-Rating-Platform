package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.User;
import presentationlayer.MainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private final User userModel;
    private final MainScreen mainView;
    private final Mediator mediator;

    public MainController(User userModel, MainScreen mainView, Mediator mediator) {
        this.userModel = userModel;
        this.mainView = mainView;
        this.mediator = mediator;

        mainView.renderUsername(userModel.getUserName().toUpperCase());
        mainView.addUserCollectionsButtonListener(new UserCollectionListener());
        mainView.addSeeUsersButtonListener(new SeeUsersListener());
        mainView.addSeeOutfitsButtonListener(new SeeOutfitsListener());
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
            closeView();
            mediator.navigateToUsersCollectionsScreen();
        }
    }

    class SeeUsersListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToSeeUsersScreen();
        }
    }

    class SeeOutfitsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToSeeOutfitsScreen();
        }
    }

    class ShowFollowedUsersListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToFollowedUsersCollectionsScreen();
        }
    }

    class StatisticsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToStatisticsScreen();
        }
    }

    class LogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToLoginScreen();
        }
    }
}
