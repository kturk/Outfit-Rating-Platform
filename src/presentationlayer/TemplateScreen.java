package presentationlayer;

// All collections showed line by line
// Add collection at bottom
// Choose collection in each line

import javax.swing.*;

// Navigate to CollectionDetailScreen onPress
public class TemplateScreen extends JFrame{

    private JPanel panel;

    public TemplateScreen() {
        super("Template");
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
        panel.setLayout(null);
    }

    private void addPanels() {
        add(panel);
    }

    private void initializeComponents() {
//        userLabel = new JLabel("User: Caner Tangüler");
    }

    private void locateComponents() {
//        userLabel.setBounds(75, 30, 250 ,25);
    }

    private void addComponents() {
//        buttonsPanel.add(userLabel);
    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }
}
