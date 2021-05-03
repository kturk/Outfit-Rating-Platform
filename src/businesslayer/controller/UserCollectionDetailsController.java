package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Collection;
import businesslayer.model.Outfit;
import presentationlayer.UserCollectionDetailScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserCollectionDetailsController {

    private Collection collectionModel;
    private List<Outfit> outfitModels;
    private UserCollectionDetailScreen collectionDetailView;
    private Mediator mediator;

    public UserCollectionDetailsController(Collection collectionModel, List<Outfit> outfitModels, UserCollectionDetailScreen collectionDetailView, Mediator mediator) {
        this.collectionModel = collectionModel;
        this.outfitModels = outfitModels;
        this.collectionDetailView = collectionDetailView;
        this.mediator = mediator;

//        collectionDetailView.setOutfitList(outfitModels.toArray());
//        collectionDetailView.setAddedOutfitList(getOutfitsFromIdList(collectionModel.getOutfitIds()));
        collectionDetailView.setOutfitList(getOutfitsNotAdded());
        collectionDetailView.setAddedOutfitList(collectionModel.getOutfits().toArray());

        collectionDetailView.setAddOutfitButtonListener(new AddOutfitsListener());
        collectionDetailView.setRemoveOutfitButtonListener(new RemoveOutfitsListener());
        collectionDetailView.setBackButtonListener(new BackListener());
    }

    private Object[] getOutfitsNotAdded() {
        List<Outfit> tempOutfitList = new ArrayList<Outfit>(this.outfitModels);
        tempOutfitList.removeAll(collectionModel.getOutfits());
        return tempOutfitList.toArray();
    }

    private Object[] getOutfitsFromIdList(List<Integer> idList) {
        List<Outfit> outfitList = new ArrayList<Outfit>();
        for(Outfit outfit : outfitModels){
            if(idList.contains(outfit.getId())){
                outfitList.add(outfit);
            }
        }
        return outfitList.toArray();
    }

    public void showView() {
        collectionDetailView.showScreen();
    }

    public void closeView() {
        collectionDetailView.closeScreen();
    }

    class AddOutfitsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Outfit selectedOutfit = (Outfit) collectionDetailView.getOutfitList().getSelectedValue();
            collectionModel.addOutfit(selectedOutfit);
        }
    }

    class RemoveOutfitsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            collectionDetailView.setOutfitList(outfitModels.toArray());
            Outfit selectedOutfit = (Outfit) collectionDetailView.getAddedOutfitList().getSelectedValue();
            collectionModel.removeOutfit(selectedOutfit);
        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            collectionDetailView.closeScreen();
            mediator.navigateToUsersCollectionsScreen();
        }
    }




}
