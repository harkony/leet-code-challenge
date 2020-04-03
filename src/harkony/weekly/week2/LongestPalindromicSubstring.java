package harkony.weekly.week2;

import java.util.Arrays;
import java.util.List;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0)
            return s;
        int left = 0;
        int right = len - left - 1;

        int maxMiddle = 0;
        int maxLength = 0;
        int min = 0;
        int cnt = 0;
        int length = 0;
        for (int middle = 0; middle < len; middle++) {
            min = Math.min(left, right);
            cnt = 0;
            for (int i = 1; i <= min; i++) {
                int leftTmp = middle - i;
                int rightTmp = middle + i;
                if (isEqual(leftTmp, rightTmp, s))
                    cnt++;
                else {
                    break;
                }
            }

            length = 2 * cnt + 1;
            if (length > maxLength) {
                maxLength = length;
                maxMiddle = middle;
            }

            cnt = 0;
            for (int i = 0; i <= min; i++) {
                int leftTmp = middle - i;
                int rightTmp = middle + i + 1;
                if (isEqual(leftTmp, rightTmp, s))
                    cnt++;
                else {
                    break;
                }
            }

            length = 2 * cnt;
            if (length > maxLength) {
                maxLength = length;
                maxMiddle = middle;
            }

            left += 1;
            right -= 1;
        }


        if (maxLength % 2 == 0)
            return s.substring(maxMiddle - (maxLength / 2) + 1, maxMiddle + maxLength / 2 + 1);

        return s.substring(maxMiddle - maxLength / 2, maxMiddle + maxLength / 2 + 1);

    }

    public static boolean isEqual(int leftIdx, int rightIdx, String s) {
        if (leftIdx < 0 || rightIdx >= s.length())
            return false;
        return s.charAt(leftIdx) == s.charAt(rightIdx);
    }


    public static void main(String[] args) {
        List<String> testCase = Arrays.asList("abcba");
        testCase.stream().map(LongestPalindromicSubstring::longestPalindrome).forEach(System.out::println);

    }


}
