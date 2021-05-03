package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.User;
import presentationlayer.SeeUsersScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SeeUsersController {

    private List<User> userModels;
    private User userModel;
    private SeeUsersScreen seeUsersView;
    private Mediator mediator;

    public SeeUsersController(List<User> userModels, User userModel, SeeUsersScreen seeUsersView, Mediator mediator) {
        this.userModels = userModels;
        this.userModel = userModel;
        this.seeUsersView = seeUsersView;

        this.seeUsersView.setUserList(getUsersNotFollowing().toArray());
        this.seeUsersView.setFollowedUserList(userModel.getFollowingUsers().toArray());

        this.seeUsersView.addFollowButtonListener(new FollowButtonListener());
        this.seeUsersView.addUnfollowButtonListener(new UnfollowButtonListener());
        this.seeUsersView.setBackButtonListener(new BackListener());

        this.mediator = mediator;
    }

    private List<User> getUsersWithoutCurrentUser() {
        List<User> tempUserList = new ArrayList<User>(this.userModels);
        tempUserList.remove(userModel);
        return tempUserList;
    }

    private List<User> getUsersNotFollowing() {
        List<User> tempUserList = getUsersWithoutCurrentUser();
        tempUserList.removeAll(userModel.getFollowingUsers());
        return tempUserList;
    }

    public void showView() {
        seeUsersView.showScreen();
    }

    public void closeView() {
        seeUsersView.closeScreen();
    }

    class FollowButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User selectedUser = (User) seeUsersView.getUserList().getSelectedValue();
            selectedUser.addFollowerUser(userModel);
            userModel.addFollowingUser(selectedUser);
            mediator.writeXML();

        }
    }

    class UnfollowButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            seeUsersView.setUserList(getUsersWithoutCurrentUser().toArray());
            User selectedUser = (User) seeUsersView.getFollowedUserList().getSelectedValue();
            selectedUser.removeFollowerUser(userModel);
            userModel.removeFollowingUser(selectedUser);
            mediator.writeXML();
        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            seeUsersView.closeScreen();
            mediator.navigateToMainScreen();
        }
    }
}
