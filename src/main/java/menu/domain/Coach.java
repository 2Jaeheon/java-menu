package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateFoods;
    private final List<String> recommendedMenus;

    public Coach(String name, List<String> hateFoods) {
        validate(hateFoods);
        this.name = name;
        this.hateFoods = hateFoods;
        recommendedMenus = new ArrayList<>();
    }

    private void validate(List<String> hateFoods) {
        for (String food : hateFoods) {
            if (food.trim().isEmpty()) {
                continue;
            }

            if (!Category.contains(food)) {
                throw new IllegalArgumentException("[ERROR] 싫어하는 음식이 리스트에 존재하지 않습니다.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getHateFoods() {
        return hateFoods;
    }

    public void add(String menu) {
        if (isValid(menu)) {
            recommendedMenus.add(menu);
        }
    }

    private boolean isValid(String menu) {
        if (hateFoods.contains(menu)) {
            return false;
        }
        if (recommendedMenus.contains(menu)) {
            return false;
        }

        return true;
    }

    public List<String> getMenus() {
        return List.copyOf(recommendedMenus);
    }
}
