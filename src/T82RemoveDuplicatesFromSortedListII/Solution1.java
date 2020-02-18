package T82RemoveDuplicatesFromSortedListII;


/**
 * @auther: snake
 * @date: 2020-02-18 11:10:07
 */

// 82. 删除排序链表中的重复元素 II
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 迭代+虚拟头节点
public class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().deleteDuplicates(new ListNode(new int[]{ 1, 2, 2, 3, 3, 4, 5})));
    }


}
