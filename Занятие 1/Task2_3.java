package com.company;

public class Task2_3 {

    public static void main(String[] args) {
        int[] mas = {3, 6, 8, -3, 1, 9};
        for (int i = 2; i < mas.length; i = i + 3) {
            mas[i] *= 2;
        }
        System.out.println("Example 1:");
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }

        for (int i = 0; i < mas.length; i++) {
            if ((i + 1) % 3 == 0) {
                mas[i] *= 2;
            }
        }
        System.out.println("Example 2:");
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }
    }
}