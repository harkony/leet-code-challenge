package quodvide;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 */
public class ZigzagConverison {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        char[] originCharArray = s.toCharArray();
        char[] charArray = new char[s.length()];

        int index = 0;
        int tmp;
        int tmp2;
        for (int i = 0; i < numRows; i++) {
            if( i == 0 ) {
                for (int j = 0; (numRows - 1) * (2 * j) < s.length(); j++) {
                    charArray[index] = originCharArray[(numRows - 1) * (2 * j)];
                    index++;
                }
            } else if ( i == numRows - 1 ) {
                for (int j = 0; (numRows - 1) * (2 * j + 1) < s.length(); j++) {
                    charArray[index] = originCharArray[(numRows - 1) * (2 * j + 1)];
                    index++;
                }
            } else {
                for (int j = 0; true; j++) {
                    tmp = (numRows - 1) * (2 * j) - i;
                    tmp2 = (numRows - 1) * (2 * j) + i;

                    if( j == 0 ) {
                        if (tmp2 < s.length()) {
                            charArray[index] = originCharArray[tmp2];
                            index++;
                        } else {
                            break;
                        }
                    } else {
                        if (tmp < s.length()) {
                            charArray[index] = originCharArray[tmp];
                            index++;
                        } else {
                            break;
                        }

                        if (tmp2 < s.length()) {
                            charArray[index] = originCharArray[tmp2];
                            index++;
                        } else {
                            break;
                        }
                    }
                }
            }

        }

        return String.valueOf(charArray);
    }
}
