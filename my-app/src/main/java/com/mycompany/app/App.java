package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        var x = new Grid(12);
        System.out.println("Start MAZE");
        System.out.println(x);
        x.binary_tree_maze();
        System.out.println(x);
    }
}
