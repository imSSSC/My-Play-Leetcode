package T70ClimbingStairs;

import java.util.Arrays;

// 70. 爬楼梯
// https://leetcode-cn.com/problems/climbing-stairs/
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 普通解法：自上而下
public class Solution1 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairs(n, memo);
    }

    public int climbStairs(int n, int[] memo) {
        if (n == 0 || n == 1)
            return 1;
        if (memo[n] == -1)
            memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().climbStairs(2));
    }
}
