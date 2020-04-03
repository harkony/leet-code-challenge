package harkony.weekly.week4;

import java.util.Arrays;
import java.util.List;

public class StringToInteger {
    public static int myAtoi(String str) {
        char whiteSpace = ' ';
        String number = parseNumber(removeFirstSequenceOf(str, whiteSpace));
        return parseInt(number);

    }

    // return String that removed first sequence of specific character
    public static String removeFirstSequenceOf(String src, char character) {
        if (src == null || src.isEmpty())
            return "";

        boolean isStartWithCharacter = src.charAt(0) == character;
        if (isStartWithCharacter) {
            int lastIndex = 1;
            for (; lastIndex < src.length(); lastIndex++) {
                if (src.charAt(lastIndex) == character) continue;
                break;
            }
            return src.substring(lastIndex, src.length());
        }
        return src;
    }

    public static String parseNumber(String str) {
        if (str == null || str.isEmpty())
            return "";
        boolean isStartWithDigit = isDigits(str.charAt(0));
        boolean isStarWithSigh = isSign(str.charAt(0));
        if (!isStartWithDigit && !isStarWithSigh)
            return "";

        int endIndex = isSign(str.charAt(0)) ? 1 : 0;

        for (; endIndex < str.length(); endIndex++) {
            if (isDigits(str.charAt(endIndex)))
                continue;
            break;
        }

        if (isStarWithSigh && endIndex == 1)
            return "";

        if (isStarWithSigh)
            return str.charAt(0) + removeFirstSequenceOf(str.substring(1, endIndex), '0');
        return removeFirstSequenceOf(str.substring(0, endIndex), '0');
    }

    public static int parseInt(String number) {
        if (number == null || number.isEmpty())
            return 0;

        int offset = isSign(number.charAt(0)) ? 1 : 0;
        long value = 0;
        long weight = 1;

        if (number.charAt(0) == '-') {
            for (int index = number.length() - 1; index >= offset; index--) {
                value -= (number.charAt(index) - '0') * weight;
                weight *= 10;
                if (value < Integer.MIN_VALUE || weight/10 > Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;
            }
            return (int) value;
        }

        for (int index = number.length() - 1; index >= offset; index--) {
            value += (number.charAt(index) - '0') * weight;
            weight *= 10;
            if (value > Integer.MAX_VALUE || weight/10 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) value;

    }

    public static boolean isSign(char target) {
        char signs[] = {'+', '-'};
        for (char c : signs) {
            if (c == target)
                return true;
        }
        return false;
    }

    public static boolean isDigits(char target) {
        char digits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char c : digits) {
            if (c == target)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> tests = Arrays.asList("  0000000000012345678","   -42","2147483646", "-000000000000000000", "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459", "42", "  -42", "4193 with words", "words and 987", "-91283472332", "20000000000000000", "-200000000000000000");
        for (String str : tests) {
            System.out.println(myAtoi(str));
        }
    }

}
