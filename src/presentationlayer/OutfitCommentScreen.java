package presentationlayer;

import businesslayer.Observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;


public class OutfitCommentScreen extends JFrame implements Observer {

    private JPanel panel;

    private JList commentList;
    private JLabel commentsLabel;
    private JLabel newCommentLabel;

    private JButton postCommentButton;
    private JButton backButton;

    private JTextArea commentArea;

    JScrollPane scrollPane = new JScrollPane();

    public OutfitCommentScreen() {
        super("Comments");
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
        panel.setLayout(null);
    }

    private void addPanels() {
        add(panel);
    }

    private void initializeComponents() {

        commentList = new JList();
        postCommentButton = new JButton("Post");
        backButton = new JButton("Back");
        commentArea = new JTextArea();
        commentsLabel = new JLabel("Comments");
        newCommentLabel = new JLabel("New Comment:");
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);


    }

    private void locateComponents() {
        scrollPane.setBounds(40,30, 320,180);
        backButton.setBounds(20,360,110,25);
        commentsLabel.setBounds(0, 10,400,20);
        newCommentLabel.setBounds(0,220,400,20);
        commentArea.setBounds(40,250,320,60);
        postCommentButton.setBounds(160,330, 80, 25);

        commentsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newCommentLabel.setHorizontalAlignment(SwingConstants.CENTER);

        commentList.setBorder(new EmptyBorder(10,10, 10, 10));


    }

    private void addComponents() {
        panel.add(postCommentButton);
        panel.add(backButton);
        scrollPane.setViewportView(commentList);
        panel.add(scrollPane);
        panel.add(commentArea);
        panel.add(commentsLabel);
        panel.add(newCommentLabel);
    }


    public void addPostCommentButtonListener(ActionListener actionListener) {
        postCommentButton.addActionListener(actionListener);
    }

    public void setCommentList(Object[] itemList) {
        commentList.setListData(itemList);

    }

    public JList getCommentList() {
        return commentList;
    }

    public JTextArea getCommentArea() {
        return commentArea;
    }

    public void setBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }

    @Override
    public void update(List<?> list) {
        setCommentList(list.toArray());
    }
}
