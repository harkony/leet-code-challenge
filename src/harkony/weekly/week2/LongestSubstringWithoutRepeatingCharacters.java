package harkony.weekly.week2;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        int max = 1;
        int mat[] = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        //init
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt((i));
            Integer index = map.get(c);
            if (index != null) {
                mat[index] = i;
            }
            map.put(c, i);
        }

        for (int startIndex = 0; startIndex < s.length() - 1; startIndex++) {
            int endIndex = s.length() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                int nextIndex = mat[j];
                if (nextIndex != 0) {
                    if (nextIndex <= endIndex)
                        endIndex = nextIndex - 1;
                }
            }
            int length = getLength(startIndex, endIndex);
            if (length > max)
                max = length;
        }
        return max;
    }

    private static int getLength(int startIndex, int endIndex) {
        return endIndex - startIndex + 1;
    }
}
