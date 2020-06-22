package T455AssignCookies;

import java.util.Arrays;

// 455. 分发饼干
// https://leetcode-cn.com/problems/assign-cookies/
//
// 时间复杂度: O(?)
// 空间复杂度: O(?)
// 贪心算法
public class Solution1 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int si = s.length - 1, gi = g.length - 1, res = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                gi--;
                si--;
            } else {
                gi--;
            }
        }
        return res;
    }
}
