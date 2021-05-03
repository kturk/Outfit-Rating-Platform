package presentationlayer;

import businesslayer.Observer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// All users without current user line by line
// Follow or unf buttons
public class SeeUsersScreen extends JFrame implements Observer{

    private JPanel panel;
    private JLabel usersLabel;
    private JLabel followedUsersLabel;

    private JList userList;
    private JList followedUserList;
    private JButton followButton;
    private JButton unfollowButton;

    private JButton backButton;

    public SeeUsersScreen() {
        super("User List: ");
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
        usersLabel = new JLabel("Users");
        followedUsersLabel = new JLabel("Following Users");
        userList = new JList();
        followedUserList = new JList();
        followButton = new JButton("Follow");
        unfollowButton = new JButton("Unfollow");
        backButton = new JButton("Back");
    }

    private void locateComponents() {

        usersLabel.setBounds(50,10,110,25);
        usersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        followedUsersLabel.setBounds(240,10,110,25);
        followedUsersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userList.setBounds(30,40, 150,250);
        followedUserList.setBounds(220,40,150,250);
        unfollowButton.setBounds(240,300,110, 25);
        followButton.setBounds(50,300,110,25);

        backButton.setBounds(20,360,110,25);

    }

    private void addComponents() {
        panel.add(usersLabel);
        panel.add(followedUsersLabel);
        panel.add(userList);
        panel.add(followedUserList);
        panel.add(followButton);
        panel.add(unfollowButton);
        panel.add(backButton);
    }

    public void setUserList(Object[] itemList) {
        userList.setListData(itemList);
    }

    public void setFollowedUserList(Object[] itemList) {
        followedUserList.setListData(itemList);
    }

    public JList getUserList() {
        return userList;
    }

    public JList getFollowedUserList() {
        return followedUserList;
    }



    public void addFollowButtonListener(ActionListener actionListener) {
        followButton.addActionListener(actionListener);
    }

    public void addUnfollowButtonListener(ActionListener actionListener) {
        unfollowButton.addActionListener(actionListener);
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

        ListModel listModel = userList.getModel();
        List<Object> newUserList = new ArrayList<Object>();
        for(int i=0; i<listModel.getSize(); i++){
            Object currentElement = listModel.getElementAt(i);
            if(!list.contains(currentElement)){
                newUserList.add(currentElement);
            }
        }
        setUserList(newUserList.toArray());
        setFollowedUserList(list.toArray());
    }
}
