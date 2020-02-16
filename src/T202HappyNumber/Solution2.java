package T202HappyNumber;

import java.util.HashSet;

// 202. 快乐数
// https://leetcode-cn.com/problems/happy-number/
//
// 时间复杂度: O(?)
// 空间复杂度: O(?)
// 快慢指针
public class Solution2 {
    public boolean isHappy(int n) {

    // “快指针”每次走两步，“慢指针”每次走一步，当二者相等时，即为一个循环周期。
        int slow = n, fast = n;
        do{
            slow = getNext(slow);
//            System.out.println("slow  :" + slow);
            fast = getNext(fast);
//            System.out.println("fast1  :" + fast);
            fast = getNext(fast);
//            System.out.println("fast2  :" + fast);
        }while(slow != fast);

        return slow == 1;
    }

    private int getNext(int temp) {

        int result = 0;
        while (temp > 0) { // 直到每位数都是被运算完成

            result += Math.pow(temp % 10, 2); // 求个位数的平方, 比如 19%10=9, 111%10 =1
            temp = temp / 10; // 去除各位数
        }

        return result;
    }


    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {
        int n = 17;
        printBool((new Solution2()).isHappy(n));
    }
}
