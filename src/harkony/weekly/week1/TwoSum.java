package harkony.weekly.week1;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] solution = new int[2];
        for (int i = 0; i < len - 1; i++) {
            int base = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (base + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                }
            }
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        int[] given = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(given, target);
        System.out.println(result[0] + "." + result[1]);
    }
}
