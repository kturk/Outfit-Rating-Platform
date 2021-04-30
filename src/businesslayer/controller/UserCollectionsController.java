package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Collection;
import businesslayer.model.User;
import presentationlayer.UserCollectionsScreen;

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
        userModel.createCollection(new Collection("ABC"));
//        aa();

        userCollectionsView.addNewCollectionListener(new AddCollectionListener());

    }

    public void showView() {
        userCollectionsView.showScreen();
    }

    public void closeView() {
        userCollectionsView.closeScreen();
    }

    private Collection[] toArray(List<Collection> list) {
        System.out.println(list);
        Collection[] item = new Collection[list.size()];
        for(int i = 0; i < list.size(); i++)
            item[i] = list.get(i);
        return item;
    }

//    private Collection[] aa(){
////        ArrayList<String> abc = new ArrayList<>();
////        abc.add("DENEME1");
////        abc.add("DENEME22");
////        abc.add("DENEME33");
////        abc.add("DENEME43");
////        abc.add("DENEME5");
////        System.out.println(abc);
//        Collection[] x = toArray(collectionModels);
//        System.out.println("x" + x);
//        userCollectionsView.setList(x);
//        return x;
//    }

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
}
