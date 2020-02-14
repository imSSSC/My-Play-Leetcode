package T11ContainerWithMostWater;

// 11. 盛最多水的容器
// https://leetcode-cn.com/problems/container-with-most-water/
//
// 对撞指针
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    public int maxArea(int[] height) {

        int l = 0, r = height.length - 1, maxArea = 0;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            maxArea = Math.max(min * (r - l), maxArea);
            if (height[l] == min) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(new Solution1().maxArea(height));
    }
}
