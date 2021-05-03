package presentationlayer;


import javax.swing.*;
import java.awt.event.ActionListener;

public class FollowedUserCollectionDetailScreen extends JFrame{

    private JPanel panel;

    private JLabel outfitsLabel;

    private JList outfitList;

    JScrollPane outfitListScrollPane;

    private JButton backButton;


    public FollowedUserCollectionDetailScreen() {
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
        outfitList = new JList();
        outfitListScrollPane = new JScrollPane();
        backButton = new JButton("Back");

    }

    private void locateComponents() {
        outfitsLabel.setBounds(0,10,400,20);
        outfitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        outfitListScrollPane.setBounds(20,30,340,280);
        backButton.setBounds(20,360,110,25);

    }

    private void addComponents() {
        panel.add(outfitsLabel);
        outfitListScrollPane.setViewportView(outfitList);
        panel.add(outfitListScrollPane);
        panel.add(backButton);

    }

    public void setOutfitList(Object[] itemList) {
        outfitList.setListData(itemList);
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

}
