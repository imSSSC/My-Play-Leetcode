package T70ClimbingStairs;

import java.util.Arrays;

// 70. 爬楼梯
// https://leetcode-cn.com/problems/climbing-stairs/
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 优解：动态规划
public class Solution2 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 2];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().climbStairs(3));
    }
}
