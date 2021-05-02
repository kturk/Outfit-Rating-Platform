package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Collection;
import businesslayer.model.User;
import presentationlayer.UserCollectionsScreen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserCollectionsController {

    private User userModel;
    private UserCollectionsScreen userCollectionsView;
    private Mediator mediator;

    public UserCollectionsController(User userModel, UserCollectionsScreen userCollectionsView, Mediator mediator) {
        this.userModel = userModel;
        this.userCollectionsView = userCollectionsView;
        this.mediator = mediator;

        this.userCollectionsView.setList(userModel.getCollections().toArray());

        userCollectionsView.addNewCollectionListener(new AddCollectionListener());
        userCollectionsView.addSelectListener(new SelectionListener());

    }

    public void showView() {
        userCollectionsView.showScreen();
    }

    public void closeView() {
        userCollectionsView.closeScreen();
    }

    private void addNewCollection(String collectionName){
        this.userModel.createCollection(new Collection(collectionName));
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            userCollectionsView.closeScreen();
//            mediator.navigateToMainScreen();
        }
    }

    class AddCollectionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String collectionName = userCollectionsView.getNewCollectionField().getText();
            addNewCollection(collectionName);
        }
    }

    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            JList source = (JList)e.getSource();
            Collection s = (Collection) source.getSelectedValue();
            System.out.println(s.getId());

        }
    }
}
