package presentationlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LoginScreen extends JFrame{

    private JTextField usernameField;
    private JLabel usernameLabel;

    private JPasswordField passwordField;
    private JLabel passwordLabel;

    private JButton loginButton;

    private JPanel loginPanel;

    public LoginScreen() {
        super("Login Screen");
        screenInitializer();
    }

    private void screenInitializer() {
        setSize(300,250);
//        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializePanels();
        locatePanels();
        addPanels();

        initializeComponents();
        locateComponents();
        addComponents();
        setLocationRelativeTo(null);
//        setVisible(true);

    }

    private void initializePanels() {
        loginPanel = new JPanel();
    }

    private void locatePanels() {
        loginPanel.setLayout(null);
    }

    private void addPanels() {
        add(loginPanel);
    }

    private void initializeComponents() {
        usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(10);
        passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");
    }

    private void locateComponents() {
        usernameLabel.setBounds(20,20,100,25);
        usernameField.setBounds(120, 20, 150, 25);
        passwordLabel.setBounds(20,60,100,25);
        passwordField.setBounds(120, 60, 150, 25);
        loginButton.setBounds(160, 100, 110, 25);
    }

    private void addComponents() {
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
    }

    public void addButtonListener(ActionListener actionListener) {
        loginButton.addActionListener(actionListener);
//        loginButton.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                getCredentials();
//            }
//        });
    }

    public Map<String, String> getCredentials() {
        Map<String, String> credentials = new HashMap<String, String>();
        credentials.put("username", usernameField.getText());
        credentials.put("password", new String(passwordField.getPassword()));

        return(credentials);
    }

    public void invalidCredentialError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void setVisible(Boolean visible){
        setVisible(visible);
    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }
}
