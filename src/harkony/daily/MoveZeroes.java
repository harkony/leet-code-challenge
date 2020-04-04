package harkony.daily;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int next = 0;
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] != 0) {
                nums[next++] = nums[current];
                if (next != current + 1)
                    nums[current] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int n : arr)
            System.out.println(n);
    }
}
