package harkony.weekly.week3;

public class ReverseInteger {

    public static int reverse(int x) {
        String str=String.valueOf(x);
        StringBuffer reversed=reverseString(str);
        int length=reversed.length();
        boolean isMinus=x<0;
        if(isMinus) {
            reversed = reversed.replace(length - 1, length, "");
        }
        try {
            return Integer.parseInt(String.valueOf(reversed))* (isMinus?-1:1);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static StringBuffer reverseString(String s) {
        return ( new StringBuffer(s) ).reverse();
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(-10));
    }
}
