package quodvide;

/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("234 hello world"));
        System.out.println(myAtoi("       -234"));
        System.out.println(myAtoi("h12345"));
    }
    public static int myAtoi(String str) {
        str = str.trim(); // Remove white-space
        if (str.isEmpty()) {
            return 0;
        }

        if ( str.equals("-") || str.equals("+") || ((str.charAt(0) != '-' && str.charAt(0) != '+') && ( str.charAt(0) - 48 < 0 || str.charAt(0) - 48 > 9 ))) {
            return 0;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) - 48 < 0 || str.charAt(i) - 48 > 9) {
                if ( i == 1 && (str.charAt(0) == '-' || str.charAt(0) == '+') ) {
                    return 0;
                }
                str = str.substring(0, i);
                break;
            }
        }
        // str은 이제 숫자로 변환할 수 있음.
        boolean isNegative = str.startsWith("-");

        // 0 없애기. 개같은 엣지케이스가 많다.
        char tmp;
        for (int i = 0; i < str.length(); i++) {
            tmp = str.charAt(i);
            if( tmp != '+' && tmp != '-' && tmp != '0') {
                str = str.substring(i);
                if (isNegative) {
                    str = "-".concat(str);
                }
                break;
            } else if ( tmp == '0' && i == str.length() - 1) {
                return 0;
            }
        }

        if (str.length() > 11) {
            if ( str.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }

        long parsedNumber = Long.parseLong(str);
        if (parsedNumber > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (parsedNumber < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)parsedNumber;
        }
    }
}
