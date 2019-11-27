package com.company;

public class Task2_12 {

    public static void main(String[] args) {
        int[] mas = {3, 6, 8, -3, 0, 9};
        int temp = mas[0];
        int temp1 = mas[1];
        int a = mas[mas.length-1];
        int b = mas[mas.length-2];
        for (int i = 0; i < mas.length-2; i++) {
            int temp2 = mas[i+2];
            mas[i+2] = temp;
            temp = temp1;
            temp1 = temp2;
        }
        mas[0] = b;
        mas[1] = a;

        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }
    }
}
