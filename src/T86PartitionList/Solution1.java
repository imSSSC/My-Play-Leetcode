package T86PartitionList;


/**
 * @auther: snake
 * @date: 2020-02-18 13:24:25
 */

// 86. 分隔链表
// https://leetcode-cn.com/problems/partition-list/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 双指针,分割链表,再相连
public class Solution1 {

    public ListNode partition(ListNode head, int x) {

        // 两个虚拟投节点, 用于 小于链表 和 大于链表
        ListNode smallDummyHead = new ListNode(0);
        ListNode bigDummyHead = new ListNode(0);

        ListNode small = smallDummyHead;
        ListNode big = bigDummyHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }

        // 小于链表和大于链表相结合 (相当于处理了 小于链表的末尾节点,和大于链表的虚拟头节点)
        small.next = bigDummyHead.next;
        // 处理大于链表的末尾节点
        big.next = null;

        // 返回虚拟头节点的下个节点 (相当于处理 小于链表的头节点)
        return smallDummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().partition(new ListNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
    }


}
