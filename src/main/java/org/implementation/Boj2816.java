package org.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj2816 {
    private static List<Integer> channel = new ArrayList<>();
    private static void solution() throws IOException {
        List<String> rawData = inputView();
        channel = translate(rawData);

        String answer = "";
        for (int i = 2; 0 < i; i--) {;
            answer += switchPosition(i);
        }

        System.out.println(answer);
    }

    private static List<Integer> translate(List<String> data) {
        List<Integer> translated = new ArrayList<>();

        for (String s : data) {
            if(s.equals("KBS1")) {
                translated.add(1);
                continue;
            }
            if (s.equals("KBS2")) {
                translated.add(2);
                continue;
            }
            translated.add(0);
        }

        return translated;
    }

    private static String switchPosition(int target) {
        int idx = channel.indexOf(target);

        String answerPart = "1".repeat(idx) + "4".repeat(idx);
        channel.remove(idx);
        channel.add(0, target);

        return answerPart;
    }

    private static List<String> inputView() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> channel = new ArrayList<>();
        while (N-- > 0) {
            String line = br.readLine();
            channel.add(line);
        }

        return channel;
    }

//    public static void main(String[] args) throws Exception {
//        new Main().solution();
//    }
}
