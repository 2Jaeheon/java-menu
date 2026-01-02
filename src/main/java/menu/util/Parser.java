package menu.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<String> parseCoachName(String raw) {
        List<String> names = new ArrayList<>();
        String[] split = raw.split(",");

        for (String name : split) {
            String trimmedName = name.trim();
            names.add(trimmedName);
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
