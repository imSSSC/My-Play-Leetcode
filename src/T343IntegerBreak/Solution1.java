package T343IntegerBreak;

import java.util.Arrays;

// 343. 整数拆分
// https://leetcode-cn.com/problems/integer-break/
//
// 时间复杂度: O(？)
// 空间复杂度: O(？)
// 动态规划
public class Solution1 {
    int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int integerBreak(int n) {
        int[] memo = new int[n + 2];
        Arrays.fill(memo,-1);
        memo[1] = 1;
        // 小于等于n ,可以为n
        for (int i = 2; i <= n; i++) {
            // 小于等于 j [1,i-1].
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().integerBreak(3));
    }
}
