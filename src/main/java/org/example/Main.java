package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private void solution() throws IOException {
        List<List<Integer>> input = Main.InputView.makeList();

        Comparison.compare(input);
    }

    private static class Comparison {
        private static void compare(List<List<Integer>> input) {
            System.out.println(input.size());
            // TODO: 출력 기능 분리
            for(int i = 0; i < input.size(); i++) {
                List<Integer> numbers = input.get(i);

                Set<Integer> setNumbers = new HashSet<>(numbers);
                int setSize = setNumbers.size();

                int max = Collections.max(numbers);
                numbers.remove(Integer.valueOf(max));
                int left = numbers.stream().mapToInt(Integer::intValue).sum();

                if (max >= left) {
                    System.out.println("Invalid");
                    continue;
                }
                if (setSize == 1) {
                    System.out.println("Equilateral");
                    continue;
                }
                if (setSize == 2) {
                    System.out.println("Isosceles");
                    continue;
                }
                if (setSize == 3) {
                    System.out.println("Scalene");
                }
            }
        }
    }

    private static class InputView {
        private static final String SEPARATOR = " ";
        private static final List<Integer> END_CONDITION = Arrays.asList(0, 0, 0);

        private static List<Integer> read() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Arrays.stream(br.readLine().split(SEPARATOR)).map(Integer::parseInt).collect(Collectors.toList());
        }

        private static List<List<Integer>> makeList() throws IOException {
            List<List<Integer>> input = new ArrayList<>();

            while (true) {
                List<Integer> lines = Main.InputView.read();
                if (END_CONDITION.equals(lines)) break;
                input.add(lines);
            }

            return input;
        }
    }

//    private static class OutputView {
//        private static void printAnswer() {
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            bw.write();
//            bw.newline();
//            bw.close();
//        }
//    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}