package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coaches {
    private List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명에서 최대 5명 사이여야 합니다.");
        }
    }

    public Map<Coach, List<String>> recommend(List<Category> categories) {
        Map<Coach, List<String>> result = new HashMap<>();
        for (Category category : categories) {
            List<String> weeklyCategory = category.getFoods();

            // 카테고리별 각 코치마다 음식 뽑아내야함.
            for (Coach coach : coaches) {
                String menu = pickMenu(weeklyCategory);
                coach.add(menu);
            }

            // 메뉴 뽑아서 반환값 만들기
            List<String> menus = new ArrayList<>();
            for (Coach coach : coaches) {
                result.put(coach, coach.getMenus());
            }
        }

        return result;
    }

    private String pickMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
