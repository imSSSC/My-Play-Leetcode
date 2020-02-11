package T26RemoveDuplicatesFromSortedArray;

// 26. Remove Duplicates from Sorted Array
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
//
// 原地(in place)解决该问题
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {
    public int removeDuplicates(int[] nums) {

        // 数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。
        // 当我们遇到 nums[j] != nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到 nums[i + 1], 然后递增 i.
        // 接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。

        if (nums.length == 0) {
            return 0;
        }

        int i = 0; //慢指针,指向最后一个不重复的位置
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1, 1, 3, 12};

        int newNumsLength = (new Solution1()).removeDuplicates(arr);
        System.out.println(newNumsLength);

        for (int i = 0; i < newNumsLength; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
