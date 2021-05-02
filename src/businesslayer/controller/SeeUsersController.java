package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.User;
import presentationlayer.SeeUsersScreen;
import presentationlayer.UserCollectionsScreen;

import java.util.List;

public class SeeUsersController {

    private List<User> userModels;
    private User userModel;
    private SeeUsersScreen seeUsersView;
    private Mediator mediator;

    public SeeUsersController(List<User> userModels, User userModel, Mediator mediator) {
        this.userModels = userModels;
        this.userModel = userModel;
        this.seeUsersView = new SeeUsersScreen(userModels, userModel);
        this.mediator = mediator;
    }

    public void showView() {
        seeUsersView.showScreen();
    }

    public void closeView() {
        seeUsersView.closeScreen();
    }
}
