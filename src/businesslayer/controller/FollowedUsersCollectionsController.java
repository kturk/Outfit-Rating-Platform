package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Collection;
import businesslayer.model.User;
import presentationlayer.FollowedUsersCollectionsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FollowedUsersCollectionsController {

    private User userModel;
    private FollowedUsersCollectionsScreen followedUsersCollectionsView;
    private Mediator mediator;

    public FollowedUsersCollectionsController(User userModel,
                                              FollowedUsersCollectionsScreen followedUsersCollectionsView,
                                              Mediator mediator) {
        this.userModel = userModel;
        this.followedUsersCollectionsView = followedUsersCollectionsView;
        this.mediator = mediator;

        this.followedUsersCollectionsView.setList(userModel.getFollowedCollections().toArray());

        this.followedUsersCollectionsView.setBackButtonListener(new BackListener());
        this.followedUsersCollectionsView.addShowDetailsListener(new ShowDetailsListener());
        this.followedUsersCollectionsView.setTitle(userModel.getUserName() + "'s Collections");
    }

    public void showView() {
        followedUsersCollectionsView.showScreen();
    }

    public void closeView() {
        followedUsersCollectionsView.closeScreen();
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            followedUsersCollectionsView.closeScreen();
            mediator.navigateToMainScreen();
        }
    }

    class ShowDetailsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Collection selectedCollection = (Collection) followedUsersCollectionsView.getCollectionList().getSelectedValue();
            followedUsersCollectionsView.closeScreen();
            mediator.navigateToFollowedCollectionDetailsScreen(selectedCollection);
        }
    }
}
