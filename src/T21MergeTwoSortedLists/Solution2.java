package T21MergeTwoSortedLists;


/**
 * @auther: snake
 * @date: 2020-02-18 17:45:08
 */

// 21. 合并两个有序链表
// https://leetcode-cn.com/problems/merge-two-sorted-lists/
// 时间复杂度: O(n+m)
// 空间复杂度: O(n+m)
// 递归
public class Solution2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().mergeTwoLists(new ListNode(new int[]{1, 2, 2, 3, 3, 4, 5}), new ListNode(new int[]{1, 2, 2, 3, 3, 4, 5})));
    }


}
