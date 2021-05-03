package presentationlayer;

// Add button on add to collection screen

import businesslayer.Observer;
import businesslayer.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Like dislike comment buttons on like screen
public class SeeOutfitsScreen extends JFrame {

    private JPanel panel;
    private JLabel outfitsLabel;
    private JLabel likedOutfitsLabel;
    private JLabel dislikedOutfitsLabel;

    private JList outfitList;
    private JList likedOutfitList;
    private JList dislikedOutfitList;
    private JButton likeButton;
    private JButton dislikeButton;

    private JLabel commentLabel;
    private JButton commentButton;

    public SeeOutfitsScreen() {
        super("Outfits");
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
        outfitsLabel = new JLabel("Outfits");
        likedOutfitsLabel = new JLabel("Liked");
        dislikedOutfitsLabel = new JLabel("Disliked");
        outfitList = new JList();
        likedOutfitList = new JList();
        dislikedOutfitList = new JList();
        likeButton = new JButton("Like");
        dislikeButton = new JButton("Dislike");
        commentLabel = new JLabel();
        commentButton = new JButton("Comment");
    }

    private void locateComponents() {
        outfitsLabel.setBounds(10,10,110,25);
        outfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        likedOutfitsLabel.setBounds(140,10,110,25);
        likedOutfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dislikedOutfitsLabel.setBounds(270,10,110,25);
        dislikedOutfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        outfitList.setBounds(10,40, 110,150);
        likedOutfitList.setBounds(140,40,110,150);
        dislikedOutfitList.setBounds(270, 40, 110, 150);

        likeButton.setBounds(70,200,110,25);
        dislikeButton.setBounds(200,200,110, 25);
    }

    private void addComponents() {
        panel.add(outfitsLabel);
        panel.add(likedOutfitsLabel);
        panel.add(dislikedOutfitsLabel);
        panel.add(outfitList);
        panel.add(likedOutfitList);
        panel.add(dislikedOutfitList);
        panel.add(likeButton);
        panel.add(dislikeButton);
    }

    public JList getOutfitList() {
        return outfitList;
    }

    public JList getLikedOutfitList() {
        return likedOutfitList;
    }

    public JList getDislikedOutfitList() {
        return dislikedOutfitList;
    }

    public void setOutfitList(Object[] outfits) {
        outfitList.setListData(outfits);
    }

    public void setLikedOutfitList(Object[] outfits) {
        likedOutfitList.setListData(outfits);
    }

    public void setDislikedOutfitList(Object[] outfits) {
        dislikedOutfitList.setListData(outfits);
    }

    public void addLikeButtonListener(ActionListener actionListener) {
        likeButton.addActionListener(actionListener);
    }

    public void addDislikeButtonListener(ActionListener actionListener) {
        dislikeButton.addActionListener(actionListener);
    }

    public void showScreen(){
        setVisible(true);
    }

    public void closeScreen(){
        dispose();
    }
}
