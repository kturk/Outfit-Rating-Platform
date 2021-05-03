package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import presentationlayer.OutfitCommentScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutfitCommentController {

    private User userModel;
    private Outfit outfitModel;
    private OutfitCommentScreen outfitCommentView;
    private Mediator mediator;

    public OutfitCommentController(User userModel,
                                   Outfit outfitModel,
                                   OutfitCommentScreen outfitCommentView,
                                   Mediator mediator) {
        this.userModel = userModel;
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
            outfitCommentView.closeScreen();
            mediator.navigateToSeeOutfitsScreen(userModel);
        }
    }

    class PostCommentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String newComment = outfitCommentView.getCommentArea().getText();
            outfitModel.addComment(newComment);
        }
    }
}
