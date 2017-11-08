package item2.builder_pattern;

public class NutritionFacts {
    private final int servingSize; //required
    private final int servings;//required
    private final int calories;//optional
    private final int fat;//optional
    private final int sodium;//optional
    private final int carbonhydrate;//optional

    public static class Builder{
        //Required Parameters
        private final int servingSize;
        private final int servings;

        //Optional Parameters
        private  int calories = 0;//optional
        private  int fat = 0;//optional
        private  int sodium = 0;//optional
        private  int carbonhydrate = 0;//optional

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int fat){
            calories = fat;
            return this;
        }

        public Builder sodium(int sodium){
            calories = sodium;
            return this;
        }

        public Builder carbonhydrate(int carbonhydrate){
            calories = carbonhydrate;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }

    }

    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbonhydrate = builder.carbonhydrate;
    }
}
