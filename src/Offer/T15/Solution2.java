package Offer.T15;

// 剑指 Offer 15. 二进制中1的个数
// https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/

// 时间复杂度：?
// 空间复杂度：?
public class Solution2 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res ++;
            n &= n - 1;
        }
        return res;
    }
}

