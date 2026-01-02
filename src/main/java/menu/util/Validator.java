package menu.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.domain.Category;

public class Validator {
    public void validateNames(List<String> coachNames) {
        for (String eachName : coachNames) {
            if (eachName.length() < 2 || eachName.length() > 4) {
                throw new IllegalArgumentException("[ERROR] 코치 이름은 2글자에서 4글자 사이여야 합니다.");
            }
        }

        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명에서 최대 5명까지 식사를 함께 해야 합니다.");
        }

        Set<String> coaches = new HashSet<>(coachNames);
        if (coaches.size() != coachNames.size()) {
            throw new IllegalArgumentException("[ERORR] 코치의 이름은 중복될 수 없습니다.");
        }
    }

    public void validateFoods(List<String> foods) {
        for (String food : foods) {
            // 빈 값은 제외
            if (food.trim().isEmpty()) {
                continue;
            }

            if (!Category.hasMenu(food)) {
                throw new IllegalArgumentException("[ERROR] 메뉴 목록에 존재하지 않는 음식입니다.");
            }
        }
    }

}
