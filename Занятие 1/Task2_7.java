package com.company;

public class Task2_7 {

    public static void main(String[] args) {
        int[] mas = {3, 6, 8, -3, 0, 9};
        int temp = 0;
        for (int i = 0; i < mas.length/2; i++) {
            temp = mas[i];
            mas[i] = mas[mas.length - 1 - i];
            mas[mas.length - 1 - i] = temp;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }

    }
}
