package com.dekapx.java.basics;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
class Dummy {
    private String var;
}

public class Test {
    public static void main(String[] args) {
        List<Dummy> dummies = buildData();
        dummies.forEach(dummy -> dummy.setVar("MODIFIED"));
        dummies.forEach(System.out::println);
    }


    private static List<Dummy> buildData() {
      return List.of(
              Dummy.builder().var("Hello").build(),
              Dummy.builder().var("World").build()
      );
    };
}
