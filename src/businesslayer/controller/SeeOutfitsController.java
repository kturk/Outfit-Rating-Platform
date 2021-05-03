package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import presentationlayer.SeeOutfitsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeeOutfitsController {

    private List<Outfit> outfitModels;
    private User userModel;
    private SeeOutfitsScreen seeOutfitsView;
    private Mediator mediator;

    public SeeOutfitsController(List<Outfit> outfitModels, User userModel,
                                SeeOutfitsScreen seeOutfitsView, Mediator mediator) {
        this.outfitModels = outfitModels;
        this.userModel = userModel;
        this.seeOutfitsView = seeOutfitsView;

        this.seeOutfitsView.setOutfitList(getOutfitsWithNoAction());
        this.seeOutfitsView.setLikedOutfitList(getUsersLikedOutfits());
        this.seeOutfitsView.setDislikedOutfitList(getUsersDislikedOutfits());

        this.seeOutfitsView.addLikeButtonListener(new LikeButtonListener());
        this.seeOutfitsView.addDislikeButtonListener(new DislikeButtonListener());

        this.mediator = mediator;
    }

    private Object[] getOutfitsWithNoAction() {
        List<Integer> userInterractedOutfits = Stream
                .concat(userModel.getLikedOutfitIds().stream(), userModel.getDislikedOutfitIds().stream())
                .collect(Collectors.toList());
        return outfitModels.stream()
                .filter(o -> !userInterractedOutfits.contains(o.getId()))
                .toArray();
    }

    private Object[] getUsersLikedOutfits() {
        return outfitModels.stream()
                .filter(o -> userModel.getLikedOutfitIds().contains(o.getId()))
                .toArray();
    }

    private Object[] getUsersDislikedOutfits() {
        return outfitModels.stream()
                .filter(o -> userModel.getDislikedOutfitIds().contains(o.getId()))
                .toArray();
    }

    public void showView() {
        seeOutfitsView.showScreen();
    }

    public void closeView() {
        seeOutfitsView.closeScreen();
    }

    class LikeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Outfit selectedOutfit = (Outfit) seeOutfitsView.getOutfitList().getSelectedValue();
            selectedOutfit.increaseNumberOfLikes();
            userModel.addLikedOutfitId(selectedOutfit.getId());
        }
    }

    class DislikeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Outfit selectedOutfit = (Outfit) seeOutfitsView.getOutfitList().getSelectedValue();
            selectedOutfit.increaseNumberOfDislikes();
            userModel.addDislikedOutfitId(selectedOutfit.getId());
        }
    }
}
