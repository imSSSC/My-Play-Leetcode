package T76MinimumWindowSubstring;

// 76. 最小覆盖子串
// https://leetcode-cn.com/problems/minimum-window-substring/
//
// 滑动窗口
// 时间复杂度: O(len(p) + len(s))
// 空间复杂度: O(1)
public class Solution1 {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0 || t.length() > s.length()) return "";

        int[] tFreq = new int[256]; // tFreq 为t对应每个字符的频率数组
        int[] sFreq = new int[256]; // sFreq 为s滑动窗口对应每个字符的频率数组

        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        int sCnt = 0;
        int minLength = s.length() + 1;
        int startIndex = -1;

        int l = 0, r = -1; // 滑动窗口为chars[l,r]
        while (l < s.length()) {

            if (r + 1 < s.length() && sCnt < t.length()) {

                sFreq[s.charAt(r + 1)]++;
                if (sFreq[s.charAt(r + 1)] <= tFreq[s.charAt(r + 1)]) {
                    sCnt++;
                }
                r++;

            } else {

                if (sCnt == t.length() && r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    startIndex = l;
                }

                sFreq[s.charAt(l)]--;
                if (sFreq[s.charAt(l)] < tFreq[s.charAt(l)]) {
                    sCnt--;
                }
                l++;
            }
        }

        if (startIndex != -1) {
            return s.substring(startIndex, startIndex + minLength);
        }

        return "";
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).minWindow("ADOBECODEBANC", "ABC"));
    }
}
