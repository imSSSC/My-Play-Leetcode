package T203RemoveLinkedListElements;

/**
 * @auther: snake
 * @date: 2020/2/17 21:07
 */

// 203. 移除链表元素
// https://leetcode-cn.com/problems/remove-linked-list-elements/description/
// 递归
// 时间复杂度: O(n)
// 空间复杂度: O(k) k为递归深度
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        // 下个节点的head
        head.next = removeElements(head.next, val);

        if (head.val == val)
            return head.next;
        else
            return head;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        ListNode head = new ListNode(arr);
        System.out.println(head);

        (new Solution3()).removeElements(head, val);
        System.out.println(head);
    }
}
