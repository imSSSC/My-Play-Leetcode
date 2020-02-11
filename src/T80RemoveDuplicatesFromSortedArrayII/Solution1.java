package T80RemoveDuplicatesFromSortedArrayII;

// 80. Remove Duplicates from Sorted Array II
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
//
// 原地(in place)解决该问题
// 时间复杂度: O(n)(当元素都一样,时间复杂度为0(n^2))
// 空间复杂度: O(1)
// 方法一：删除多余的重复项
public class Solution1 {

    // 由于输入数组已经排序，所以重复项都显示在旁边。题目要求我们不使用额外的空间，在原地修改数组，而最简单的方法就是删除多余的重复项。
    // 对于数组中的每个数字，若出现 2 个以上的重复项，就将多余的重复项从数组列表中删除。

    // 将数组的重复项,从数组列表中删除(实际就是从该索引开始遍历,将后一个元素复制到当前.)
    private int[] remElement(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        return arr;
    }

    // 遍历数组,每次i++
    // 当nums[i] != nums[i-1] ,也就是前后两个元素不一样 count=1;
    // 当nums[i]等于nums[i-1],count+1,当count>2,将数组的重复项,从数组列表中删除(remElement),length-1,维护i--;
    public int removeDuplicates(int[] nums) {
        //i为当前的索引,count为当前元素出现的次数,length为数组的长度.
        int i = 1, count = 1, length = nums.length;
        while (i < length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    remElement(nums, i);
                    i--;
                    length--;
                }
            } else {
                count = 1;
            }
            i++;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 1, 1, 3, 3, 4, 4, 12};

        int newNumsLength = (new Solution1()).removeDuplicates(arr);
        System.out.println(newNumsLength);

        for (int i = 0; i < newNumsLength; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
