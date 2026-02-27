package org.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("/Users/gracek/IdeaProjects/java_coding_test/src/main/java/org/input.txt"));

        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> lampSpot = new ArrayList<>();
        while(st.hasMoreTokens()) {
            lampSpot.add(Integer.parseInt(st.nextToken()));
        }

        // 1번 구역, 마지막구역 길이 구하기
        List<Integer> intervals = new ArrayList<>();
        intervals.add(lampSpot.get(0)); // 1번 구역
        intervals.add(N - lampSpot.get(lampSpot.size() - 1)); // 마지막 구역

        // 사이 구역 길이 구하기
        if (M > 1) {
            for (int i = 0; i < (lampSpot.size() - 1); i++) {
                int interval = lampSpot.get(i + 1) - lampSpot.get(i);
                // +1은 홀수일때만 하는 디태일 !! 실전이었으면 1솔 날라감..
                if (interval % 2 == 0) intervals.add(interval/2);
                if (interval % 2 != 0) intervals.add(interval/2 + 1);
            }
        }

        // 최대 길이 구하기
        int max = Collections.max(intervals);

        System.out.println(max);
    }
}
