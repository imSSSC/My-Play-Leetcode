package T88MergeSortedArray;

// 88. Merge Sorted Array
// https://leetcode-cn.com/problems/merge-sorted-array/
//
// 时间复杂度 : O(n + m)。
// 空间复杂度 : O(1)
// 方法二：双指针 / 从后往前
// 归并排序
public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1, len2 = n - 1, len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    public static void printArr(int[] nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 11, 13, 19, 0, 0, 0, 0, 0};
        int[] nums2 = {10, 11, 12, 13, 14};
        new Solution2().merge(nums1, 9, nums2, 5);
        printArr(nums1);
    }
}
