package Offer.T102;

// 剑指 Offer 10- II. 青蛙跳台阶问题
// https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/

// 时间复杂度：?
// 空间复杂度：?
public class Solution1 {

    public int numWays(int n) {
        int[] mem = new int[n + 2];
        mem[0] = 1;
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
            mem[i] = mem[i] % 1000000007;
        }
        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().numWays(48));
    }

}

