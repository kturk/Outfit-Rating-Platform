package presentationlayer;

import businesslayer.model.Outfit;
import businesslayer.model.User;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Statistics text
public class StatisticsScreen extends JFrame {

    private JPanel panel;
    private JLabel userLabel;
    private JList<Object> mostFollowedUsers;
    private JList<Object> mostLikedOutfits;
    private JList<Object> mostDislikedOutfits;

    public StatisticsScreen() {
        super("Statistics page");
        screenInitializer();
    }

    private void screenInitializer() {
        setSize(400,400);
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
        panel = new JPanel();
    }

    private void locatePanels() {
//        panel.setBounds(40,100,20,20);
        panel.setLayout(null);
    }

    private void addPanels() {
        add(panel);
    }

    private void initializeComponents() {
        userLabel = new JLabel("Current user: ");
        mostFollowedUsers = new JList<Object>();
        mostLikedOutfits = new JList<Object>();
        mostDislikedOutfits = new JList<Object>();
    }

    private void locateComponents() {
        userLabel.setBounds(10, 10, 250 ,25);
        mostFollowedUsers.setBounds(10, 40, 380, 50);
        mostLikedOutfits.setBounds(10, 100, 380, 50);
        mostDislikedOutfits.setBounds(10, 160, 380, 50);
    }

    private void addComponents() {
        panel.add(userLabel);
        panel.add(mostFollowedUsers);
        panel.add(mostLikedOutfits);
        panel.add(mostDislikedOutfits);
    }

    public void setMostFollowedUsersList(Object[] itemList) {
        mostFollowedUsers.setListData(itemList);
    }

    public void setMostLikedOutfitsList(Object[] itemList) {
        mostLikedOutfits.setListData(itemList);
    }

    public void setMostDislikedOutfitsLists(Object[] itemList) {
        mostDislikedOutfits.setListData(itemList);
    }

    public void showScreen(){
        setVisible(true);
    }

    public void closeScreen(){
        dispose();
    }
}
