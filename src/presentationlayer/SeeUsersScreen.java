package presentationlayer;

import businesslayer.Observer;
import businesslayer.model.Collection;
import businesslayer.model.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// All users without current user line by line
// Follow or unf buttons
public class SeeUsersScreen extends JFrame {

    private JPanel panel;
    private JLabel userLabel;
    private JList<String> userList;


    public SeeUsersScreen(List<User> users, User user) {
        super("User List: ");
        screenInitializer(users, user);
    }

    private void screenInitializer(List<User> users, User user) {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializePanels();
        locatePanels();
        addPanels();

        initializeComponents(users, user);
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

    private void initializeComponents(List<User> users, User user) {
        userLabel = new JLabel("Current user: " + user.getUserName().toUpperCase());
        userList = new JList<String>(toArray(users, user));
    }

    private void locateComponents() {
        userLabel.setBounds(10, 10, 250 ,25);
        userList.setBounds(10,40, 380,250);
    }

    private void addComponents() {
        panel.add(userLabel);
        panel.add(userList);
    }

    public void setList(String[] itemList) {
        userList.setListData(itemList);
        userList.setBackground(Color.gray);
    }

    private String[] toArray(List<User> users, User user) {
        System.out.println(users);
        String[] item = new String[users.size()];
        for(int i = 0; i < users.size(); i++)
            if (!users.get(i).equals(user))
                item[i] = users.get(i).getUserName();
        return item;
    }

    public void showScreen(){
        setVisible(true);
    }

    public void closeScreen(){
        dispose();
    }


}
