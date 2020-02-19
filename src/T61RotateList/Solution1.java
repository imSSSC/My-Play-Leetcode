package T61RotateList;


/**
 * @auther: snake
 * @date: 2020/2/19 21:11
 */

// 61. 旋转链表
// https://leetcode-cn.com/problems/rotate-list/
//
// 使用双指针, 对链表只遍历了一遍
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 双指针之滑动窗口
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < k && q.next != null; i++) {
            q = q.next;
        }
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }

        q.next = head;
        ListNode result = p.next;
        p.next = null;

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(new Solution1().rotateRight(new ListNode(arr), 0));
    }
}
