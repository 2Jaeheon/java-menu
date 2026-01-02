package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;

public class OutputView {
    public void printHelloMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printHateFoodsInputMessage(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printRecommendation(Map<Coach, List<String>> recommendedMenus, List<Category> categories) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(categories);

        for (Map.Entry<Coach, List<String>> entry : recommendedMenus.entrySet()) {
            Coach coach = entry.getKey();
            List<String> menus = entry.getValue();
            String joinedMenus = String.join(" | ", menus);

            System.out.println("[ " + coach.getName() + " | " + joinedMenus + " ]");
        }
    }

    private void printCategory(List<Category> categories) {
        String categoryMessage = "[ 카테고리 | ";
        List<String> foodCategories = new ArrayList<>();
        for (Category category : categories) {
            foodCategories.add(category.getName());
        }

        String joinedCategory = String.join(" | ", foodCategories);
        System.out.println(categoryMessage + joinedCategory + " ]");
        System.out.println("추천을 완료했습니다.");
    }

    public void printCoachNamesInput() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }
}
