package presentationlayer;


import javax.swing.*;
import java.awt.event.ActionListener;

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
        panel = new JPanel();
    }

    private void locatePanels() {
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
        mostFollowedUsersScrollPane.setBounds(10, 40, 360, 80);

        mostLikedOutfitsLabel.setBounds(10, 120, 370, 25);
        mostLikedOutfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mostLikedOutfitsScrollPane.setBounds(10, 150, 360, 80);

        mostDislikedOutfitsLabel.setBounds(10, 230, 370, 25);
        mostDislikedOutfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mostDislikedOutfitsScrollPane.setBounds(10, 260, 360, 80);

        backButton.setBounds(20,360,110,25);

    }

    private void addComponents() {
        panel.add(mostFollowedUsers);
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

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
