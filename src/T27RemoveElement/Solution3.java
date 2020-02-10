package T27RemoveElement;

// 27. Remove Element
// https://leetcode-cn.com/problems/remove-element/
//
// 原地(in place)解决该问题
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 个人思路: 统计val的个数，如果count大于0，将非val元素直接移到当前位置减去val元素个数的位置上，将当前元素用0填充。
public class Solution3 {
    public int removeElement(int[] nums, int val) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else if (count > 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }

        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        int newNumsLength = (new Solution3()).removeElement(arr, 0);
        System.out.println();

        for (int i = 0; i < newNumsLength; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
