package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("/Users/gracek/IdeaProjects/java_coding_test/src/main/java/org/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 리더보드 등수 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> leaderBoard = new ArrayList<>();
            while (st.hasMoreTokens()) {
                leaderBoard.add(Integer.parseInt(st.nextToken()));
            }

            Set<Integer> teams = new HashSet<>(leaderBoard);
            List<Integer> validTeams = new ArrayList<>();
            // 6인 참가 팀 판별
            for (int team: teams) {
                int count = (int) leaderBoard.stream().filter(x -> x == team).count();
                if (count == 6) {
                    validTeams.add(team);
                }
            }

            // 리더보드 유효하지 않은 팀 삭제
            Iterator<Integer> it = leaderBoard.iterator();
            while(it.hasNext()) {
                if(!validTeams.contains(it.next())) it.remove();
            }

            // 팀별 점수 합산
            List<List<Integer>> allScore = new ArrayList<>();
            Map<Integer, Integer> fifthOfTeam = new HashMap<>();
            for (int t: validTeams) {
                int count = 0;
                int score = 0;
                for (int i = 0; i < leaderBoard.size(); i++) {
                    if (leaderBoard.get(i) == t && count == 4) {
                        fifthOfTeam.put(t, i + 1);
                        break;
                    }
                    if (leaderBoard.get(i) == t && count < 4) {
                        score += (i + 1);
                        count++;
                    }
                }
                allScore.add(Arrays.asList(t, score));
            }

            // 최소 점수 판별
            int minScore = Integer.MAX_VALUE;
            for (List<Integer> teamAndScore: allScore) {
                if (teamAndScore.get(1) < minScore) {
                    minScore = teamAndScore.get(1);
                }
            }

            // 최소 점수 가진 팀 개수
            List<Integer> candidates = new ArrayList<>();
            for (List<Integer> teamAndScore: allScore) {
                if (teamAndScore.get(1) == minScore) {
                    candidates.add(teamAndScore.get(0));
                }
            }

            if (candidates.size() >= 2) { // 동률 팀 5등 점수 비교
                int minFifth = Integer.MAX_VALUE;
                for (int c : candidates) {
                    if (fifthOfTeam.get(c) < minFifth) {
                        minFifth = fifthOfTeam.get(c);
                    }
                }

                for (int c : candidates) {
                    if (fifthOfTeam.get(c) == minFifth) {
                        bw.write(String.valueOf(c));
                    }
                }
            } else {
                bw.write(String.valueOf(candidates.get(0)));
            }

            bw.write("\n");
            bw.flush(); // 테스트 케이스 하나 답 출력(한줄)
        }
        //TODO: 마지막 줄바꿈 지워야 하나?
        bw.close();
    }
}