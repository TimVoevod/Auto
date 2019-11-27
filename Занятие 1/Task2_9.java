package com.company;

public class Task2_9 {

    public static void main(String[] args) {
        int[] mas = {-10, 6, 8, -3, 0, 9};
        int min = mas[0];
        int max = mas[0];
        int maxIndex = 1;
        int minIndex = 1;
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] > max) {
                max = mas[i];
                maxIndex = i + 1;
            }
            if (mas[i] < min) {
                min = mas[i];
                minIndex = i + 1;
            }
        }
        System.out.println("Index of min: " + minIndex);
        System.out.println("Index of max: " + maxIndex);

    }
}
