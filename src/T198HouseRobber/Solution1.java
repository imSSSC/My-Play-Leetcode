package T198HouseRobber;

import java.util.ArrayList;
import java.util.Arrays;

// 198. 打家劫舍
// https://leetcode-cn.com/problems/house-robber/
//
// 时间复杂度: O(？)
// 空间复杂度: O(？)
// 动态规划
public class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] memo = new int[n + 1];
        Arrays.fill(memo, 0);
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().rob(new int[]{2}));
    }
}
