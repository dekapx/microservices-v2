package com.dekapx.java.lambda;


@FunctionalInterface
interface HelloWorld {
    String sayHello(String arg);
}

public class LambdaDemo {
    public static void main(String[] args) {
        HelloWorld helloWorld = (arg) -> "Hello " + arg;
        System.out.println(helloWorld.sayHello("DeKapx"));
    }
}
