package presentationlayer;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainScreen extends JFrame{

    private JPanel buttonsPanel;

    private JButton collectionsButton;
    private JButton statisticsButton;
    private JButton followButton;


    public MainScreen() {
        super("Main Screen");
        screenInitializer();

//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e){
//                label.setText("Merhaba " + text.getText());
//            }
//        });

    }

    private void screenInitializer() {
        setSize(300,250);
//        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializePanels();
        locatePanels();
        addPanels();

        initializeComponents();
        locateComponents();
        addComponents();
        buttonListeners();
        setVisible(true);

    }

    private void initializePanels() {
        buttonsPanel = new JPanel();
    }

    private void locatePanels() {
        buttonsPanel.setLayout(null);
    }

    private void addPanels() {
        add(buttonsPanel);
    }

    private void initializeComponents() {
        collectionsButton = new JButton("Collections");
        statisticsButton = new JButton("Statistics");
        followButton = new JButton("Follow");

    }

    private void locateComponents() {
        collectionsButton.setBounds(20,20,100,25);
        statisticsButton.setBounds(20,60,100,25);
        followButton.setBounds(20,100,100,25);

    }

    private void addComponents() {
        buttonsPanel.add(collectionsButton);
        buttonsPanel.add(statisticsButton);
        buttonsPanel.add(followButton);
    }

    public void buttonListeners() {
        collectionsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("action");
            }
        });
    }

    public void setVisible(Boolean visible){
        setVisible(visible);
    }
}
