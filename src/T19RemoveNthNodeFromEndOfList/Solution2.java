package T19RemoveNthNodeFromEndOfList;

/**
 * @auther: snake
 * @date: 2020/2/17 23:23
 */

// 19. 删除链表的倒数第N个节点
// https://leetcode.com-cn/problems/remove-nth-node-from-end-of-list/description/
//
// 使用双指针, 对链表只遍历了一遍
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 设置虚拟头节点,方便head和其他节点相同处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 找到要删除的上个节点
        // 那个节点和最后一个节点的距离为n
        // 双指针滑动到最后.
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        // 当q的next为null说明到低了
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution2()).removeNthFromEnd(head, 2);
        System.out.println(head);
    }

}
