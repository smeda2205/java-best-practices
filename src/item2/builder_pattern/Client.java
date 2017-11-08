package item2.builder_pattern;

public class Client {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(200,20)
                .calories(100).sodium(34).carbonhydrate(27).build();
    }
}
