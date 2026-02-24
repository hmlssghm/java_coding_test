package org.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Boj4659 {
    static char vowel1 = 'a';
    static char vowel2 = 'e';
    static char vowel3 = 'i';
    static char vowel4 = 'o';
    static char vowel5 = 'u';

    static void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> input = getPasswords();
        for(String password: input) {
            if (checkTerm1(password) && checkTerm2(password) && checkTerm3(password)) {
                bw.write(printResult(true, password));
            } else {
                bw.write(printResult(false, password));
            }
        }
        bw.flush();
        bw.close();
    }

    static List<String> getPasswords() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = new ArrayList<>();
        String newLine;
        do {
            newLine = br.readLine();
            input.add(newLine);
        } while (!newLine.equals("end"));
        input.remove(input.size() - 1);

        br.close();
        return input;
    }

    static boolean checkTerm1(String password) {
        return password.contains(String.valueOf(vowel1)) || password.contains(String.valueOf(vowel2))
                || password.contains(String.valueOf(vowel3)) || password.contains(String.valueOf(vowel4))
                || password.contains(String.valueOf(vowel5));
    }

    static boolean checkTerm2(String password) {
        String isVowelTable = getIsVowelTable(password);
        return !isVowelTable.contains("000") && !isVowelTable.contains("111");
    }

    private static String getIsVowelTable(String password) {
        StringBuilder isVowelTable = new StringBuilder();
        for (int i = 0 ; i < password.length(); i ++) {
            if(isVowel(password.charAt(i))) {
                isVowelTable.append("1");
            } else {
                isVowelTable.append("0");
            }
        }
        return isVowelTable.toString();
    }

    private static boolean isVowel(char singleCharacter) {
        return singleCharacter == vowel1 || singleCharacter == vowel2
                || singleCharacter == vowel3 || singleCharacter == vowel4
                || singleCharacter == vowel5;
    }

    static boolean checkTerm3(String password) {
        char exception1 = 'e';
        char exception2 = 'o';

        for (int i = 0 ; i < password.length() - 1 ; i++) {
            char first = password.charAt(i);
            char second = password.charAt(i + 1);

            if ((first == second) && (first != exception1 && first != exception2)) return false;
        }
        return true;
    }

    static String printResult(boolean isValid, String password) {
        if (isValid) {
            return String.format("<%s> is acceptable.\n", password);
        }
        return String.format("<%s> is not acceptable.\n", password);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}