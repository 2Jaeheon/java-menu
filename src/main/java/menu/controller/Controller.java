package menu.controller;

import static menu.util.Parser.parseCoachName;
import static menu.util.Parser.parseFoods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.CategoryRecommender;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.util.Validator;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final CategoryRecommender categoryRecommender;

    public Controller(InputView inputView, OutputView outputView, Validator validator,
                      CategoryRecommender categoryRecommender) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.categoryRecommender = categoryRecommender;
    }

    public void run() {
        // 초반 메시지
        outputView.printStartMessage();
        List<String> names = readValidCoachNames();
        Coaches coaches = readValidCoaches(names);

        List<Category> categories = categoryRecommender.recommend();
        Map<String, List<String>> recommend = coaches.recommend(categories);

        outputView.printResult(categories, recommend);
    }

    private Coaches readValidCoaches(List<String> names) {
        try {
            List<Coach> coaches = new ArrayList<>();
            for (String name : names) {
                readValidNotEatFoods(name, coaches);
            }
            return new Coaches(coaches);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }

        return null;
    }

    private void readValidNotEatFoods(String name, List<Coach> coaches) {
        while (true) {
            try {
                outputView.printNotEachFoodsInput(name);
                List<String> foods = parseFoods(inputView.readNotEachFoods());
                validator.validateFoods(foods);
                Coach coach = new Coach(name, foods);
                coaches.add(coach);
                outputView.printEmptyLine();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<String> readValidCoachNames() {
        while (true) {
            try {
                outputView.printCoachInputMessage();
                List<String> names = parseCoachName(inputView.readCoachNames());
                validator.validateNames(names);
                return names;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
