package T438FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

// 438. 找到字符串中所有字母异位词
// https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
//
// 滑动窗口
// 时间复杂度: O(len(p) + len(s))
// 空间复杂度: O(1)
public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) return result;

        int[] pFreq = new int[26]; // pFreq 为p对应每个字符的频率数组
        int[] sFreq = new int[26]; // sFreq 为s滑动窗口对应每个字符的频率数组

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        int l = 0, r = -1; // 滑动窗口为chars[l,r]
        while (r + 1 < s.length()) {

            // 滑动窗口,控制窗口长度
            sFreq[s.charAt(++r) - 'a']++;
            if (r - l + 1 > p.length())
                sFreq[s.charAt(l++) - 'a']--;

            // 窗口和p串长度相等,比较两个数组
            if (r - l + 1 == p.length() && isSame(sFreq, pFreq)) {
                result.add(l);
            }
        }

        return result;
    }

    public boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i]) return false;
        return true;
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).findAnagrams("abcabcbb", "abc"));
        System.out.println((new Solution1()).findAnagrams("bbbbb", "b"));
        System.out.println((new Solution1()).findAnagrams("pwwkew", "ew"));
    }
}
