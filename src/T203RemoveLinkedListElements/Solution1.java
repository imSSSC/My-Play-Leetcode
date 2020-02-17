package T203RemoveLinkedListElements;

/**
 * @auther: snake
 * @date: 2020/2/17 21:07
 */

// 203. 移除链表元素
// https://leetcode-cn.com/problems/remove-linked-list-elements/description/
// 不使用虚拟头结点
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        // head之后节点,将当前节点指向 next.next节点,就把next去除掉了
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.next.val == val)
                curNode.next = curNode.next.next;
            else
                curNode = curNode.next;
        }

        // 需要对头节点进行特殊处理
        if (head.val == val) {
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        ListNode head = new ListNode(arr);
        System.out.println(head);

        (new Solution1()).removeElements(head, val);
        System.out.println(head);
    }
}
