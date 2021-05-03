package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Collection;
import businesslayer.model.Outfit;
import presentationlayer.FollowedUserCollectionDetailScreen;
import presentationlayer.UserCollectionDetailScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FollowedCollectionDetailsController {

    private Collection collectionModel;
    private List<Outfit> outfitModels;
    private FollowedUserCollectionDetailScreen followedUserCollectionDetailView;
    private Mediator mediator;

    public FollowedCollectionDetailsController(Collection collectionModel, List<Outfit> outfitModels, FollowedUserCollectionDetailScreen followedUserCollectionDetailView, Mediator mediator) {
        this.collectionModel = collectionModel;
        this.outfitModels = outfitModels;
        this.followedUserCollectionDetailView = followedUserCollectionDetailView;
        this.mediator = mediator;

//        followedUserCollectionDetailView.setOutfitList(collectionModel.getOutfits().toArray());

        followedUserCollectionDetailView.setBackButtonListener(new BackListener());
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
        followedUserCollectionDetailView.showScreen();
    }

    public void closeView() {
        followedUserCollectionDetailView.closeScreen();
    }


    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            followedUserCollectionDetailView.closeScreen();
            mediator.navigateToFollowedUsersCollectionsScreen();
        }
    }




}
