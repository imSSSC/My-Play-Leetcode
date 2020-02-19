package T147InsertionSortList;

/**
 * @auther: snake
 * @date: 2020-02-19 13:51:54
 */

// 147. 对链表进行插入排序
// https://leetcode-cn.com/problems/insertion-sort-list/
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)
public class Solution1 {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);

        ListNode cur = head;
        ListNode tail = dummyHead;
        ListNode pre = dummyHead;
        while (cur != null) {

                if (tail.val < cur.val) { // tail小于当前cur. cur作为新的tail.
                    tail.next = cur;
                    tail = cur;
                    cur = cur.next;
                } else {
                    ListNode next = cur.next;
                    tail.next = next; // 处理了,tail.next更新为cur的下个元素(如果不写这一步,死循环. tail -> cur)

                    // 插入位置
                    while (pre.next != null && pre.next.val < cur.val) {
                        pre = pre.next;
                    }
                    cur.next = pre.next; // cur的next 为 pre.next 相当于 cur -> preNext
                    pre.next = cur;// pre的next 为 cur;  相当于 pre -> cur -> preNext
                    pre = dummyHead;

                    cur = next;
                }

        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 5, 5, 7, 8, 9, 0, 2, 3, 6, 4, 5};
        System.out.println(new Solution1().insertionSortList(new ListNode(arr)));
    }


}
