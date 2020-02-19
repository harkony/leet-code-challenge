package quodvide;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                if ( longestPalindrome.length() < s.length() - j - i && isPalindrom(s.substring(i, s.length() - j)) ) {
                    longestPalindrome = s.substring(i, s.length() - j);
                }
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindrom(String substring) {
        for (int i = 0; i < substring.length()/2; i++) {
            if(substring.charAt(i) != substring.charAt(substring.length() - 1 - i)) return false;
        }
        return true;
    }
}
