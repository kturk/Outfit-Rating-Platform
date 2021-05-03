package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import presentationlayer.StatisticsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;

public class StatisticsController {

    private final List<User> userModels;
    private final List<Outfit> outfitModels;
    private final StatisticsScreen statisticsView;
    private final Mediator mediator;

    public StatisticsController(List<User> userModels, List<Outfit> outfitModels,
                                StatisticsScreen statisticsView, Mediator mediator) {
        this.userModels = userModels;
        this.outfitModels = outfitModels;
        this.statisticsView = statisticsView;
        this.mediator = mediator;

        this.setJListContents();
    }

    public void showView() {
        statisticsView.showScreen();
    }

    public void closeView() {
        statisticsView.closeScreen();
    }

    private void setJListContents() {
        this.statisticsView.setMostFollowedUsersList(getMostFollowedUsers(userModels));
        this.statisticsView.setMostLikedOutfitsList(getMostLikedOutfit(outfitModels));
        this.statisticsView.setMostDislikedOutfitsLists(getMostDislikedOutfit(outfitModels));

        this.statisticsView.setBackButtonListener(new BackListener());
    }

    private Object[] getMostFollowedUsers(List<User> users) {
        User mostFollowedUser = users.stream()
                .max(Comparator.comparing(v -> v.getFollowerUsers().size())).orElse(null);

        return users.stream()
                .filter(v -> v.getFollowerUsers().size() == mostFollowedUser.getFollowerUsers().size()).toArray();
    }

    private Object[] getMostLikedOutfit(List<Outfit> outfits) {
        Outfit mostLikedOutfit = outfits.stream()
                .max(Comparator.comparing(Outfit::getNumberOfLikes)).orElse(null);

        return outfits.stream()
                .filter(v -> v.getNumberOfLikes() == mostLikedOutfit.getNumberOfLikes())
                .toArray();
    }

    private Object[] getMostDislikedOutfit(List<Outfit> outfits) {
        Outfit mostDislikedOutfit = outfits.stream()
                .max(Comparator.comparing(Outfit::getNumberOfDislikes)).orElse(null);

        return outfits.stream()
                .filter(v -> v.getNumberOfDislikes() == mostDislikedOutfit.getNumberOfDislikes())
                .toArray();
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToMainScreen();
        }
    }
}
