package T167TwoSumII;

// 167. 两数之和 II - 输入有序数组
// https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
//
// 二分搜索法
// 时间复杂度: O(nlogn)
// 空间复杂度: O(1)
public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length < 2) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            int j = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }

        throw new IllegalStateException("The input has no solution");
    }

    private int binarySearch(int[] numbers, int l, int r, int target) {
        if (l < 0 || l > numbers.length) {
            throw new IllegalArgumentException("l is out of bound");
        }
        if (r < 0 || r > numbers.length)
            throw new IllegalArgumentException("r is out of bound");

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] == target) {
                return mid;
            }
            if (target > numbers[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    private static void printArr(int[] nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        printArr((new Solution2()).twoSum(nums, target));
    }
}
