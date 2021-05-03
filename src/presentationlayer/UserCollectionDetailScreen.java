package presentationlayer;

import businesslayer.Observer;
import businesslayer.model.Outfit;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    public void update(List<?> list) {

        ListModel outfitListModel = outfitList.getModel();
        ListModel addedOutfitListModel = addedOutfitList.getModel();


        List<Object> newOutfitsList = new ArrayList<Object>();
        List<Object> newAddedOutfitsList = new ArrayList<Object>();

        for(int i=0; i<outfitListModel.getSize(); i++){
            Outfit currentElement = (Outfit) outfitListModel.getElementAt(i);
            if(!list.contains(currentElement.getId())){
                newOutfitsList.add(currentElement);
            }
            else{
                newAddedOutfitsList.add(currentElement);
            }
        }

        for(int i=0; i<addedOutfitListModel.getSize(); i++){
            Outfit currentElement = (Outfit) addedOutfitListModel.getElementAt(i);
            if(!list.contains(currentElement.getId())){
                newOutfitsList.add(currentElement);
            }
            else{
                newAddedOutfitsList.add(currentElement);
            }
        }
        setOutfitList(newOutfitsList.toArray());
        setAddedOutfitList(newAddedOutfitsList.toArray());
    }
}
