package com.company;

public class Task2_4 {

    public static void main(String[] args) {
        int[] mas = {3, 6, 8, -3, 0, 9};
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 0) {
                count++;
            }
        }
        System.out.println(count > 0 ? "The amount of null elements in the array: " + count : "Array doesn't contain null elements.");
    }
}