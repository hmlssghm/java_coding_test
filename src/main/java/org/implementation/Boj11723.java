package org.implementation;

import java.io.*;
import java.util.*;

public class Boj11723 {
    static private final Set<Integer> allSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9 ,10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> setS = new HashSet<>();

        int m = InputView.readCount(br);
        for (int i = m; 0 < i; i--) {
            List<String> input = InputView.readOrders(br);
            if (isCheck(input)) {
                bw.write(judgeContain(setS, input));
                bw.newLine();
            } else {
                setS = modifySet(setS, input);
            }
        }

        bw.flush();
        bw.close();
    }

    private static boolean isCheck(List<String> input) {
        return input.get(0).equals("check");
    }

    private static char judgeContain(Set<Integer> setS, List<String> input) {
        int num = Integer.parseInt(input.get(1));

        if (setS.contains(num)) return '1';
        else return '0';
    }

    private static Set<Integer> modifySet(Set<Integer> set, List<String> line) {
        String order = line.get(0);
        int num = -1;

        if (1 < line.size()) num = Integer.parseInt(line.get(1));

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
            set.clear();
            set.addAll(allSet);
            return set;
        }

        if (order.equals("empty")) {
            set.clear();
            return set;
        }

        throw new IllegalArgumentException("ERROR: Unknown order");
    }

    private static class InputView {
        static int readCount(BufferedReader br) throws IOException {
            int m = Integer.parseInt(br.readLine());

            return m;
        }

        static List<String> readOrders(BufferedReader br) throws IOException {
            String line = br.readLine();

            return parse(line);
        }

        static List<String> parse(String input) {
            StringTokenizer st = new StringTokenizer(input);
            List<String> line = new ArrayList<>();

            while (st.hasMoreTokens()) {
                line.add(st.nextToken());
            }

            return line;
        }
    }

//    public static void main(String[] args) throws Exception {
//        Runtime runtime = Runtime.getRuntime();
//
//        // GC 실행 후 사용 가능한 메모리 확인
//        runtime.gc();
//
//        long before = runtime.totalMemory() - runtime.freeMemory();
//        System.out.println("Before allocation: " + before + " bytes");
//
//        Main.solution();
//
//        long after = runtime.totalMemory() - runtime.freeMemory();
//        System.out.println("After allocation: " + after + " bytes");
//        System.out.println("Memory used by array: " + (after - before) + " bytes");
//    }
}