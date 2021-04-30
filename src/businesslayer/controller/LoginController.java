package businesslayer.controller;

import businesslayer.model.User;
import presentationlayer.LoginScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Controller {

    private User userModel;
    private LoginScreen loginView;

    public Controller(User userModel, LoginScreen loginView) {
        this.userModel = userModel;
        this.loginView = loginView;

        loginView.addButtonListener(new LoginListener());
        loginView.showScreen();

    }

    private boolean checkCredentials(String username, String password) {
        if(username.equals("kemal") && password.equals("1234")){
            return true;
        }
        return false;
    }


    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Map<String, String> credentials = loginView.getCredentials();
            System.out.println(credentials.get("username")+ credentials.get("password"));
            boolean validation = checkCredentials(credentials.get("username"), credentials.get("password"));

            if(validation){
                loginView.navigateMainScreen();
            }
            else{
                loginView.invalidCredentialError("Wrong username or password.");
            }
        }
    }
}
