package com.company;

public class Task2_6 {

    public static void main(String[] args) {
        int[] mas = {3, 6, 8, -3, 0, 9};
        int temp = 0;
        for (int i = 0; i < mas.length - 1; i++) {
            temp = mas[i];
            mas[i] = mas[i + 1];
            mas[i + 1] = temp;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }
    }
}