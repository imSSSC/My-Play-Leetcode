package Offer.T101;

// 剑指 Offer 10- I. 斐波那契数列
// https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

import java.util.Arrays;

// 时间复杂度：?
// 空间复杂度：?
public class Solution1 {

    public int fib(int n) {
        int[] memory = new int[n + 2];
        memory[0] = 0;
        memory[1] = 1;
        for (int i = 2; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
            memory[i] = memory[i] % (1000000007);
        }
        return memory[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().fib(48));
    }

}

