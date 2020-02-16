package T219ContainsDuplicateII;

// 219. Contains Duplicate II
// https://leetcode-cn.com/problems/contains-duplicate-ii/description/

import java.util.HashSet;

// 时间复杂度: O(n)
// 空间复杂度: O(k)
public class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length <= 1 || k <= 0) {
            return false;
        }

        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }

            record.add(nums[i]);
            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }
        }

        return false;
    }


    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        int k = 1;
        printBool((new Solution1()).containsNearbyDuplicate(nums, k));
    }
}
