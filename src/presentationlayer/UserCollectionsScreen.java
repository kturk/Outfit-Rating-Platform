package presentationlayer;


import businesslayer.Observer;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.List;

public class UserCollectionsScreen extends JFrame implements Observer {

    private JPanel panel;
    private JLabel collectionLabel;
    private JList collectionList;
    private JTextField newCollectionField;
    private JLabel newCollectionLabel;
    private JButton addNewCollectionButton;
    private JButton showDetailsButton;
    private JButton backButton;

    JScrollPane scrollPane = new JScrollPane();

    public UserCollectionsScreen() {
        super("My Collections");
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
        collectionLabel = new JLabel("My Collections");
        collectionList = new JList();
        newCollectionLabel = new JLabel("New Collection:");
        newCollectionField = new JTextField();
        addNewCollectionButton = new JButton("Add");
        showDetailsButton = new JButton("Show");
        backButton = new JButton("Back");
    }

    private void locateComponents() {
        collectionLabel.setBounds(0, 5, 400, 25);
        collectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane.setBounds(40,30, 320,220);

        newCollectionLabel.setBounds(10,315,100,25);
        newCollectionField.setBounds(125,315,150,25);
        addNewCollectionButton.setBounds(290,315, 80, 25);
        showDetailsButton.setBounds(160,265, 80, 25);

        backButton.setBounds(20,360,110,25);
    }

    private void addComponents() {
        panel.add(collectionLabel);
        panel.add(newCollectionField);
        panel.add(newCollectionLabel);
        panel.add(addNewCollectionButton);
        panel.add(showDetailsButton);
        panel.add(backButton);
        scrollPane.setViewportView(collectionList);
        panel.add(scrollPane);
    }

    public void addNewCollectionListener(ActionListener actionListener) {
        addNewCollectionButton.addActionListener(actionListener);
    }

    public void addShowDetailsListener(ActionListener actionListener) {
        showDetailsButton.addActionListener(actionListener);
    }

    public JTextField getNewCollectionField() {
        return newCollectionField;
    }

    public void setList(Object[] itemList) {
        collectionList.setListData(itemList);
    }

    public JList getCollectionList() {
        return collectionList;
    }

    public void addSelectListener(ListSelectionListener listSelectionListener) {
        collectionList.addListSelectionListener(listSelectionListener);
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

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    @Override
    public void update(List<?> collections) {
        setList(collections.toArray());
    }
}
