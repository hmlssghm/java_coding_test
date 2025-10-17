package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public void solution() throws IOException {
        int[] input = InputView.read();

        // 입력
        int h = input[0];
        int w = input[1];
        int verticalLen = input[2] + 1;
        int horizontalLen = input[3] + 1;

        // 가로 세로 별 앉을 수 있는 학생 최대값
        int verticalMax = h / verticalLen + ((h % verticalLen != 0) ? 1 : 0);
        int horizontalMax = w / horizontalLen + (((w % horizontalLen) != 0) ? 1 : 0);

        int answer = verticalMax * horizontalMax;
        System.out.println(answer);
    }

    private class InputView {
        private static final String SEPARATOR = " ";

        private static int[] read() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Arrays.stream(br.readLine().split(SEPARATOR)).mapToInt(Integer::parseInt).toArray();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}