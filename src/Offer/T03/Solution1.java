package Offer.T03;

// 剑指 Offer 03. 数组中重复的数字
// https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

import java.util.HashMap;

// 时间复杂度：O(n)
// 空间复杂度：O(n)
public class Solution1 {

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int num : nums) {
            Integer counts = hashMap.get(num);
            if (counts != null) {
                return num;
            }
            hashMap.put(num, 1);
        }
        throw new IllegalArgumentException("nums not has the num");
    }

    public static void main(String[] args) {

    }
}
