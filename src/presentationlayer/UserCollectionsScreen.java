package presentationlayer;

// All collections showed line by line
// Add collection at bottom
// Choose collection in each line

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

// Navigate to CollectionDetailScreen onPress
public class UserCollectionsScreen extends JFrame{

    private JPanel panel;
    private JLabel userLabel;
    private JList collectionList;

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
    }

    public void setList(Object[] itemList) {
        collectionList.setListData(itemList);
        collectionList.setBackground(Color.gray);

    }

    private void locateComponents() {
        userLabel.setBounds(100, 100, 250 ,25);
        collectionList.setBounds(10,10, 300,120);

    }

    private void addComponents() {
        panel.add(userLabel);
        panel.add(collectionList);

    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }
}
