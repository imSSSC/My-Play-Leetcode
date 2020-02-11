package T80RemoveDuplicatesFromSortedArrayII;

// 80. Remove Duplicates from Sorted Array II
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
//
// 原地(in place)解决该问题
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 方法二：覆盖多余的重复项
public class Solution2 {

    // 由于输入数组已经排序，所以重复项都显示在旁边。题目要求我们不使用额外的空间，在原地修改数组，而最优的方法就是覆盖多余的重复项。
    // 对于数组中的每个数字，若出现 2 个以上的重复项，就将多余的重复项从数组列表中覆盖。

    // 若当前元素与前一个元素相同，即 nums[i]==nums[i-1]，则 count++。若 count > 2，则说明遇到了多余的重复项。在这种情况下，我们只向前移动 i，而 j 不动。
    // 若 count <=2，则我们将 i 所指向的元素移动到 j 位置，并同时增加 i 和 j。
    // 若当前元素与前一个元素不相同，即 nums[i] != nums[i - 1]，说明遇到了新元素，则我们更新 count = 1，并且将该元素移动到 j 位置，并同时增加 i 和 j。
    public int removeDuplicates(int[] nums) {
        //i为当前的索引,count为当前元素出现的次数,length为数组的长度.
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count < 3) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 1, 1, 3, 3, 4, 4, 12};

        int newNumsLength = (new Solution2()).removeDuplicates(arr);
        System.out.println(newNumsLength);

        for (int i = 0; i < newNumsLength; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
