package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import presentationlayer.SeeOutfitsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SeeOutfitsController {

    private final List<Outfit> outfitModels;
    private final User userModel;
    private final SeeOutfitsScreen seeOutfitsView;
    private final Mediator mediator;

    public SeeOutfitsController(List<Outfit> outfitModels, User userModel,
                                SeeOutfitsScreen seeOutfitsView, Mediator mediator) {
        this.outfitModels = outfitModels;
        this.userModel = userModel;
        this.seeOutfitsView = seeOutfitsView;

        this.seeOutfitsView.setOutfitList(outfitModels.toArray());
        this.seeOutfitsView.setLikedOutfitList(getUsersLikedOutfits());
        this.seeOutfitsView.setDislikedOutfitList(getUsersDislikedOutfits());

        this.seeOutfitsView.addLikeButtonListener(new LikeButtonListener());
        this.seeOutfitsView.addDislikeButtonListener(new DislikeButtonListener());
        this.seeOutfitsView.addCommentButtonListener(new CommentButtonListener());
        this.seeOutfitsView.setBackButtonListener(new BackListener());

        this.mediator = mediator;
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
            if (selectedOutfit != null) {
                if (!userModel.isLikedOutfitsContainsId(selectedOutfit.getId())) {
                    selectedOutfit.increaseNumberOfLikes();
                    if (userModel.isDislikedOutfitsContainsId(selectedOutfit.getId()))
                        selectedOutfit.decreaseNumberOfDislikes();
                    userModel.addLikedOutfitId(selectedOutfit.getId());
                    mediator.writeJSON();
                }
            }
            else
                seeOutfitsView.showError("Please select an outfit from the list.");
        }
    }

    class DislikeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Outfit selectedOutfit = (Outfit) seeOutfitsView.getOutfitList().getSelectedValue();
            if (selectedOutfit != null) {
                if (!userModel.isDislikedOutfitsContainsId(selectedOutfit.getId())) {
                    selectedOutfit.increaseNumberOfDislikes();
                    if (userModel.isLikedOutfitsContainsId(selectedOutfit.getId()))
                        selectedOutfit.decreaseNumberOfLikes();
                    userModel.addDislikedOutfitId(selectedOutfit.getId());
                    mediator.writeJSON();
                }
            }
            else
                seeOutfitsView.showError("Please select an outfit from the list.");
        }
    }

    class CommentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Outfit selectedOutfit = (Outfit) seeOutfitsView.getOutfitList().getSelectedValue();
            if (selectedOutfit != null) {
                closeView();
                mediator.navigateToOutfitCommentScreen(selectedOutfit);
            }
            else
                seeOutfitsView.showError("Please select an outfit from the list.");
        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToMainScreen();
        }
    }
}
