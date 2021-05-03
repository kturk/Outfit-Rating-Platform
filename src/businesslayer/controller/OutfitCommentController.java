package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Outfit;
import presentationlayer.OutfitCommentScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutfitCommentController {

    private final Outfit outfitModel;
    private final OutfitCommentScreen outfitCommentView;
    private final Mediator mediator;

    public OutfitCommentController(Outfit outfitModel,
                                   OutfitCommentScreen outfitCommentView,
                                   Mediator mediator) {
        this.outfitModel = outfitModel;
        this.outfitCommentView = outfitCommentView;
        this.mediator = mediator;

        this.outfitCommentView.setCommentList(outfitModel.getComments().toArray());

        this.outfitCommentView.setBackButtonListener(new BackListener());
        this.outfitCommentView.addPostCommentButtonListener(new PostCommentListener());
    }

    public void showView() {
        outfitCommentView.showScreen();
    }

    public void closeView() {
        outfitCommentView.closeScreen();
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToSeeOutfitsScreen();
        }
    }

    class PostCommentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String newComment = outfitCommentView.getCommentArea().getText();
            if (!newComment.equals("")) {
                outfitModel.addComment(newComment);
                mediator.writeJSON();
            }
            else
                outfitCommentView.showError("Please enter a comment.");
        }
    }
}
