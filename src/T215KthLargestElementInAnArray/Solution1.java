package T215KthLargestElementInAnArray;

// 215. 数组中的第K个最大元素
// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/
//
// 快速排序的思想
// 时间复杂度 : 平均情况 {O}(N)，最坏情况 {O}(N^2)
// 空间复杂度 : {O}(1)
public class Solution1 {

    public int findKthLargest(int[] nums, int k) {

        int size = nums.length;

        // size -k 也就是升序之后,我们要找的那个索引位置.
        return sort(nums, 0, size - 1, size - k);
    }

    // 从[left,right]之间查询,找size-k索引的元素.
    public int sort(int[] nums, int left, int right, int k_smallest) {

        if (left == right) // 如果只有一个元素
            return nums[left];  // 返回这个元素

        int pivot_index = partition(nums, left, right);

        if (k_smallest == pivot_index) // pivot_index = size-k 返回
            return nums[k_smallest];
        else if (k_smallest < pivot_index) // pivot_index > size-k 去左边找
            return sort(nums, left, pivot_index - 1, k_smallest);
        return sort(nums, pivot_index + 1, right, k_smallest); // pivot_index < size-k 去右边找
    }

    public int partition(int[] nums, int left, int right) {

        // 选择一个随机分割点
        int pivot_index = (int) (Math.random() * (right - left) + left);
        int pivot = nums[pivot_index];
        // 移动到最左边
        swap(nums, pivot_index, left);

        int lt = left;

        // 2. 比pivot小的元素移到左边
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, lt, i);
            }
        }

        // 3. 将left和lt交换位置.
        swap(nums, lt, left);

        return lt;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new Solution1().findKthLargest(arr, k));
    }
}
