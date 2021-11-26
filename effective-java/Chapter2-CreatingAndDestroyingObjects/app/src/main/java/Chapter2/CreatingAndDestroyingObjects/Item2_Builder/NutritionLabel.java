package Chapter2.CreatingAndDestroyingObjects.Item2_Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NutritionLabel {
    private int calories;
    private Integer servings;
    private Integer carbs;
    private Integer fats;

    public class Pair<A, B> {
        A a;
        B b;

        public A getA() {
            return this.a;
        }

        public void setA(A a) {
            this.a = a;
        }

        public B getB() {
            return this.b;
        }

        public void setB(B b) {
            this.b = b;
        }

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

    }

    public static class Builder {
        private int calories;
        private Integer servings;
        private Integer carbs;
        private Integer fats;

        public Builder(int calories) {
            this.calories = calories;
        }

        public Builder servings(int servings) {
            this.servings = servings;
            return this;
        }

        public Builder carbs(int carbs) {
            this.carbs = carbs;
            return this;
        }

        public Builder fats(int fats) {
            this.fats = fats;
            return this;
        }

        public NutritionLabel build() {
            return new NutritionLabel(this);
        }
    }

    private NutritionLabel(Builder b) {
        this.calories = b.calories;
        this.servings = b.servings;
        this.carbs = b.carbs;
        this.fats = b.fats;
    }

    public String getLabel() {
        Pair<String, Integer> p1 = new Pair<String, Integer>("Calories", this.calories);
        Pair<String, Integer> p2 = new Pair<String, Integer>("Servings", this.servings);
        Pair<String, Integer> p3 = new Pair<String, Integer>("Carbs", this.carbs);
        Pair<String, Integer> p4 = new Pair<String, Integer>("Fats", this.fats);
        List<Pair<String, Integer>> lines = new ArrayList<Pair<String, Integer>>();
        lines.add(p1);
        lines.add(p2);
        lines.add(p3);
        lines.add(p4);
        String label = lines.stream().filter(l -> {
            return l.getB() != null;
        }).map(l -> {
            return String.format("%s: %d", l.getA(), l.getB());
        }).collect(Collectors.joining("\n"));
        return label;
    }
}
