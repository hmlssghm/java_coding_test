package org.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj20125 {
    public static void main(String[] args) throws IOException {
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<String> field = input();
        Map<String, Integer> heartXY = findHeart(field);
        Map<String, Integer> armsLen = measureArms(field, heartXY);
        Map<String, Integer> bodyAndLegsLen = measureBodyAndLegs(field, heartXY);

        String answer1 = String.format("%d %d%n", heartXY.get("x") + 1, heartXY.get("y") + 1);
        String answer2 = String.format("%d %d %d %d %d", armsLen.get("leftArm"), armsLen.get("rightArm"),
                bodyAndLegsLen.get("body"), bodyAndLegsLen.get("leftLeg"), bodyAndLegsLen.get("rightLeg"));

        br.write(answer1);
        br.write(answer2);
        br.flush();
    }

    static List<String> input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("/Users/gracek/IdeaProjects/java_coding_test/src/main/java/org/input.txt"));
        int n = Integer.parseInt(br.readLine());

        List<String> field = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            field.add(br.readLine());
        }

        return field;
    }

    static Map<String, Integer> findHeart(List<String> field) {
        int n = field.size();

        Map<String, Integer> heartXY = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!field.get(i).contains("*")) continue;
            else {
                heartXY.put("x", i + 1); // index O. 정답 X
                heartXY.put("y", field.get(i).indexOf("*"));
                break;
            }
        }
        return heartXY;
    }

    private static Map<String, Integer> measureArms(List<String> field, Map<String, Integer> heartXY) {
        int heartX = heartXY.get("x");
        int heartY = heartXY.get("y");

        String arms = field.get(heartX);
        int leftArmLen = heartY - arms.indexOf("*");
        int rightArmLen = arms.lastIndexOf("*") - heartY;

        Map<String, Integer> armsLen = new HashMap<>();
        armsLen.put("leftArm", leftArmLen);
        armsLen.put("rightArm", rightArmLen);

        return armsLen;
    }

    private static Map<String, Integer> measureBodyAndLegs(List<String> field, Map<String, Integer> heartXY) {
        Map<String, Integer> bodyAndLegsLen = new HashMap<>();
        int heartX = heartXY.get("x");
        int heartY = heartXY.get("y");

        int bodyLen = 0;
        int leftLegLen = 0;
        int rightLegLen = 0;

        for (int i = heartX + 1; i < field.size(); i++) {
            if (field.get(i).charAt(heartY) == '*') bodyLen += 1;
            if (field.get(i).charAt(heartY - 1) == '*') leftLegLen += 1;
            if (field.get(i).charAt(heartY + 1) == '*') rightLegLen += 1;
        }

        bodyAndLegsLen.put("body", bodyLen);
        bodyAndLegsLen.put("leftLeg", leftLegLen);
        bodyAndLegsLen.put("rightLeg", rightLegLen);

        return bodyAndLegsLen;
    }
}