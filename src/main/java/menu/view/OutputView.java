package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.Category;

public class OutputView {
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public void printCoachInputMessage() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printNotEachFoodsInput(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printResult(List<Category> categories, Map<String, List<String>> result) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        printCategories(categories);

        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
            System.out.printf("[ %s | %s ]%n",
                    entry.getKey(),
                    String.join(" | ", entry.getValue())
            );
        }
        System.out.println("\n추천을 완료했습니다.");
    }

    private void printCategories(List<Category> categories) {
        List<String> menus = new ArrayList<>();
        for (Category category : categories) {
            menus.add(category.getName());
        }

        System.out.printf("[ 카테고리 | %s ]%n", String.join(" | ", menus));
    }
}
