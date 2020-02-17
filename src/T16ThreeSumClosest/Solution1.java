package T16ThreeSumClosest;

import java.util.Arrays;

// 16. 最接近的三数之和
// https://leetcode-cn.com/problems/3sum-closest/
//
// 时间复杂度: O(nlogn) + O(n^2)
// 空间复杂度: O(1)
// 排序+双指针
public class Solution1 {

    public int threeSumClosest(int[] nums, int target) {

        // 排序
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        // 双循环
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println((new Solution1().threeSumClosest(nums, target)));
    }
}
