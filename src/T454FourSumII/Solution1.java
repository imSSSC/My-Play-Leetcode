package T454FourSumII;

import java.util.HashMap;

// 454. 4Sum II
// https://leetcode-cn.com/problems/4sum-ii/description/
//
// 时间复杂度: O(n^2)
// 空间复杂度: O(n^2)
public class Solution1 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> recodeMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                if (recodeMap.containsKey(sum))
                    recodeMap.put(sum, recodeMap.get(sum) + 1);
                else
                    recodeMap.put(sum, 1);
            }
        }

        int res = 0;
        for (int c : C) {
            for (int d : D) {
                if (recodeMap.containsKey(-c - d))
                    res += recodeMap.get(-c - d);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println((new Solution1()).fourSumCount(a, b, c, d));
    }
}
