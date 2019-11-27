package com.company;

public class Task2_5 {

    public static void main(String[] args) {
        int[] mas = {3, 6, 8, -3, 0, 9};
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 0) {
                count++;
                System.out.println(i + 1);
            }
        }
        if (count == 0) {
            System.out.println("Array doesn't contain null elements.");
        }
    }
}