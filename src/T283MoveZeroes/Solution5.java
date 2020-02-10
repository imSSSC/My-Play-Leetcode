package T283MoveZeroes;

// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/description/
//
// 原地(in place)解决该问题
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 网友思路 不是官方思路
public class Solution5 {
    public void moveZeroes(int[] nums) {

        int count = 0;// nums中,[0,count)的元素均为非0元素,count为几个0元素.

        // 统计0的个数，如果count大于0，将非0元素直接移到当前位置减去0元素个数的位置上，将当前元素用0填充。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (count > 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void main(String args[]) {

        int[] arr = {0, 1, 0, 3, 12};

        (new Solution5()).moveZeroes(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
