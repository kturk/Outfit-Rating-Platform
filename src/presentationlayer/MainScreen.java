package presentationlayer;

import java.awt.event.*;
import javax.swing.*;

public class MainScreen extends JFrame{

    private JPanel buttonsPanel;

    private JLabel userLabel;

    private JButton userCollectionsButton;
    private JButton seeUsersButton;
    private JButton seeOutfitsButton;
    private JButton showFollowedUsersCollectionsButton;
    private JButton statisticsButton;
    private JButton logoutButton;

    public MainScreen() {
        super("Main Screen");
        screenInitializer();

    }

    private void screenInitializer() {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

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
        seeUsersButton = new JButton("See Users");
        seeOutfitsButton = new JButton("See Outfits");
        showFollowedUsersCollectionsButton = new JButton("Collections Of Followed Users");
        statisticsButton = new JButton("Statistics");
        logoutButton = new JButton("Logout");

    }

    private void locateComponents() {

        userLabel.setBounds(75, 30, 250 ,25);

        userCollectionsButton.setBounds(75,80,250,25);
        seeUsersButton.setBounds(75,120,250,25);
        seeOutfitsButton.setBounds(75,160,250,25);
        showFollowedUsersCollectionsButton.setBounds(75,200,250,25);
        statisticsButton.setBounds(75,240,250,25);
        logoutButton.setBounds(75,280,250,25);
    }

    private void addComponents() {
        buttonsPanel.add(userLabel);

        buttonsPanel.add(userCollectionsButton);
        buttonsPanel.add(seeUsersButton);
        buttonsPanel.add(seeOutfitsButton);
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

    public void addSeeUsersButtonListener(ActionListener actionListener) {
        seeUsersButton.addActionListener(actionListener);
    }

    public void addSeeOutfitsButtonListener(ActionListener actionListener) {
        seeOutfitsButton.addActionListener(actionListener);
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

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }

}
