package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static private final Set<Integer> allSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9 ,10,
                                                                            11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
    static private final Set<Integer> emptySet = new HashSet<>();

    static void solution() throws IOException {
        Set<Integer> setS = emptySet;

        //TODO: 제출시 주석 처리된 코드로 제출
        List<String> input = InputView.readFromFile("src/main/java/org/input.txt");
//        List<String> input = InputView.read();
        for (String s : input) {
            List<String> parsedLine = InputView.parse(s);
            setS = modifySet(setS, parsedLine);
        }
    }


    private static Set<Integer> modifySet(Set<Integer> set, List<String> line) {
        String order = line.get(0);
        int num = -1;

        if (1 < line.size()) num = Integer.parseInt(line.get(1));

        if (order.equals("check")) {
            printCheck(set, num);
            return set;
        }

        Set<Integer> modifiedSet = findFunction(order, num, set);

        return modifiedSet;
    }

    private static Set<Integer> findFunction(String order, int num, Set<Integer> set) {
        if (order.equals("add")) {
            set.add(num);
            return set;
        }

        if (order.equals("remove")) {
            set.remove(num);
            return set;
        }

        if (order.equals("toggle")) {
            if (set.contains(num)) {
                set.remove(num);
                return set;
            } else {
                set.add(num);
                return set;
            }
        }

        if (order.equals("all")) {
            return allSet;
        }

        if (order.equals("empty")) {
            return emptySet;
        }

        throw new IllegalArgumentException("ERROR: Unknown order");
    }

    private static void printCheck(Set<Integer> set, int num) {
        System.out.println(set.contains(num));
    }

    private static class InputView {
        static List<String> read() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int m = Integer.parseInt(br.readLine());

            List<String> input = new ArrayList<>();
            for (int i = m; 0 < i; i--) {
                input.add(br.readLine());
            }

            return input;
        }

        static List<String> parse(String input) {
            StringTokenizer st = new StringTokenizer(input);
            List<String> line = new ArrayList<>();

            while (st.hasMoreTokens()) {
                line.add(st.nextToken());
            }

            return line;
        }

        //TODO: 파일 읽어오는 함수. 제출 시 삭제
        static List<String> readFromFile(String filePath) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            int m = Integer.parseInt(br.readLine());
            List<String> input = new ArrayList<>();

            for (int i = m; i > 0; i--) {
                input.add(br.readLine());
            }

            br.close(); // 파일 닫기
            return input;
        }
    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}