package presentationlayer;

import businesslayer.Observer;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

// User -- Collection Name - See Button
// See Button navigates to CollectionDetailScreen
public class FollowedUsersCollectionsScreen extends JFrame{

    private JPanel panel;

    private JList collectionList;

    private JButton showDetailsButton;
    private JButton backButton;

    JScrollPane scrollPane = new JScrollPane();

    private DefaultListModel model = new DefaultListModel();

    public FollowedUsersCollectionsScreen() {
        super("My Collections");
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

        collectionList = new JList();
        showDetailsButton = new JButton("Show");
        backButton = new JButton("Back");

    }

    private void locateComponents() {
        scrollPane.setBounds(40,15, 320,220);
        showDetailsButton.setBounds(160,250, 80, 25);

        backButton.setBounds(20,360,110,25);


    }

    private void addComponents() {
        panel.add(showDetailsButton);
        panel.add(backButton);
        scrollPane.setViewportView(collectionList);
        panel.add(scrollPane);

    }


    public void addShowDetailsListener(ActionListener actionListener) {
        showDetailsButton.addActionListener(actionListener);
    }

    public void setList(Object[] itemList) {
        collectionList.setListData(itemList);
        collectionList.setBackground(Color.gray);

    }

    public JList getCollectionList() {
        return collectionList;
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

}
