package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.User;
import presentationlayer.LoginScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class LoginController {

    private final List<User> userModels;
    private final LoginScreen loginView;
    private final Mediator mediator;

    public LoginController(List<User> userModels, LoginScreen loginView, Mediator mediator) {
        this.userModels = userModels;
        this.loginView = loginView;
        this.mediator = mediator;

        loginView.addButtonListener(new LoginListener());
    }

    public void showView() {
        loginView.showScreen();
    }

    public void closeView() {
        loginView.closeScreen();
    }

    private User checkCredentials(String username, String password) {
        for(User userModel : userModels){
            if(userModel.getUserName().equals(username) && userModel.getPassword().equals(password)){
                return userModel;
            }
        }
        return null;
    }


    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Map<String, String> credentials = loginView.getCredentials();
            User loggedInUser = checkCredentials(credentials.get("username"), credentials.get("password"));

            if(loggedInUser != null){
                closeView();
                mediator.setLoggedUser(loggedInUser);
                mediator.navigateToMainScreen();
            }
            else{
                loginView.showError("Wrong username or password.");
            }
        }
    }
}
