package com.company;

public class Task2_1 {

    public static void main(String[] args) {
        int[] mas = {3, 6, 8, -3, 0, 9};
        int i = 0;
        while (i <= mas.length-1) {
            System.out.println(mas[i]);
            i++;
        }

        i = mas.length-1;
        while (i >= 0) {
            System.out.println(mas[i]);
            i--;
        }

    }
}
