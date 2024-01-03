package com.dekapx.java.streams;

import com.dekapx.java.model.Dish;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CaloriesDemo {
    private static Predicate<Dish> lowCaloriePredicate =
            dish -> dish.calorie() < 400;

    private static BiPredicate<Dish, Integer> lowCalorieBiPredicate = (dish, calorie) ->
            dish.calorie() < calorie;


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
                new Dish("Pizza", 750),
                new Dish("Burger", 750),
                new Dish("Sandwich", 350),
                new Dish("Ice Cream", 200));
    }
}
