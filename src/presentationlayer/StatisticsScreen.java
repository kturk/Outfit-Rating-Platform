package presentationlayer;

import businesslayer.model.Outfit;
import businesslayer.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Statistics text
public class StatisticsScreen extends JFrame {

    private JPanel panel;
    private JList<Object> mostFollowedUsers;
    private JList<Object> mostLikedOutfits;
    private JList<Object> mostDislikedOutfits;

    private JLabel mostFollowedUsersLabel;
    private JLabel mostLikedOutfitsLabel;
    private JLabel mostDislikedOutfitsLabel;

    JScrollPane mostFollowedUsersScrollPane;
    JScrollPane mostLikedOutfitsScrollPane;
    JScrollPane mostDislikedOutfitsScrollPane;

    private JButton backButton;

    public StatisticsScreen() {
        super("Statistics page");
        screenInitializer();
    }

    private void screenInitializer() {
        setSize(400,450);
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
        mostFollowedUsers = new JList<Object>();
        mostLikedOutfits = new JList<Object>();
        mostDislikedOutfits = new JList<Object>();

        mostFollowedUsersLabel = new JLabel("Most Followed Users");
        mostLikedOutfitsLabel = new JLabel("Most Liked Outfits");
        mostDislikedOutfitsLabel = new JLabel("Most Disliked Outfits");

        mostFollowedUsersScrollPane = new JScrollPane();
        mostLikedOutfitsScrollPane = new JScrollPane();
        mostDislikedOutfitsScrollPane = new JScrollPane();

        backButton = new JButton("Back");
    }

    private void locateComponents() {
        mostFollowedUsersLabel.setBounds(10, 10, 370, 25);
        mostFollowedUsersLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        mostFollowedUsers.setBounds(10, 40, 370, 50);
        mostFollowedUsersScrollPane.setBounds(10, 40, 360, 80);

        mostLikedOutfitsLabel.setBounds(10, 120, 370, 25);
        mostLikedOutfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        mostLikedOutfits.setBounds(10, 140, 370, 50);
        mostLikedOutfitsScrollPane.setBounds(10, 150, 360, 80);

        mostDislikedOutfitsLabel.setBounds(10, 230, 370, 25);
        mostDislikedOutfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        mostDislikedOutfits.setBounds(10, 240, 370, 50);
        mostDislikedOutfitsScrollPane.setBounds(10, 260, 360, 80);

        backButton.setBounds(20,360,110,25);

    }

    private void addComponents() {
        panel.add(mostFollowedUsers);
//        panel.add(mostLikedOutfits);
//        panel.add(mostDislikedOutfits);
//        panel.add(mostFollowedUsersLabel);
        mostFollowedUsersScrollPane.setViewportView(mostFollowedUsers);
        mostLikedOutfitsScrollPane.setViewportView(mostLikedOutfits);
        mostDislikedOutfitsScrollPane.setViewportView(mostDislikedOutfits);
        panel.add(mostFollowedUsersScrollPane);
        panel.add(mostLikedOutfitsScrollPane);
        panel.add(mostDislikedOutfitsScrollPane);
        panel.add(mostFollowedUsersLabel);
        panel.add(mostLikedOutfitsLabel);
        panel.add(mostDislikedOutfitsLabel);
        panel.add(backButton);
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

    public void setBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void showScreen(){
        setVisible(true);
    }

    public void closeScreen(){
        dispose();
    }
}
