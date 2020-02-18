package T83RemoveDuplicatesFromSortedList;


/**
 * @auther: snake
 * @date: 2020-02-18 11:10:07
 */

// 83. 删除排序链表中的重复元素
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {
        // cur指针
        // next指针
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().deleteDuplicates(new ListNode(new int[]{1, 1, 2, 3, 4, 5})));
    }


}
