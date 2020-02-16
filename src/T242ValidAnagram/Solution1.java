package T242ValidAnagram;

import java.util.HashMap;
import java.util.HashSet;

// 242. 有效的字母异位词
// https://leetcode-cn.com/problems/valid-anagram/
//
// 时间复杂度: O(n)O(n)
// 空间复杂度: O(1)
public class Solution1 {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] recode = new int[26];
        for (char c : s.toCharArray()) {
            recode[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            recode[c - 'a']--;
            if (recode[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        printBool((new Solution1()).isAnagram(s, t));
    }
}
