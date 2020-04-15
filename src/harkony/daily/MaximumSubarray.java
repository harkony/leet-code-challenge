package harkony.daily;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int dp[]=new int[nums.length];
        dp[nums.length-1]=nums[nums.length-1];
        int max=dp[nums.length-1];

        for(int i=nums.length-2;i>=0;i--){
            if(dp[i+1]>0) {
                dp[i] = nums[i] + dp[i + 1];
            }
            else
                dp[i]= nums[i];
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
