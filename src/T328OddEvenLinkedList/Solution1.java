package T328OddEvenLinkedList;


/**
 * @auther: snake
 * @date: 2020-02-18 11:10:07
 */

// 328. 奇偶链表
// https://leetcode-cn.com/problems/odd-even-linked-list/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);

        ListNode odd = oddHead;
        ListNode even = evenHead;

        for (int i = 1; head != null; i++) {
            if (i % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
        }

        // 拼接两个链表
        even.next = null;
        odd.next = evenHead.next;

        return oddHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().oddEvenList(new ListNode(new int[]{1, 1, 2, 3, 4, 5})));
    }


}
