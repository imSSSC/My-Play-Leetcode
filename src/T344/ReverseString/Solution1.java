package T344.ReverseString;

// 344. 反转字符串
// https://leetcode-cn.com/problems/reverse-string/
//
// 对撞指针
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {
    public void reverseString(char[] s) {

        int l = 0, r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l++] = s[r];
            s[r--] = t;
        }
    }

    private static void printArr(char[] nums) {
        for (char num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new Solution1().reverseString(s);
        printArr(s);
    }
}
