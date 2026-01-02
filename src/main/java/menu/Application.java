package menu;

import menu.controller.Controller;
import menu.domain.CategoryRecommender;
import menu.util.Validator;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        CategoryRecommender categoryRecommender = new CategoryRecommender();

        Controller controller = new Controller(inputView, outputView, categoryRecommender);
        controller.run();
    }
}
