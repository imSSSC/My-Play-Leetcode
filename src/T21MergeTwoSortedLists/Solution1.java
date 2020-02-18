package T21MergeTwoSortedLists;


/**
 * @auther: snake
 * @date: 2020-02-18 17:45:08
 */

// 21. 合并两个有序链表
// https://leetcode-cn.com/problems/merge-two-sorted-lists/
// 时间复杂度: O(n+m)
// 空间复杂度: O(1)
// 迭代+虚拟头节点
public class Solution1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                node.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                node.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
            }
            node = node.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().mergeTwoLists(new ListNode(new int[]{1, 2, 2, 3, 3, 4, 5}), new ListNode(new int[]{1, 2, 2, 3, 3, 4, 5})));
    }


}
