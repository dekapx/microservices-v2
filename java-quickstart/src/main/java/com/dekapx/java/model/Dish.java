package com.dekapx.java.model;

public record Dish(String name,
                   boolean vegetarian,
                   int calories,
                   DishType dishType) {
}
