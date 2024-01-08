package com.dekapx.java.streams;

import com.dekapx.java.model.Dish;
import com.dekapx.java.model.DishType;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CaloriesDemo {
    private static Predicate<Dish> lowCaloriePredicate =
            dish -> dish.calories() < 400;

    private static BiPredicate<Dish, Integer> highCalorieBiPredicate = (dish, calorie) ->
            dish.calories() > calorie;


    public static void main(String[] args) {
        List<Dish> dishes = dishSupplier.get();

//        displayLowCalorieDishes(dishes);
        displayHighCalorieDishes(dishes);
    }

    private static void displayLowCalorieDishes(List<Dish> dishes) {
        List<String> lowCalorieDishes = dishes
                .stream()
                .filter(lowCaloriePredicate)
                .map(Dish::name)
                .sorted()
                .toList();
        lowCalorieDishes.forEach(System.out::println);
    }

    private static void displayHighCalorieDishes(List<Dish> dishes) {
        List<String> lowCalorieDishes = dishes
                .stream()
                .filter(dish -> highCalorieBiPredicate.test(dish, 300))
                .map(Dish::name)
                .limit(3)
                .sorted()
                .toList();
        lowCalorieDishes.forEach(System.out::println);
    }

    private static Supplier<List<Dish>> dishSupplier = () ->
         List.of(
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
