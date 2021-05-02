package presentationlayer;

// All collections showed line by line
// Add collection at bottom
// Choose collection in each line

import businesslayer.Observable;
import businesslayer.Observer;
import businesslayer.model.Collection;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// Navigate to CollectionDetailScreen onPress
public class UserCollectionsScreen extends JFrame implements Observer {

    private JPanel panel;
    private JLabel userLabel;
    private JList collectionList;
    private JTextField newCollectionField;
    private JLabel newCollectionLabel;
    private JButton addNewCollectionButton;
    private JButton showDetailsButton;

    private DefaultListModel model = new DefaultListModel();

    public UserCollectionsScreen() {
        super("My Collections");
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

        collectionList = new JList();
        userLabel = new JLabel("User: Caner Tangüler");
        newCollectionLabel = new JLabel("New Collection:");
        newCollectionField = new JTextField();
        addNewCollectionButton = new JButton("Add");
        showDetailsButton = new JButton("Show");

    }

    private void locateComponents() {
        collectionList.setBounds(40,15, 320,220);
        newCollectionLabel.setBounds(10,300,100,25);
        newCollectionField.setBounds(125,300,150,25);
        addNewCollectionButton.setBounds(290,300, 80, 25);
        showDetailsButton.setBounds(160,250, 80, 25);


    }

    private void addComponents() {
        panel.add(collectionList);
        panel.add(newCollectionField);
        panel.add(newCollectionLabel);
        panel.add(addNewCollectionButton);
        panel.add(showDetailsButton);

    }

    public void addNewCollectionListener(ActionListener actionListener) {
        addNewCollectionButton.addActionListener(actionListener);
    }

    public JTextField getNewCollectionField() {
        return newCollectionField;
    }

    public void setList(Object[] itemList) {
        collectionList.setListData(itemList);
        collectionList.setBackground(Color.gray);

    }

    public JList getCollectionList() {
        return collectionList;
    }

    public void addSelectListener(ListSelectionListener listSelectionListener) {
        collectionList.addListSelectionListener(listSelectionListener);
    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }

    @Override
    public void update(List<?> collections) {
        setList(collections.toArray());
    }


}
