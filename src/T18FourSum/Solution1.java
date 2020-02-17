package T18FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18. 四数之和
// https://leetcode-cn.com/problems/4sum/
//
// 时间复杂度: O(nlogn) + O(n^2)
// 空间复杂度: O(1)
// 排序+双指针
public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // 排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int a1 = target - nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int start = j + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int sum = nums[j] + nums[start] + nums[end];
                    if (sum == a1) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (sum > a1) {
                        end--;
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else {
                        start++;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        System.out.println((new Solution1().fourSum(nums, target)));
    }
}
