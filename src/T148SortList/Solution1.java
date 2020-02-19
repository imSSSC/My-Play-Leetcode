package T148SortList;

/**
 * @auther: snake
 * @date: 2020-02-19 15:23:15
 */

// 148. 排序链表
// https://leetcode-cn.com/problems/sort-list/
// 时间复杂度: O(n log n)
// 空间复杂度: O(1)
// 链表归并排序(从下往上归并.)
public class Solution1 {

    public ListNode sortList(ListNode head) {
        // todo
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 5, 5, 7, 8, 9, 0, 2, 3, 6, 4, 5};
        System.out.println(new Solution1().sortList(new ListNode(arr)));
    }

}
