package T25ReverseNodesInkGroup;

/**
 * @auther: snake
 * @date: 2020-02-19 09:00:40
 */

// 25. K 个一组翻转链表
// https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 一段翻转需要4个辅助指针,pre,start,end,next.(注意是结束点,平移点)
// pre作用是: 连接翻转之后的start. start: 翻转开始. end: 控制循环,以及每次翻转长度. next: 每次翻转之后,被连接.
public class Solution1 {

    public ListNode reverseKGroup(ListNode head, int k) {

        // 设置4个节点
        // pre 前置节点
        // start 开始节点
        // end 结束节点
        // next 后置节点

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode end = dummyHead;
        while (end.next != null) {
            // 获取 新的end
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = revers(start);// 将翻转之后的头,和pre相连

            start.next = next;// 老的start翻转之后,变成尾,要与next 相连接
            pre = start; // pre指针移到下个start,之前的位置.也就是本次周期的start位置.

            end = pre;// 将end指针,移位到pre.重新开始
        }

        return dummyHead.next;
    }

    private ListNode revers(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution1()).reverseKGroup(head, 3);
        System.out.println(head);
    }
}
