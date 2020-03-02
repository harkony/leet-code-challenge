package quodvide;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(120));
        System.out.println("--------");
        System.out.println(reverse(-312));
    }

    public static int reverse(int x) {
        long reverseResult = 0;
        boolean isNegative = false;
        String target;
        if(x >= 0) {
            target = Integer.toString(x);
        } else {
            isNegative = true;
            target = Integer.toString(x).substring(1);
        }

        for (int i = 0; i < target.length(); i++) {
            reverseResult += Math.pow(10, i) * (target.charAt(i) - 48);
        }

        if(isNegative) {
            reverseResult *= -1;
        }

        if(reverseResult > Integer.MAX_VALUE || reverseResult < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) reverseResult;
        }
    }
}
