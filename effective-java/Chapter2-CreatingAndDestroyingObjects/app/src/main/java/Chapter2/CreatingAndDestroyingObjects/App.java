/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Chapter2.CreatingAndDestroyingObjects;

import Chapter2.CreatingAndDestroyingObjects.Item2_Builder.NutritionLabel;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Creating and Destroying Objects!");

        System.out.println("---------------------------------------");

        NutritionLabel n = new NutritionLabel.Builder(1000).build();
        System.out.println(n.getLabel());

        System.out.println("---------------------------------------");

        NutritionLabel n2 = new NutritionLabel.Builder(1000).carbs(21).fats(9).build();
        System.out.println(n2.getLabel());

        System.out.println("---------------------------------------");
    }
}
