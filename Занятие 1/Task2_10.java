package com.company;

public class Task2_10 {

    public static void main(String[] args) {
        int[] mas = {0, 1, 2, 3, 4, 5};
        boolean b = true;
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] <= mas[i-1]) {
                b = false;
                break;
            }
        }
        System.out.println(b);

    }
}
