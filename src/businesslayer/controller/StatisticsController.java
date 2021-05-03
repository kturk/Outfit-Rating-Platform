package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import presentationlayer.StatisticsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsController {

    private List<User> userModels;
    private List<Outfit> outfitModels;
    private StatisticsScreen statisticsView;
    private Mediator mediator;

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

//        System.out.println(Arrays.toString(mostFollowedUsers));
//        List<User> mostFollowedUsers = users.stream()
//                .filter(v -> v.getFollowerUsers().size() == mostFollowedUser.getFollowerUsers().size())
//                .collect(Collectors.toList());
//
//        return mostFollowedUsers.toArray();
    }

    private Object[] getMostLikedOutfit(List<Outfit> outfits) {
        Outfit mostLikedOutfit = outfits.stream()
                .max(Comparator.comparing(Outfit::getNumberOfLikes)).orElse(null);

        return outfits.stream()
                .filter(v -> v.getNumberOfLikes() == mostLikedOutfit.getNumberOfLikes())
                .map(Outfit::getBrandName)
                .toArray();
    }

    private Object[] getMostDislikedOutfit(List<Outfit> outfits) {
        Outfit mostDislikedOutfit = outfits.stream()
                .max(Comparator.comparing(Outfit::getNumberOfDislikes)).orElse(null);

        return outfits.stream()
                .filter(v -> v.getNumberOfDislikes() == mostDislikedOutfit.getNumberOfDislikes())
                .map(Outfit::getBrandName)
                .toArray();
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            statisticsView.closeScreen();
            mediator.navigateToMainScreen();
        }
    }
}
