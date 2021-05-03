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

    private final Collection collectionModel;
    private final List<Outfit> outfitModels;
    private final UserCollectionDetailScreen collectionDetailView;
    private final Mediator mediator;

    public UserCollectionDetailsController(Collection collectionModel, List<Outfit> outfitModels,
                                           UserCollectionDetailScreen collectionDetailView, Mediator mediator) {
        this.collectionModel = collectionModel;
        this.outfitModels = outfitModels;
        this.collectionDetailView = collectionDetailView;
        this.mediator = mediator;

        collectionDetailView.setOutfitList(getOutfitsNotAdded());
        collectionDetailView.setAddedOutfitList(getOutfitsFromIdList(collectionModel.getOutfitIds()));

        collectionDetailView.setAddOutfitButtonListener(new AddOutfitsListener());
        collectionDetailView.setRemoveOutfitButtonListener(new RemoveOutfitsListener());
        collectionDetailView.setBackButtonListener(new BackListener());
    }

    private Object[] getOutfitsNotAdded() {
        List<Outfit> tempOutfitList = new ArrayList<Outfit>(this.outfitModels);
        tempOutfitList.removeIf(o -> collectionModel.getOutfitIds().contains(o.getId()));
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
            if (selectedOutfit != null) {
                collectionModel.addOutfit(selectedOutfit.getId());
                mediator.writeXML();
            }
            else
                collectionDetailView.showError("Please select an outfit from the list.");
        }
    }

    class RemoveOutfitsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Outfit selectedOutfit = (Outfit) collectionDetailView.getAddedOutfitList().getSelectedValue();
            if (selectedOutfit != null) {
                collectionModel.removeOutfit(selectedOutfit.getId());
                mediator.writeXML();
            }
            else
                collectionDetailView.showError("Please select an user from the list.");
        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToUsersCollectionsScreen();
        }
    }




}
