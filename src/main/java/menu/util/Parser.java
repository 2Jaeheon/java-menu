package menu.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parser {
    public static List<String> parseNames(String raw) {
        List<String> names = new ArrayList<>();

        String[] split = raw.split(",");
        if (split.length < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }

        for (String name : split) {
            String trimmedName = name.trim();
            if (trimmedName.length() < 2 || trimmedName.length() > 4) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최소 4글자 입니다.");
            }
            names.add(trimmedName);
        }

        Set<String> namesSet = new HashSet<>(names);
        if (namesSet.size() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 중복될 수 없습니다.");
        }

        return names;
    }

    public static List<String> parseFoods(String raw) {
        List<String> foods = new ArrayList<>();
        String[] split = raw.split(",");

        for (String food : split) {
            String trimmedFood = food.trim();
            foods.add(trimmedFood);
        }
        return foods;
    }
}
