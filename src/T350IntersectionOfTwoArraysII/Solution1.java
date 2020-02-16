package T350IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.TreeMap;

// 350. Intersection of Two Arrays II
// https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
//
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> record = new TreeMap<>();
        for (int num1 : nums1) {
            if (!record.containsKey(num1))
                record.put(num1, 1);
            else
                record.put(num1, record.get(num1) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num2 : nums2) {
            if (record.containsKey(num2) && record.get(num2) > 0) {
                result.add(num2);
                record.put(num2, record.get(num2) - 1);
            }
        }

        int[] ret = new int[result.size()];
        int index = 0;
        for (Integer num : result) {
            ret[index++] = num;
        }

        return ret;
    }

    private static void printArr(int[] arr) {
        for (int e : arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution1()).intersect(nums1, nums2);
        printArr(res);
    }
}
