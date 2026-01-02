package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CategoryRecommender {
    private static final int DAYS = 5;

    public List<Category> recommend() {
        List<Category> categories = new ArrayList<>();

        // 카테고리 리스트가 5가 될 때까지 반복
        while (categories.size() < DAYS) {
            Category category = pickCategory();

            // 두개 미만일 때
            if (isSatisfiedCount(categories, category)) {
                categories.add(category);
            }
        }
        return categories;
    }

    private Category pickCategory() {
        return Category.from(Randoms.pickNumberInRange(1, 5));
    }

    private boolean isSatisfiedCount(List<Category> categories, Category targetCategory) {
        int count = 0;
        for (Category existingCategory : categories) {
            if (existingCategory == targetCategory) {
                count++;
            }
        }

        return count < 2;
    }
}