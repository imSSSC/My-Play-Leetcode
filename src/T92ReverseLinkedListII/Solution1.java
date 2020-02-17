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

//    public ListNode reverseBetween(ListNode head, int m, int n) {
//
//        ListNode node = head;
//
//        for (int i = 1; i < m; i++) {
//            node = node.next;
//        }
//
//        ListNode pre = null;
//        ListNode next = null;
//        ListNode cur = node.next;
//        for (int i = m; i <= n; i++) {
//            // 将下个节点指针,移动一位(获取下个节点指针)
//            next = cur.next;
//            // 指针方向改变
//            cur.next = pre;
//            // 将前节点指针,指向当前节点 移动一位
//            pre = cur;
//            // 将当前节点指针,指向下个节点 移动一位
//            cur = next;
//        }
//
//        //将反转的起点的next指向next。
//        node.next.next = next;
//        //需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
//        node.next = pre;
//
//        return head;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(new Solution1().reverseBetween(new ListNode(arr), 2, 4));
//    }


}
