package com.dekapx.java.streams;

import com.dekapx.java.model.Dish;
import com.dekapx.java.model.DishType;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CaloriesDemo {
    private static Predicate<Dish> lowCaloriePredicate =
            dish -> dish.calories() < 400;

    private static BiPredicate<Dish, Integer> lowCalorieBiPredicate = (dish, calorie) ->
            dish.calories() < calorie;


    public static void main(String[] args) {
        List<Dish> dishes = getDishes();

        List<String> lowCalorieDishes = dishes
                .stream()
                .filter(d -> lowCalorieBiPredicate.test(d, 400))
                .map(Dish::name)
                .sorted()
                .toList();
        lowCalorieDishes.forEach(System.out::println);
    }

    private static List<Dish> getDishes() {
        return List.of(
                new Dish("pork", false, 800, DishType.MEAT),
                new Dish("beef", false, 700, DishType.MEAT),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french fries", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 300, DishType.FISH),
                new Dish("salmon", false, 450, DishType.FISH));
    }
}
