package Offer.T04;

// 剑指 Offer 04. 二维数组中的查找
// https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/

// 时间复杂度：?
// 空间复杂度：?
public class Solution1 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 如果左边大于等于 target 右边小于等于 target
        if (matrix.length == 0) return false;
        for (int[] inArrays : matrix) {
            if (inArrays.length == 0) return false;
            if (inArrays[0] <= target && inArrays[inArrays.length - 1] >= target) {
                for (int inNumber : inArrays) {
                    if (inNumber == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
