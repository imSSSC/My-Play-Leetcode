package T217ContainsDuplicate;

import java.util.HashSet;

// 217. 存在重复元素
// https://leetcode-cn.com/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode/
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)
// 查找表
public class Solution1 {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> recode = new HashSet<>();
        for (int num : nums) {
            if (recode.contains(num)) return true;
            recode.add(num);
        }

        return false;
    }

    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        printBool((new Solution1()).containsDuplicate(nums));
    }
}
