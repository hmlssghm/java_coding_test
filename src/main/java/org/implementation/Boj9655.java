package org.implementation;

import java.util.Scanner;
public class Boj9655 {
    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = (n / 3) + (n % 3);
        if (count % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

//    public static void main(String[] args) {
//        solution();
//    }
}
