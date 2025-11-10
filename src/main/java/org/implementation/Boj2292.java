package org.implementation;

import java.util.Scanner;

public class Boj2292 {
    private static void solution() {
        int n = Boj2292.inputView();
        int remain = Boj2292.findRemain(n);
        int group = Boj2292.group(remain);
        Boj2292.OutputView(group + 1);
    }

    private static int findRemain(int n) {
        if (n == 1) return -1;
        return (n - 2) / 6;
    }

    private static int group(int remain) {
        // n = 1일 때 예외 처리
        if (remain == -1) {
            return 0;
        }

        int start = 0;
        int gap = 1;
        while(true) {
            int end = start + gap;
            if (start <= remain && remain < end) {
                return gap;
            }
            start = end;
            gap = gap + 1;
            // TODO: 반복문 못빠져나감 에러 주의
        }
    }

    private static int inputView() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        return n;
    }

    private static void OutputView(int step) {
        System.out.println(step);
    }

//    public static void main(String[] args) throws Exception {
//        new Main().solution();
//    }
}
