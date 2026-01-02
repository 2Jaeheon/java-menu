package menu.controller;

import static menu.util.Parser.parseFoods;
import static menu.util.Parser.parseNames;

import java.util.ArrayList;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.CategoryRecommender;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final CategoryRecommender recommender;

    public Controller(InputView inputView, OutputView outputView, CategoryRecommender recommender) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.recommender = recommender;
    }

    public void run() {
        outputView.printHelloMessage();
        List<String> names = readValidCoachNames();
        Coaches coaches = readValidCoach(names);

        List<Category> categories = recommender.recommend();
        Map<Coach, List<String>> recommendedMenus = coaches.recommend(categories);
        outputView.printRecommendation(recommendedMenus, categories);

    }

    private Coaches readValidCoach(List<String> names) {
        List<Coach> coaches = new ArrayList<>();

        for (String name : names) {
            Coach coach = getCoach(name);
            coaches.add(coach);
        }

        return new Coaches(coaches);
    }

    private Coach getCoach(String name) {
        while (true) {
            try {
                outputView.printHateFoodsInputMessage(name);
                List<String> hateFoods = parseFoods(inputView.readFoods());
                return new Coach(name, hateFoods);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<String> readValidCoachNames() {
        while (true) {
            try {
                outputView.printCoachNamesInput();
                return parseNames(inputView.readCoaches());
            } catch (IllformedLocaleException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
