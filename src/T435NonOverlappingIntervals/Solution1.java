package T435NonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

// 435. 无重叠区间
// https://leetcode-cn.com/problems/non-overlapping-intervals/
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)
// 贪心算法
public class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 按end 升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        // 交集总数
        int count = 0;
        // 排序后，第一个区间就是x
        int x_end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            // start >= end 说明没有交集不符合
            if (start >= x_end) {
                // 找到下一个选择的区间
                x_end = intervals[i][1];
            }else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().eraseOverlapIntervals(new int[][]{{1,2}}));
    }
}
