package T75SortColors;

// 75. Sort Colors
// https://leetcode-cn.com/problems/sort-colors/description/
//
// 计数排序的思路
// 对整个数组遍历了两遍
// 时间复杂度: O(n)
// 空间复杂度: O(k), k为元素的取值范围
public class Solution1 {

    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0};
        for (int num : nums) {
            assert num >= 0 && num <= 2;
            count[num]++;
        }

        // 这种写法,和下面写法一样
        // int index = 0;
        // for (int i = 0; i < count[0]; i++) {
        //     nums[index++] = 0;
        // }
        // for (int i = 0; i < count[1]; i++) {
        //     nums[index++] = 1;
        // }
        // for (int i = 0; i < count[2]; i++) {
        //     nums[index++] = 2;
        // }

        // 这种写法,和上面写法一样
        for (int i = 0; i < nums.length; i++) {
            if (i <= count[0] - 1) {
                nums[i] = 0;
            } else if (i <= count[0] + count[1] - 1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void printArr(int[] nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println('牛'|'2');
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 0, 2, 2, 2, 1, 1, 0};
        (new Solution1()).sortColors(nums);
        printArr(nums);
    }
}
