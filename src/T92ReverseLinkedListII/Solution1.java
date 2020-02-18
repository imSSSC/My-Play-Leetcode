package T92ReverseLinkedListII;

/**
 * @auther: snake
 * @date: 2020/2/17 17:33
 */

// 92. 反转链表 II
// https://leetcode-cn.com/problems/reverse-linked-list-ii/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // per指针,前指针
        ListNode perPer = dummyHead;
        for (int i = 1; i < m; i++) {
            perPer = perPer.next;
        }

        // 设置3个指针
        // pre指针,前一个节点
        // cur指针,当前节点
        // next指针的是下个节点
        ListNode pre = null;
        ListNode cur = perPer.next;
        ListNode next = null;
        for (int i = m; i < n + 1; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 将反转的起点的next指向next。
        perPer.next.next = next;
        // 需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
        perPer.next = pre;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new Solution1().reverseBetween(new ListNode(arr), 1, 4));
    }


}
