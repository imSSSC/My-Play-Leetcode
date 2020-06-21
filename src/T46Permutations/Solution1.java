package T46Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: snake
 * @date: 2020/2/17 01:17
 */
// 46. 全排列
// https://leetcode-cn.com/problems/permutations/
//
// 时间复杂度: O(?)
// 空间复杂度: O(?)
// 回溯
public class Solution1 {
    List<List<Integer>> res = new ArrayList<>();
    Boolean[] used;

    void generatePermutation(int[] nums, int index, List<Integer> p) {

        if (index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return res;
        used = new Boolean[nums.length];
        Arrays.fill(used, false);
        List<Integer> p = new ArrayList<>();
        generatePermutation(nums, 0, p);
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution1().permute(nums));
    }
}