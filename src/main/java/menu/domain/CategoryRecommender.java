package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CategoryRecommender {
    public List<Category> recommend() {
        List<Category> categories = new ArrayList<>();

        while (categories.size() < 5) {
            Category category = Category.of(Randoms.pickNumberInRange(1, 5));

            if (isValidCategory(categories, category)) {
                categories.add(category);
            }
        }

        return categories;
    }

    private boolean isValidCategory(List<Category> categories, Category category) {
        int count = 0;
        for (Category eachCategory : categories) {
            if (eachCategory == category) {
                count++;
            }
        }

        return count <= 2;
    }
}
