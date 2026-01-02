package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateFoods;
    private final List<String> weeklyMenus = new ArrayList<>();

    public Coach(String name, List<String> hateFoods) {
        this.name = name;
        this.hateFoods = hateFoods;
    }

    public void addMenu(Category category) {
        // 카테고리에서 음식 리스트를 뽑아옴
        List<String> foods = category.getFoods();

        while (true) {
            // 랜덩으로 음식 하나 선택
            String food = Randoms.shuffle(foods).get(0);

            // 음식 사용 가능?
            if (isSafeToEat(food)) {
                weeklyMenus.add(food);
                return;
            }
        }
    }

    // 먹을 수 있는 것인지 확인
    private boolean isSafeToEat(String food) {
        // 싫어하는 음식에 포함?
        if (hateFoods.contains(food)) {
            return false;
        }

        // 이번주 점심 메뉴에 포함?
        if (weeklyMenus.contains(food)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<String> getWeeklyMenus() {
        return new ArrayList<>(weeklyMenus);
    }
}