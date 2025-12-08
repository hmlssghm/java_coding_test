package org.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj10431 {
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/input.txt"));
        List<Integer> answer = new ArrayList<>();

        int count = InputView.getCount(br);

        for (int i = 0; i < count; i++) {
            List<Integer> students = InputView.getTestCase(br);
            answer.add(makeOrder(students));
        }

        OutputView.printAnswer(answer);
    }

    private static int makeOrder(List<Integer> students) {
        List<Integer> order = new ArrayList<>();
        int step = 0;

        order.add(students.remove(0));

        for (int i = 0; i < 19; i++) {
            int nowStudent = students.remove(0);
            int maxHeight = order.get(order.size() - 1);
            int indexA = 0;

            // 현재 학생 키가 order에서 제일 클 경우
            if (maxHeight < nowStudent) {
                order.add(nowStudent);
                continue;
            }

            // 현재 학생 키가 order에서 제일 크지 x
            // 현재 학생보다 크지만 가장 작은 학생 A 찾기
            for (int nowOrder : order) {
                if (nowOrder < nowStudent) {
                    continue;
                }

                indexA = order.indexOf(nowOrder);
                break;
            }
            // 학생 A 앞에 현재 학생 삽입
            order.add(indexA, nowStudent);

            step += (order.size() - indexA - 1);
        }

        return step;
    }

    private static class InputView {
        private static int getCount(BufferedReader br) throws IOException {
            return Integer.parseInt(br.readLine());
        }

        private static List<Integer> getTestCase(BufferedReader br) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> students = new ArrayList<>();

            while (st.hasMoreTokens()) {
                students.add(Integer.parseInt(st.nextToken()));
            }

            students.remove(0);

            return students;
        }
    }

    private static class OutputView {
        private static void printAnswer(List<Integer> answer) {
            for (int i = 0; i < answer.size(); i++) {
                System.out.println((i + 1) + " " + answer.get(i));
            }
        }
    }

//    public static void main(String[] args) throws IOException {
//        solution();
//    }
}