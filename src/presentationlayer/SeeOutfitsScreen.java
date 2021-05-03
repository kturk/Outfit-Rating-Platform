package presentationlayer;

// Add button on add to collection screen

import businesslayer.Observer;
import businesslayer.model.Outfit;
import businesslayer.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Like dislike comment buttons on like screen
public class SeeOutfitsScreen extends JFrame implements Observer{

    private JPanel panel;
    private JLabel selectOutfitLabel;
    private JLabel outfitsLabel;
    private JLabel likedOutfitsLabel;
    private JLabel dislikedOutfitsLabel;

    private JList outfitList;
    private JList likedOutfitList;
    private JList dislikedOutfitList;

    private JScrollPane outfitListPane;
    private JScrollPane likedOutfitListPane;
    private JScrollPane dislikedOutfitListPane;

    private JButton likeButton;
    private JButton dislikeButton;
    private JButton commentButton;

    private JButton backButton;

    public SeeOutfitsScreen() {
        super("Outfits");
        screenInitializer();
    }

    private void screenInitializer() {
        setSize(600,600);
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
        selectOutfitLabel = new JLabel("Select an outfit from All Outfits to make actions on them.");
        outfitsLabel = new JLabel("All Outfits");
        likedOutfitsLabel = new JLabel("Liked Outfits");
        dislikedOutfitsLabel = new JLabel("Disliked Outfits");

        outfitList = new JList();
        likedOutfitList = new JList();
        dislikedOutfitList = new JList();

        outfitListPane = new JScrollPane();
        likedOutfitListPane = new JScrollPane();
        dislikedOutfitListPane = new JScrollPane();

        likeButton = new JButton("Like");
        dislikeButton = new JButton("Dislike");
        commentButton = new JButton("Comment");

        backButton = new JButton("Back");
    }

    private void locateComponents() {
        selectOutfitLabel.setBounds(0,5,600,25);
        selectOutfitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        outfitsLabel.setBounds(0,35,600,25);
        outfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        likedOutfitsLabel.setBounds(0,230,600,25);
        likedOutfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dislikedOutfitsLabel.setBounds(0,365,600,25);
        dislikedOutfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        outfitListPane.setBounds(40,60, 500,120);
        likedOutfitListPane.setBounds(40,255,500,100);
        dislikedOutfitListPane.setBounds(40, 390, 500, 100);

        likeButton.setBounds(40,195,110,25);
        commentButton.setBounds(235,195,110,25);
        dislikeButton.setBounds(430,195,110, 25);

        backButton.setBounds(40,515,110,25);
    }

    private void addComponents() {
        panel.add(selectOutfitLabel);
        panel.add(outfitsLabel);
        panel.add(likedOutfitsLabel);
        panel.add(dislikedOutfitsLabel);
        outfitListPane.setViewportView(outfitList);
        likedOutfitListPane.setViewportView(likedOutfitList);
        dislikedOutfitListPane.setViewportView(dislikedOutfitList);
        panel.add(outfitListPane);
        panel.add(likedOutfitListPane);
        panel.add(dislikedOutfitListPane);
        panel.add(likeButton);
        panel.add(dislikeButton);
        panel.add(commentButton);
        panel.add(backButton);
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

    public void addCommentButtonListener(ActionListener actionListener) {
        commentButton.addActionListener(actionListener);
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

    @Override
    public void update(List<?> list) {
        List<Object> likedItemIds = (List<Object>) list.subList(0, list.indexOf(-1));
        List<Object> dislikedItemIds = (List<Object>) list.subList(list.indexOf(-1)+1, list.size());

        List<Object> likedItems = new ArrayList<Object>();
        List<Object> dislikedItems = new ArrayList<Object>();

//        List<Object> temp = new ArrayList<Object>();

        for (int i = 0; i < outfitList.getModel().getSize(); i++) {
            Outfit currentOutfit = (Outfit) outfitList.getModel().getElementAt(i);
            if (likedItemIds.contains(currentOutfit.getId()))
                likedItems.add(currentOutfit);
            else if (dislikedItemIds.contains(currentOutfit.getId()))
                dislikedItems.add(currentOutfit);
        }



        setLikedOutfitList(likedItems.toArray());
        setDislikedOutfitList(dislikedItems.toArray());
    }
}
