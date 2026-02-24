package org.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj25757 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int participants = 0;

        if (game.equals("Y")) participants = 1;
        else if (game.equals("F")) participants = 2;
        else if (game.equals("O")) participants = 3;
        else System.out.println("게임 인풋 에러");

        Set<String> name = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            name.add(br.readLine());
        }
        int totalPeople = name.size();
        int answer = totalPeople / participants;

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}