package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Collection;
import presentationlayer.UserCollectionsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserCollectionsController {

    private List<Collection> collectionModels;
    private UserCollectionsScreen userCollectionsView;
    private Mediator mediator;

    public UserCollectionsController(List<Collection> collectionModels, UserCollectionsScreen userCollectionsView, Mediator mediator) {
        this.collectionModels = collectionModels;
        this.userCollectionsView = userCollectionsView;
        this.mediator = mediator;
        collectionModels.add(new Collection("ABC"));
        aa();
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

    private Collection[] aa(){
//        ArrayList<String> abc = new ArrayList<>();
//        abc.add("DENEME1");
//        abc.add("DENEME22");
//        abc.add("DENEME33");
//        abc.add("DENEME43");
//        abc.add("DENEME5");
//        System.out.println(abc);
        Collection[] x = toArray(collectionModels);
        System.out.println("x" + x);
        userCollectionsView.setList(x);
        return x;
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            userCollectionsView.closeScreen();
//            mediator.navigateToMainScreen();
        }
    }
}
