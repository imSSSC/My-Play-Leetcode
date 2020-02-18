package T2AddTwoNumbers;


/**
 * @auther: snake
 * @date: 2020-02-18 11:10:07
 */

// 2. 两数相加
// https://leetcode-cn.com/problems/add-two-numbers/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 虚拟节点
public class Solution1 {
    // 342 + 465 = 807
    // (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // 7 -> 0 -> 8

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        int t3 = 0;
        while (l1 != null || l2 != null) {

            int t1 = 0, t2 = 0;
            if (l1 != null) {
                t1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t2 = l2.val;
                l2 = l2.next;
            }

            int sum = t1 + t2 + t3;
            t3 = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }

        if (t3 > 0)
            node.next = new ListNode(t3);

        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().addTwoNumbers(new ListNode(5), new ListNode(5)));
    }


}
