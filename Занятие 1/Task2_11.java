package com.company;

// у первого и последнего нету двух соседних элементов, поэтому их я оставил прежними
public class Task2_11 {

    public static void main(String[] args) {
        double[] mas = {3, 6, 8, -3, 0, 9};
        double temp = mas[0];
        for (int i = 1; i < mas.length-1; i++) {
            double temp1 = mas[i];
            mas[i] = (temp + mas[i+1])/2;
            temp = temp1;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }
    }
}