package item2.telescoping_constructor_pattern;

public class NutritionFacts {
    private final int servingSize; //required
    private final int servings;//required
    private final int calories;//optional
    private final int fat;//optional
    private final int sodium;//optional
    private final int carbonhydrate;//optional


    public NutritionFacts(int servingSize, int servings){
        this(servingSize,servings,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories){
        this(servingSize,servings,calories,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat){
        this(servingSize,servings,calories,fat,0);
    }

    public NutritionFacts( int servingSize, int servings, int calories, int fat, int sodium){
        this(servingSize,servings,calories,fat,sodium,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbonhydrate){
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbonhydrate = carbonhydrate;
    }

}
