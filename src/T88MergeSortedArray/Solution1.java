package T88MergeSortedArray;

import java.util.Arrays;

// 88. Merge Sorted Array
// https://leetcode-cn.com/problems/merge-sorted-array/
//
// 时间复杂度 : O(n+m)。
// 空间复杂度 : O(m)。
// 方法一：双指针 / 从前往后
// 归并排序
public class Solution1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1_copy = Arrays.copyOfRange(nums1, 0, m);

        int p1 = 0, p2 = 0, p = 0; // p1为nums1_copay的开头,p2为nums2的开头,p为合并后num1的指针

        // 遍历[0,nums1.length)
        for (; p < n + m; p++) {
            if (p1 >= m) { // nums1_copy遍历完
                nums1[p] = nums2[p2++];
            } else if (p2 >= n) { // nums2遍历完
                nums1[p] = nums1_copy[p1++];
            } else if (nums1_copy[p1] < nums2[p2]) {// nums1_copy < num2
                nums1[p] = nums1_copy[p1++];
            } else { // num2 <= nums1_copy
                nums1[p] = nums2[p2++];
            }
        }

    }

    public static void printArr(int[] nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 11, 13, 19, 0, 0, 0, 0, 0};
        int[] nums2 = {10, 11, 12, 13, 14};
        new Solution1().merge(nums1, 9, nums2, 5);
        printArr(nums1);
    }

}
