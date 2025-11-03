package org.practice.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Br {
    private static int N, M;
    public static void practice() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        List<List<Integer>> input = new ArrayList<>();
        while (N-->0){
            List<Integer> line = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i = M; i > 0; i--){
                int number = Integer.parseInt(st2.nextToken());
                line.add(number);
            }
            input.add(line);
        }
    }
}
