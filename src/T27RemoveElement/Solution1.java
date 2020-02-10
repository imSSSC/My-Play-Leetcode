package T27RemoveElement;

// 27. Remove Element
// https://leetcode-cn.com/problems/remove-element/
//
// 原地(in place)解决该问题
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 标签：拷贝覆盖
// 这种思路在移除元素较多时更适合使用，最极端的情况是全部元素都需要移除，遍历一遍结束即可
public class Solution1 {
    public int removeElement(int[] nums, int val) {

        int i = 0;// i为慢指针,指的是非val的个数

        // 遍历数组
        // 当 nums[j]与给定的值相等时，递增 j 以跳过该元素。
        // 当 nums[j] != val，我们就复制 nums[j] 到 nums[i] 并同时递增两个索引
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j]; // i++,先执行,后++ 不影响本次程序, 影响之后的程序
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        int newNumsLength = (new Solution1()).removeElement(arr, 0);
        System.out.println("newNumsLength: " + newNumsLength);

        for (int i = 0; i < newNumsLength; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
