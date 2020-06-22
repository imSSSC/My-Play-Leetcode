package T51NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 51. N皇后
// https://leetcode-cn.com/problems/n-queens/
//
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
// 回溯
public class Solution1 {

    List<List<String>> res = new ArrayList<>();
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;

    void putQueens(int n, int index, LinkedList<Integer> row) {

        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            // i x轴   index y轴
            // dia1表示对角线1 第几条： x + y
            // dia2表示另外一条对角线2  第几条：x-y+n-1
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueens(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }

    }

    private List<String> generateBoard(int n, LinkedList<Integer> row) {
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        LinkedList<Integer> row = new LinkedList<>();
        putQueens(n, 0, row);
        return res;
    }
}
