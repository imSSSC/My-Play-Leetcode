package T27RemoveElement;

// 27. Remove Element
// https://leetcode-cn.com/problems/remove-element/
//
// 原地(in place)解决该问题
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 标签：交换移除
// 这种思路在移除元素较少时更适合使用，最极端的情况是没有元素需要移除，遍历一遍结束即可
public class Solution2 {
    public int removeElement(int[] nums, int val) {

        int i = 0;// i为当前的位置
        int n = nums.length;// n为新数组的大小

        // 遍历数组
        // 当我们遇到 nums[i] = val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素。这实际上使数组的大小减少了 1。
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        int newNumsLength = (new Solution2()).removeElement(arr, 0);
        System.out.println("newNumsLength: " + newNumsLength);

        for (int i = 0; i < newNumsLength; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
