package org.implementation;

import org.example.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj5073 {
    private void solution() throws IOException {
        List<List<Integer>> input = Boj5073.InputView.read();
        Boj5073.Comparison.compare(input);
    }

    private static class Comparison {
        private static void compare(List<List<Integer>> input) {
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
        private static final List<Integer> END_CONDITION = Arrays.asList(0, 0, 0);
        private static List<List<Integer>> read() throws IOException {
            // TODO: 0 0 0 입력되면 입력 종
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            List<List<Integer>> input = new ArrayList<>();
            while(true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                List<Integer> line = new ArrayList<>();

                while(st.hasMoreTokens()){
                    line.add(Integer.parseInt(st.nextToken()));
                }

                if (line.equals(END_CONDITION)) break;

                input.add(line);
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
//
//    public static void main(String[] args) throws Exception {
//        new Main().solution();
//    }
}
