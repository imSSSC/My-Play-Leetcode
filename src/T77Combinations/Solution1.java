package T77Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snake
 * @date 2020/6/21 22:49
 */

// 77. 组合
// https://leetcode-cn.com/problems/combinations/
//
// 时间复杂度: O(len(p) + len(s))
// 空间复杂度: O(1)
// 回溯
public class Solution1 {
    List<List<Integer>> res = new ArrayList<>();

    void generateCombinations(int n, int k, int start, List<Integer> c) {

        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }

//        for (int i = start; i <= n; i++) {
//            c.add(i);
//            generateCombinations(n, k, i + 1, c);
//            c.remove(c.size() - 1);
//        }

        // 剪枝优化
        // 还有 k -c.size()个空位，所以[i...n]中至少要有k-c.size()个元素
        // i最多为 n -(k-c.size()) + 1
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.add(i);
            generateCombinations(n, k, i + 1, c);
            c.remove(c.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n)
            return res;
        List<Integer> c = new ArrayList<>();
        generateCombinations(n, k, 1, c);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().combine(4, 2));
    }
}
