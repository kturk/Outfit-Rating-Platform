package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import presentationlayer.StatisticsScreen;

import java.util.List;

public class StatisticsController {

    private List<User> userModels;
    private List<Outfit> outfitModels;
    private User userModel;
    private StatisticsScreen statisticsView;
    private Mediator mediator;

    public StatisticsController(List<User> userModels, List<Outfit> outfitModels, User userModel, Mediator mediator) {
        this.userModels = userModels;
        this.outfitModels = outfitModels;
        this.userModel = userModel;
        this.statisticsView = new StatisticsScreen(userModels, outfitModels, userModel);
        this.mediator = mediator;
    }

    public void showView() {
        statisticsView.showScreen();
    }

    public void closeView() {
        statisticsView.closeScreen();
    }
}
