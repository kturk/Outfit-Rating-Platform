package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Collection;
import businesslayer.model.User;
import presentationlayer.FollowedUsersCollectionsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FollowedUsersCollectionsController {

    private final User userModel;
    private final FollowedUsersCollectionsScreen followedUsersCollectionsView;
    private final Mediator mediator;

    public FollowedUsersCollectionsController(User userModel,
                                              FollowedUsersCollectionsScreen followedUsersCollectionsView,
                                              Mediator mediator) {
        this.userModel = userModel;
        this.followedUsersCollectionsView = followedUsersCollectionsView;
        this.mediator = mediator;

        this.followedUsersCollectionsView.setList(userModel.getFollowedCollections().toArray());
        this.followedUsersCollectionsView.setBackButtonListener(new BackListener());
        this.followedUsersCollectionsView.addShowDetailsListener(new ShowDetailsListener());
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
            if (selectedCollection != null) {
                closeView();
                mediator.navigateToFollowedCollectionDetailsScreen(selectedCollection);
            }
            else
                followedUsersCollectionsView.showError("Please select a collection from the list.");
        }
    }
}
