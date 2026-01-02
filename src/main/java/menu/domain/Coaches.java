package menu.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }


    public Map<String, List<String>> recommend(List<Category> weeklyCategories) {
        // 각 카테고리마다 한 명씩 메뉴를 추가
        for (Category category : weeklyCategories) {
            for (Coach coach : coaches) {
                // 한 명의 코치에 대해서 처리
                coach.addMenu(category);
            }
        }

        return extractMenusDTO();
    }

    private Map<String, List<String>> extractMenusDTO() {
        Map<String, List<String>> result = new LinkedHashMap<>();

        for (Coach coach : coaches) {
            // 각 코치마다 이름과 위클리 메뉴 리스트를 뽑아옴
            result.put(coach.getName(), coach.getWeeklyMenus());
        }

        return result;
    }
}