package Offer.T06;

// 剑指 Offer 06. 从尾到头打印链表
// https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

import java.util.ArrayList;
import java.util.Arrays;

// 时间复杂度：?
// 空间复杂度：?
public class Solution1 {

    public int[] reversePrint(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
            count++;
        }

        int[] ans = new int[count];
        for (int i = 0; i < count; i++) {
            ans[i] = pre.val;
            pre = pre.next;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
