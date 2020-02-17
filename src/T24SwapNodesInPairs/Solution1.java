package T24SwapNodesInPairs;

/**
 * @auther: snake
 * @date: 2020/2/17 22:16
 */

// 24. 两两交换链表中的节点
// https://leetcode-cn.com/problems/swap-nodes-in-pairs/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 设置4个指针
        // p指针,指得是需要旋转的前节点
        // node1,指的是p的下个指针
        // node2,指的是p的下下个指针
        // next,指的是p的下下下个指针
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {

            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2; // p的下个节点,变为node2.

            p = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution1()).swapPairs(head);
        System.out.println(head);
    }
}
