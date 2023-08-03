
import java.util.Arrays;
public class ques2a {

    public static int longestSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        // The minimum length of the subsequence is 1 for each element
        Arrays.fill(dp, 1);

        // Iterate through the array to find the longest subsequence for each element
        for (int i = 1; i < n; i++) {
            // Check the elements before the current element within the range 'k'
            for (int j = i - 1; j >= 0 && i - j <= k; j--) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum length in the dp array
        int longestLength = 0;
        for (int len : dp) {
            longestLength = Math.max(longestLength, len);
        }

        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15};
        int k = 3;
        int output = longestSubsequence(nums, k);
        System.out.println("Length of the longest subsequence: " + output);
    }
}
