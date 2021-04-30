package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.User;
import presentationlayer.LoginScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class LoginController {

    private List<User> userModels;
    private LoginScreen loginView;
    private Mediator mediator;

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
        for(User userModal : userModels){
            if(userModal.getUserName().equals(username) && userModal.getPassword().equals(password)){
                return userModal;
            }
        }
        return null;
    }


    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Map<String, String> credentials = loginView.getCredentials();
            System.out.println(credentials.get("username")+ credentials.get("password"));
            User loggedInUser = checkCredentials(credentials.get("username"), credentials.get("password"));

            if(loggedInUser != null){
                loginView.closeScreen();
                mediator.navigateToMainScreen(loggedInUser);
            }
            else{
                loginView.invalidCredentialError("Wrong username or password.");
            }
        }
    }
}
