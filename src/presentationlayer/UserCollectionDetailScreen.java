package presentationlayer;

// All items line by line
// Add button at bottom

import businesslayer.Observer;
import businesslayer.model.Outfit;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// If if does not belong to viewer dont show add button
public class UserCollectionDetailScreen extends JFrame implements Observer {

    private JPanel panel;

    private JLabel outfitsLabel;
    private JLabel collectionOutfitsLabel;

    private JList outfitList;
    private JList addedOutfitList;

    JScrollPane outfitListScrollPane;
    JScrollPane addedOutfitListScrollPane;

    private JButton addOutfitButton;
    private JButton removeOutfitButton;
    private JButton backButton;


    public UserCollectionDetailScreen() {
        super("Collection Detail");
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

        outfitsLabel = new JLabel("All Outfits");
        collectionOutfitsLabel = new JLabel("Collection's Outfits");

        outfitList = new JList();
        addedOutfitList = new JList();

        outfitListScrollPane = new JScrollPane();
        addedOutfitListScrollPane = new JScrollPane();

        addOutfitButton = new JButton("Add");
        removeOutfitButton = new JButton("Remove");

        backButton = new JButton("Back");

    }

    private void locateComponents() {
        outfitsLabel.setBounds(0,10,400,20);
        collectionOutfitsLabel.setBounds(0,205,400,20);
        outfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        collectionOutfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        outfitListScrollPane.setBounds(20,30,340,120);
        addedOutfitListScrollPane.setBounds(20,230,340,120);

        addOutfitButton.setBounds(60,170,110,25);
        removeOutfitButton.setBounds(230,170,110,25);

        backButton.setBounds(20,360,110,25);

    }

    private void addComponents() {
        panel.add(outfitsLabel);
        panel.add(collectionOutfitsLabel);

        outfitListScrollPane.setViewportView(outfitList);
        addedOutfitListScrollPane.setViewportView(addedOutfitList);
        panel.add(outfitListScrollPane);
        panel.add(addedOutfitListScrollPane);

        panel.add(addOutfitButton);
        panel.add(removeOutfitButton);
        panel.add(backButton);

    }

    public JList getOutfitList() {
        return outfitList;
    }

    public JList getAddedOutfitList() {
        return addedOutfitList;
    }

    public void setOutfitList(Object[] itemList) {
        outfitList.setListData(itemList);
    }

    public void setAddedOutfitList(Object[] itemList) {
        addedOutfitList.setListData(itemList);
    }

    public void setAddOutfitButtonListener(ActionListener actionListener) {
        addOutfitButton.addActionListener(actionListener);
    }

    public void setRemoveOutfitButtonListener(ActionListener actionListener) {
        removeOutfitButton.addActionListener(actionListener);
    }

    public void setBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
//
//    public JTextField getNewCollectionField() {
//        return newCollectionField;
//    }
//
//    public void setList(Object[] itemList) {
//        collectionList.setListData(itemList);
//        collectionList.setBackground(Color.gray);
//
//    }
//
//    public JList getCollectionList() {
//        return collectionList;
//    }
//
//    public void addSelectListener(ListSelectionListener listSelectionListener) {
//        collectionList.addListSelectionListener(listSelectionListener);
//    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }

    @Override
    public void update(List<?> list) {

        ListModel listModel = outfitList.getModel();
        List<Object> newOutfitsList = new ArrayList<Object>();
        for(int i=0; i<listModel.getSize(); i++){
            Outfit currentElement = (Outfit) listModel.getElementAt(i);
            if(!list.contains(currentElement.getId())){
                newOutfitsList.add(currentElement);
            }
        }
        setOutfitList(newOutfitsList.toArray());
        setAddedOutfitList(list.toArray());
    }
}
