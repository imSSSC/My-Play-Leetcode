package T349IntersectionOfTwoArrays;

import java.util.TreeSet;

// 349. Intersection of Two Arrays
// https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
//
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1 = new TreeSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        TreeSet<Integer> set2 = new TreeSet<>();
        for (int num2 : nums2) {
            set2.add(num2);
        }

        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int index = 0;
        for (Integer num : set1)
            res[index++] = num;

        return res;
    }

    private static void printArr(int[] arr) {
        for (int e : arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution2()).intersection(nums1, nums2);
        printArr(res);
    }
}
