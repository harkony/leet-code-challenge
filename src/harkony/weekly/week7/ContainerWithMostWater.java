package harkony.weekly.week7;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int vol = Math.min(height[i], height[j]) * (j - i);
                max = vol > max ? vol : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int test[] = {1, 1};
        System.out.println(maxArea(test));
    }
}