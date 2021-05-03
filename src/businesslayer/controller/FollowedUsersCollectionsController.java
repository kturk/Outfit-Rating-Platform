package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.User;
import presentationlayer.FollowedUsersCollectionsScreen;

import java.util.List;

public class FollowedUsersCollectionsController {

    private List<User> userModels;
    private User userModel;
    private FollowedUsersCollectionsScreen followedUsersCollectionsView;
    private Mediator mediator;

    public FollowedUsersCollectionsController(List<User> userModels,
                                              User userModel,
                                              FollowedUsersCollectionsScreen followedUsersCollectionsView,
                                              Mediator mediator) {
        this.userModels = userModels;
        this.userModel = userModel;
        this.followedUsersCollectionsView = followedUsersCollectionsView;
        this.mediator = mediator;
    }

    public void showView() {
    }
}
