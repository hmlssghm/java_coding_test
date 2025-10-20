package org.example;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private void solution() throws IOException {
        List<int[]> input = Main.InputView.makeList();
        System.out.println(input);

//        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);
//        int max = Collections.max(numbers);
//        System.out.println(max);
    }

    private static class InputView {
        private static final String SEPARATOR = " ";
        private static final int[] END_CONDITION = {0, 0, 0};


        private static int[] read() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Arrays.stream(br.readLine().split(SEPARATOR)).mapToInt(Integer::parseInt).toArray();
        }

        private static List<int[]> makeList() throws IOException {
            List<int[]> input = new ArrayList<>();

            while (true) {
                int[] lines = Main.InputView.read();
                if (Arrays.equals(END_CONDITION, lines)) break;
                input.add(lines);
            }

            return input;
        }
    }

    private static class OutputView {
        private static void printAnswer() {
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            bw.write();
//            bw.newline();
//            bw.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}