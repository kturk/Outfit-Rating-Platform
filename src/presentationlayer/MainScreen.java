package presentationlayer;

import java.awt.event.*;
import javax.swing.*;

// UserCollectionsScreen
// ShowUsersScreen
// ShowFollowedUsersCollections
// StatisticsScreen
// Logout
public class MainScreen extends JFrame{

    private JPanel buttonsPanel;

    private JLabel userLabel;

    private JButton userCollectionsButton;
    private JButton showUsersButton;
    private JButton showFollowedUsersCollectionsButton;
    private JButton statisticsButton;
    private JButton logoutButton;

    public MainScreen() {
        super("Main Screen");
        screenInitializer();

    }

    private void screenInitializer() {
        setSize(400,400);
//        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializePanels();
        locatePanels();
        addPanels();

        initializeComponents();
        locateComponents();
        addComponents();
        setLocationRelativeTo(null);

    }

    private void initializePanels() {
        buttonsPanel = new JPanel();
    }

    private void locatePanels() {
        buttonsPanel.setLayout(null);
    }

    private void addPanels() {
        add(buttonsPanel);
    }

    private void initializeComponents() {

        userLabel = new JLabel("User: Caner Tangüler");

        userCollectionsButton = new JButton("My Collections");
        showUsersButton = new JButton("See Users");
        showFollowedUsersCollectionsButton = new JButton("Collections Of Followed Users");
        statisticsButton = new JButton("Statistics");
        logoutButton = new JButton("Logout");

    }

    private void locateComponents() {

        userLabel.setBounds(75, 30, 250 ,25);

        userCollectionsButton.setBounds(75,100,250,25);
        showUsersButton.setBounds(75,140,250,25);
        showFollowedUsersCollectionsButton.setBounds(75,180,250,25);
        statisticsButton.setBounds(75,220,250,25);
        logoutButton.setBounds(75,260,250,25);

    }

    private void addComponents() {
        buttonsPanel.add(userLabel);

        buttonsPanel.add(userCollectionsButton);
        buttonsPanel.add(showUsersButton);
        buttonsPanel.add(showFollowedUsersCollectionsButton);
        buttonsPanel.add(statisticsButton);
        buttonsPanel.add(logoutButton);
    }

    public void renderUsername(String username) {
        userLabel.setText("User: " + username);
    }

    public void addUserCollectionsButtonListener(ActionListener actionListener) {
        userCollectionsButton.addActionListener(actionListener);
    }

    public void addShowUsersButtonListener(ActionListener actionListener) {
        showUsersButton.addActionListener(actionListener);
    }

    public void addShowFollowedUsersCollectionsButtonListener(ActionListener actionListener) {
        showFollowedUsersCollectionsButton.addActionListener(actionListener);
    }

    public void addStatisticsButtonListener(ActionListener actionListener) {
        statisticsButton.addActionListener(actionListener);
    }

    public void addLogoutButtonListener(ActionListener actionListener) {
        logoutButton.addActionListener(actionListener);
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
