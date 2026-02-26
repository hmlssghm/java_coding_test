package org.implementation;

import org.example.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj9017 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("/Users/gracek/IdeaProjects/java_coding_test/src/main/java/org/input.txt"));
        int switchCount = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Boolean> switchList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            // st.nextToken 변수로 안받고 직접 호출해서 저장도 전에 토큰 다 써버림. 주의!! 변수로 받을것
            String nextToken = st.nextToken();
            if (nextToken.equals("1")) switchList.add(true);
            if (nextToken.equals("0")) switchList.add(false);
        }

        int studentCount = Integer.parseInt(br.readLine());

        List<StudentInfo> student = new ArrayList<>();
        for(int i = 0; i < studentCount; i++) {
            String[] input = br.readLine().split(" ");
            StudentInfo newLine = new StudentInfo(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            student.add(newLine);
        }

        for(StudentInfo s: student) {
            if(s.gender == 1) {
                male(s.switchNum, switchList);
            }
            if(s.gender == 2) {
                female(s.switchNum, switchList);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (boolean b: switchList) {
            if (b) sb.append(1);
            if (!b) sb.append(0);

            if (count % 20 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
            count++;
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    static class StudentInfo {
        int gender; // 1은 남자 2는 여자
        int switchNum;

        public StudentInfo(int gender, int switchNum) {
            this.gender = gender;
            this.switchNum = switchNum;
        }
    }

    static void male(int switchNum, List<Boolean> switchList) {
        // 이런 인덱스가 되는 수(switchNum)를 곱하거나 하는 상황에선 최대한 마지막에 -1 해서 원래수랑 인덱스 매칭을 해주자.
        int idx = switchNum;
        for (int multiply = 2; idx - 1 < switchList.size(); multiply++) {
            switchList.set(idx - 1, !switchList.get(idx - 1));
            idx = switchNum * multiply;
        }
    }

    static void female(int switchNum, List<Boolean> switchList) {
        int switchSize = switchList.size();
        int idx = switchNum - 1;

        switchList.set(idx, !switchList.get(idx));

        int step = 1;
        while(true) {
            int leftIdx = idx - step;
            int rightIdx = idx + step;
            if (leftIdx < 0 || switchSize <= rightIdx) break;
            if (switchList.get(leftIdx) != switchList.get(rightIdx)) break;

            switchList.set(leftIdx, !switchList.get(leftIdx));
            switchList.set(rightIdx, !switchList.get(rightIdx));

            step++;
        }
    }
}