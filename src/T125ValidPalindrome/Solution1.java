package T125ValidPalindrome;

// 125. 验证回文串
// https://leetcode-cn.com/problems/valid-palindrome/
//
// 时间复杂度 : O(n)。
// 空间复杂度 : O(1)。
// 指针碰撞
public class Solution1 {
    public boolean isPalindrome(String s) {

        int l = 0, r = s.length() - 1;
        while (l < r) {
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++; r--;
        }
        return true;
    }

    // 自己实现
    private boolean isLetterOrDigit(Character c) {

        if (('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
            return true;
        }

        return false;
    }

    // 自己实现
    private Character toLowerCase(Character c) {
        if ('A' <= c && c >= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Solution1().isPalindrome(s));
    }
}
