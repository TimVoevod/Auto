package com.company;

public class Task2_8 {

    public static void main(String[] args) {
        int[] mas = {-10, 6, 8, -3, 0, 9};
        int min = mas[0];
        int max = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] > max) {
                max = mas[i];
            }
            if (mas[i] < min) {
                min = mas[i];
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

    }
}
