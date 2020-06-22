package T509FibonacciNumber;

import java.util.Arrays;

// 509. 斐波那契数
// https://leetcode-cn.com/problems/fibonacci-number/
//
// 时间复杂度: O(N)
// 空间复杂度: O(1)
// 动态规划：自下而上
public class Solution2 {

    public int fib(int N) {
        Integer[] memo = new Integer[N + 2];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().fib(0));
    }
}
