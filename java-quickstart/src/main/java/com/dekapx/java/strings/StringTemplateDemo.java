package com.dekapx.java.strings;

public class StringTemplateDemo {

    private class HelloWorld {
        static String sayHello(String arg) {
            return STR."Hello ! \{arg}";
        }
    }
    public static void main(String[] args) {
        System.out.println(HelloWorld.sayHello("Java"));
    }
}
