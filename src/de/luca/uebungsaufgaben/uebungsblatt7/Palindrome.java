package de.luca.uebungsaufgaben.uebungsblatt7;

public class Palindrome {

    public static void main(String[] args) {
        String palindrome = "lagerregal";
        System.out.println("\"" + palindrome + "\" is palindrome: " + checkPalindrome(palindrome));
    }

    private static boolean checkPalindrome(String palindrome) {
        if (palindrome.length() <= 1) return true;
        boolean sameCharAtBeginningAndEnd = palindrome.charAt(0) == palindrome.charAt(palindrome.length() - 1);
        return sameCharAtBeginningAndEnd && checkPalindrome(palindrome.substring(1, palindrome.length() - 1));
    }
}
