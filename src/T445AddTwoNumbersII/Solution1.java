package T445AddTwoNumbersII;


import java.util.Stack;

/**
 * @auther: snake
 * @date: 2020-02-18 11:10:07
 */

// 445. 两数相加 II
// https://leetcode-cn.com/problems/add-two-numbers-ii/
// 时间复杂度: O(n^2)
// 空间复杂度: O(n^2)
// 栈+虚拟节点
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int t3 = 0;
        ListNode head = null;
        while (!stack1.empty() || !stack2.empty()) {
            int t1 = !stack1.empty() ? stack1.pop() : 0;
            int t2 = !stack2.empty() ? stack2.pop() : 0;

            int sum = t1 + t2 + t3;
            t3 = sum / 10;

            ListNode cur = new ListNode(sum % 10);
            cur.next = head;
            head = cur;
        }

        if (t3 > 0) {
            ListNode cur = new ListNode(t3);
            cur.next = head;
            head = cur;
        }

        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().addTwoNumbers(new ListNode(5), new ListNode(5)));
    }


}
