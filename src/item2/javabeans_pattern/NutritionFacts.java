package item2.javabeans_pattern;

public class NutritionFacts {
    private  int servingSize; //required
    private  int servings;//required
    private  int calories;//optional
    private  int fat;//optional
    private int sodium;//optional
    private int carbonhydrate;//optional


    public NutritionFacts(){

    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbonhydrate(int carbonhydrate) {
        this.carbonhydrate = carbonhydrate;
    }
}
