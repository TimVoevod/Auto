package com.company;

public class Task2_2 {

    public static void main(String[] args) {
        int[] mas = {3, 6, 8, -3, 1, 9};
        int mult = mas[0];
        int i = 1;
        while (i <= mas.length-1) {
            mult *= mas[i];
            i++;
        }
        System.out.println(mult);
    }
}
