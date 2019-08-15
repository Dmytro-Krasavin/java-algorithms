package com.hackerrank.string;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        String reverseString = new StringBuilder(inputString).reverse().toString();
        boolean isPalindrome = inputString.equals(reverseString);
        System.out.println(isPalindrome ? "Yes" : "No");
    }
}
