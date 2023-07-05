package com.lsl.AbstractDemo;

public class Test {
    public static void main(String[] args) {
        new cat().call();
        new dog().call();
        new Animal() {
            @Override
            public void call() {
                System.out.println(111);
            }
        }.call();
    }
}
