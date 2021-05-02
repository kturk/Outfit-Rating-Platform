package presentationlayer;

import businesslayer.model.Outfit;
import businesslayer.model.User;

import javax.swing.*;
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

    public StatisticsScreen(List<User> users, List<Outfit> outfits, User user) {
        super("Statistics page");
        screenInitializer(users, outfits, user);
    }

    private void screenInitializer(List<User> users, List<Outfit> outfits, User user) {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializePanels();
        locatePanels();
        addPanels();

        initializeComponents(users, outfits, user);
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

    private void initializeComponents(List<User> users, List<Outfit> outfits, User user) {
        userLabel = new JLabel("Current user: " + user.getUserName().toUpperCase());
        mostFollowedUsers = new JList<Object>(getMostFollowedUsers(users));
        mostLikedOutfits = new JList<Object>(getMostLikedOutfit(outfits));
        mostDislikedOutfits = new JList<Object>(getMostDislikedOutfit(outfits));
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

    private Object[] getMostFollowedUsers(List<User> users) {
        User mostFollowedUser = users.stream()
                .max(Comparator.comparing(v -> v.getFollowerUsers().size())).get();

        List<User> mostFollowedUsers = users.stream()
                .filter(v -> v.getFollowerUsers().size() == mostFollowedUser.getFollowerUsers().size())
                .collect(Collectors.toList());

        return toArray(mostFollowedUsers);
    }

    private Object[] getMostLikedOutfit(List<Outfit> outfits) {
        Outfit mostLikedOutfit = outfits.stream()
                .max(Comparator.comparing(Outfit::getNumberOfLikes)).get();

        List<Outfit> mostLikedOutfits = outfits.stream()
                .filter(v -> v.getNumberOfLikes() == mostLikedOutfit.getNumberOfLikes())
                .collect(Collectors.toList());

        return toArray(mostLikedOutfits);
    }

    private Object[] getMostDislikedOutfit(List<Outfit> outfits) {
        Outfit mostDislikedOutfit = outfits.stream()
                .max(Comparator.comparing(Outfit::getNumberOfDislikes)).get();

        List<Outfit> mostDislikedOutfits = outfits.stream()
                .filter(v -> v.getNumberOfDislikes() == mostDislikedOutfit.getNumberOfDislikes())
                .collect(Collectors.toList());

        return toArray(mostDislikedOutfits);
    }

    private Object[] toArray(List<?> list) {
        System.out.println(list);
        Object[] item = new Object[list.size()];
        for(int i = 0; i < list.size(); i++)
            item[i] = list.get(i);
        return item;
    }

    public void showScreen(){
        setVisible(true);
    }

    public void closeScreen(){
        dispose();
    }
}
