package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import presentationlayer.StatisticsScreen;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsController {

    private List<User> userModels;
    private List<Outfit> outfitModels;
    private StatisticsScreen statisticsView;
    private Mediator mediator;

    public StatisticsController(List<User> userModels, List<Outfit> outfitModels, Mediator mediator) {
        this.userModels = userModels;
        this.outfitModels = outfitModels;
        this.statisticsView = new StatisticsScreen();
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
    }

    private Object[] getMostFollowedUsers(List<User> users) {
        User mostFollowedUser = users.stream()
                .max(Comparator.comparing(v -> v.getFollowerUsers().size())).get();

        List<User> mostFollowedUsers = users.stream()
                .filter(v -> v.getFollowerUsers().size() == mostFollowedUser.getFollowerUsers().size())
                .collect(Collectors.toList());

        return mostFollowedUsers.toArray();
    }

    private Object[] getMostLikedOutfit(List<Outfit> outfits) {
        Outfit mostLikedOutfit = outfits.stream()
                .max(Comparator.comparing(Outfit::getNumberOfLikes)).get();

        List<Outfit> mostLikedOutfits = outfits.stream()
                .filter(v -> v.getNumberOfLikes() == mostLikedOutfit.getNumberOfLikes())
                .collect(Collectors.toList());

        return mostLikedOutfits.toArray();
    }

    private Object[] getMostDislikedOutfit(List<Outfit> outfits) {
        Outfit mostDislikedOutfit = outfits.stream()
                .max(Comparator.comparing(Outfit::getNumberOfDislikes)).get();

        List<Outfit> mostDislikedOutfits = outfits.stream()
                .filter(v -> v.getNumberOfDislikes() == mostDislikedOutfit.getNumberOfDislikes())
                .collect(Collectors.toList());

        return mostDislikedOutfits.toArray();
    }
}
