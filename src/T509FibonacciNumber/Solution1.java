package T509FibonacciNumber;

import java.util.Arrays;

// 509. 斐波那契数
// https://leetcode-cn.com/problems/fibonacci-number/
//
// 时间复杂度: O(?)
// 空间复杂度: O(?)
// 记忆化搜索：自上而下 （通常大家思考的方向）
public class Solution1 {

    public int fib(int N) {
        Integer[] memo = new Integer[N + 1];
        Arrays.fill(memo, -1);
        if (N <= 1)
            return N;
        return fib(N, memo);
    }

    public int fib(int N, Integer[] memo) {

        if (memo[N] == -1)
            memo[N] = fib(N - 1) + fib(N - 2);
        return memo[N];
    }


    public static void main(String[] args) {
        System.out.println(new Solution1().fib(40));
    }
}
