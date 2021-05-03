package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Collection;
import businesslayer.model.User;
import presentationlayer.UserCollectionsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserCollectionsController {

    private final User userModel;
    private final UserCollectionsScreen userCollectionsView;
    private final Mediator mediator;

    public UserCollectionsController(User userModel, UserCollectionsScreen userCollectionsView, Mediator mediator) {
        this.userModel = userModel;
        this.userCollectionsView = userCollectionsView;
        this.mediator = mediator;

        this.userCollectionsView.setList(userModel.getCollections().toArray());

        userCollectionsView.addNewCollectionListener(new AddCollectionListener());
        userCollectionsView.addShowDetailsListener(new ShowDetailsListener());
        userCollectionsView.setBackButtonListener(new BackListener());

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
            closeView();
            mediator.navigateToMainScreen();
        }
    }

    class AddCollectionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String collectionName = userCollectionsView.getNewCollectionField().getText();
            if (!collectionName.equals("")) {
                addNewCollection(collectionName);
                mediator.writeXML();
            }
            else
                userCollectionsView.showError("Please enter a collection name.");
        }
    }

    class ShowDetailsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Collection selectedCollection = (Collection) userCollectionsView.getCollectionList().getSelectedValue();
            if (selectedCollection != null) {
                closeView();
                mediator.navigateToCollectionDetailsScreen(selectedCollection);
            }
            else
                userCollectionsView.showError("Please select a collection from the list.");
        }
    }
}
