package org.implementation;

import org.example.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Boj1157 {
    private static void solution() throws IOException {
        List<Integer> input = inputView();

        List<Integer> upperList = makeUpperCase(input);
        Set<Integer> members = findMember(upperList);
        Map<Integer, Integer> countList = count(upperList, members);

        int maxChar = findChar(countList);
        char answer = makeEng(maxChar);
        System.out.println(answer);
    }

    private static List<Integer> makeUpperCase(List<Integer> input) {
        List<Integer> upperList = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            int num = input.get(i);
            if (97 <= num) {
                upperList.add(num - 32);
            } else {
                upperList.add(num);
            }
        }

        return upperList;
    }

    private static Set<Integer> findMember(List<Integer> upperList) {
        Set<Integer> members = new HashSet<>(upperList);
        return members;
    }

    private static Map<Integer, Integer> count(List<Integer> upperList, Set<Integer> members) {
        Map<Integer, Integer> countList = new HashMap<>();

        for (int member : members) {
            long count = upperList.stream()
                    .filter(n -> n == member)
                    .count();

            countList.put(member, (int) count);
        }
        return countList;
    }

    private static int findChar(Map<Integer, Integer> count) {
        int maxValue = Collections.max(count.values());

        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue() == maxValue){
                answer.add(entry.getKey());
            }
        }

        if (1 < answer.size()) return -1;
        else return answer.get(0);
    }

    private static char makeEng(int num) {
        if (num == -1) return '?';
        else return (char) num;
    }

    private static List<Integer> inputView() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        List<Integer> input = new ArrayList<>();
        for (char c : word.toCharArray()) {
            input.add((int) c);
        }

        return input;
    }
//    public static void main(String[] args) throws Exception {
//        Main.solution();
//    }
}
