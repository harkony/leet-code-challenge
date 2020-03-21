package quodvide;

public class PalindromNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }
    public static boolean isPalindrome(int x) {
        char[] charArr = String.valueOf(x).toCharArray();
        for (int i = 0; i < charArr.length / 2; i++) {
            if(charArr[i] != charArr[charArr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
