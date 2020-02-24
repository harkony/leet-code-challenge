package quodvide;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        boolean jumpFlag = false;
        for (int i = 0; i < s.length(); i++) {
            jumpFlag = false;
            for (int j = 1; j + i <= s.length(); j++) {
                if(jumpFlag) break;
                if((maxLength < j)) {
                  if (checkNotRepeatedString(s.substring(i, i + j))) {
                      maxLength = j;
                  } else {
                      jumpFlag = true;
                  }
                }
            }
        }

        return maxLength;
    }

    public static boolean checkNotRepeatedString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.lastIndexOf(s.charAt(i)) != i) return false;
        }
        return true;
    }
}
