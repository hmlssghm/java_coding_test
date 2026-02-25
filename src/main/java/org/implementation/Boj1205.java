package org.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> info = getInfo(br);
        List<Integer> leaderBoard = new ArrayList<>();

        if (info.get("n") != 0) leaderBoard = getLeaderBoard(br);

        int rank = getTaesooRank(info, leaderBoard);
        System.out.println(rank);
    }

    static Map<String, Integer> getInfo(BufferedReader br) throws IOException {
        // first line - "N 태수의 점수 P"
        // N: 리스트에 있는 점수 개수 (0 <= N <= P)
        // P: 랭킹 리스트에 올라 갈 수 있는 점수의 개수 (10 <= P)
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int taesoo = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Map<String, Integer> info = new HashMap<>();
        info.put("n", n);
        info.put("taesoo", taesoo);
        info.put("p", p);

        return info;
    }

    static List<Integer> getLeaderBoard(BufferedReader br) throws IOException {
        // second line - 현재 랭킹 리스트 (정렬x)
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> leaderBoard = new ArrayList<>();
        while (st.hasMoreTokens()) {
            leaderBoard.add(Integer.parseInt(st.nextToken()));
        }

        leaderBoard.sort(Collections.reverseOrder());

        return leaderBoard;
    }

    private static int getTaesooRank(Map<String, Integer> info, List<Integer> leaderBoard) {
        // 태수는 몇등? (비랭킹권이면 -1 출력)
        // 같은 등수면 낮은 등수

        int n = info.get("n");
        int taesoo = info.get("taesoo");
        int p = info.get("p");

        if (n == 0) return 1;
        if (n == p && taesoo <= leaderBoard.get(leaderBoard.size() - 1)) return -1;
        // 위에 n == p 조건 안넣어서, 이게 실전이었다면 틀렸을 것..
        // 리더보드가 무조건 꽉차있는게 아니기 때문에!
        // 사소 조건 놓치지 말것!

        leaderBoard.add(taesoo);
        leaderBoard.sort(Collections.reverseOrder());

        int firstIdx = leaderBoard.indexOf(taesoo);
        int LastIdx = leaderBoard.lastIndexOf(taesoo);
        if (p <= LastIdx) return -1;
        else return firstIdx + 1;
    }
}
