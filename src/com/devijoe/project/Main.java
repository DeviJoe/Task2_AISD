package com.devijoe.project;

import java.util.LinkedList;

/**
 * СПЕЦЗАДАНИЕ: разработать простой список
 */

public class Main {

    public static void main(String[] args) {
        // write your code here
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.clear();
        System.out.print(list.get(1));
    }
}
