package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private void solution() throws IOException {
        List<List<Integer>> input = Main.InputView.read();
        for (int i = 0; i < input.size(); i++) {
            System.out.println(input.get(i));
        }

        Comparison.compare(input);
    }

    private static class Comparison {
        private static void compare(List<List<Integer>> input) {
            // TODO: 출력 기능 분리
            for(int i = 0; i < input.size(); i++) {
                List<Integer> numbers = input.get(i);

                int max = Collections.max(numbers);
                numbers.remove(Integer.valueOf(max));
                int left = numbers.stream().mapToInt(Integer::intValue).sum();
                System.out.println(left);

                if (max >= left) {
                    System.out.println("Invalid");
                    continue;
                }

                Set<Integer> setNumbers = new HashSet<>(numbers);
                int setSize = setNumbers.size();

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
료
        private static List<List<Integer>> read() throws IOException {
            // TODO: eof 읽고 nullPointer EXception 안나게 처리
            // TODO: 0 0 0 입력되면 입력 종
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            List<List<Integer>> numbers = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ");

                List<Integer> separatedLine = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    separatedLine.add(Integer.parseInt(st.nextToken()));
                }

                numbers.add(separatedLine);
            }
            return numbers;
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