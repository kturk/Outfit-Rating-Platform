package presentationlayer;

// All collections showed line by line
// Add collection at bottom
// Choose collection in each line

import businesslayer.Observable;
import businesslayer.Observer;
import businesslayer.model.Collection;

import javax.swing.*;
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
        panel.setBackground(Color.BLUE);
    }

    private void locatePanels() {
//        panel.setBounds(40,100,20,20);
        panel.setLayout(null);
    }

    private void addPanels() {
        add(panel);
    }

    public String[] toArray(ArrayList<String> list) {
        String[] it = new String[list.size()];
        for(int i = 0; i < list.size(); i++)
            it[i] = list.get(i);
        return it;
    }

    private void initializeComponents() {
//        ArrayList<String> abc = new ArrayList<>();
//        abc.add("DENEME1");
//        abc.add("DENEME2");
//        abc.add("DENEME3");
//        abc.add("DENEME4");
//        abc.add("DENEME5");
//        System.out.println(abc);
//        String[] x = toArray(abc);
//        System.out.println(x);
//
//        collectionList = new JList(x);
//        collectionList.setBackground(Color.gray);

        collectionList = new JList();
        userLabel = new JLabel("User: Caner Tangüler");
        newCollectionLabel = new JLabel("New Collection:");
        newCollectionField = new JTextField();
        addNewCollectionButton = new JButton("Add");

    }

    private void locateComponents() {
        userLabel.setBounds(100, 100, 250 ,25);
        collectionList.setBounds(10,10, 300,120);
        newCollectionLabel.setBounds(30,300,100,25);
        newCollectionField.setBounds(130,300,150,25);
        addNewCollectionButton.setBounds(300,300, 80, 25);

    }

    private void addComponents() {
        panel.add(userLabel);
        panel.add(collectionList);
        panel.add(newCollectionField);
        panel.add(newCollectionLabel);
        panel.add(addNewCollectionButton);

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
    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }

    private Collection[] toArray(List<Collection> list) {
        System.out.println(list);
        Collection[] item = new Collection[list.size()];
        for(int i = 0; i < list.size(); i++)
            item[i] = list.get(i);
        return item;
    }

    @Override
    public void update(List<Collection> collections) {
        setList(toArray(collections));
    }


}
