package com.hackerrank.string;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    private static boolean isAnagram(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }

        char[] aChars = a.toLowerCase().toCharArray();
        char[] bChars = b.toLowerCase().toCharArray();

        Arrays.sort(aChars);
        Arrays.sort(bChars);

        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
