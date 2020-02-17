package T19RemoveNthNodeFromEndOfList;

/**
 * @auther: snake
 * @date: 2020/2/17 23:45
 */

// 19. 删除链表的倒数第N个节点
// https://leetcode.com-cn/problems/remove-nth-node-from-end-of-list/description/
//
// 使用双指针, 对链表只遍历了一遍
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        for (ListNode cur = dummyHead.next; cur != null; cur = cur.next) {
            length++;
        }

        int k = length - n;
        assert k >= 0;
        ListNode cur = dummyHead;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution1()).removeNthFromEnd(head, 2);
        System.out.println(head);
    }
}
