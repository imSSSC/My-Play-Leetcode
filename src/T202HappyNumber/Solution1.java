package T202HappyNumber;

import java.util.HashSet;

// 202. 快乐数
// https://leetcode-cn.com/problems/happy-number/
//
// 时间复杂度: O(nlogk)
// 空间复杂度: O(k)
// 查找表
public class Solution1 {
    public boolean isHappy(int n) {

        int temp = n;
        HashSet<Integer> record = new HashSet<>();
        record.add(n);
        while (true) {
            temp = getNext(temp);
            if (temp == 1) {
                return true;
            } else if (record.contains(temp)) {
                return false;
            }
            record.add(temp);
        }
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
        int n = 19;
        printBool((new Solution1()).isHappy(n));
    }
}
