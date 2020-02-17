package T15ThreeSum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 15. 三数之和
// https://leetcode-cn.com/problems/3sum/
//
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
// 查找表 + 排序 + 双指针
public class Solution1 {

    public List<List<Integer>> threeSum(int[] nums) {

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                counter.put(num, 1);
            }
        }

        // 排序,去重
        int[] arr = Arrays.stream(nums).sorted().distinct().toArray();

        // a. 3个相同数 都为0
        List<List<Integer>> res = new ArrayList<>();
        if (counter.get(0) != null && counter.get(0) >= 3) {
            res.add(Arrays.asList(0, 0, 0));
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                // b. 2个相同数,1个不同数
                // 2个i,1个j
                if (arr[i] * 2 + arr[j] == 0 && counter.get(arr[i]) >= 2) {
                    res.add(Arrays.asList(arr[i], arr[i], arr[j]));
                }
                // 1个i,2个j
                if (arr[i] + arr[j] * 2 == 0 && counter.get(arr[j]) >= 2) {
                    res.add(Arrays.asList(arr[i], arr[j], arr[j]));
                }

                // c. 3个不同数
                // 1个i,1个j,1个其他
                int c = -arr[i] - arr[j];
                if (c > arr[j] && counter.get(c) != null) {
                    res.add(Arrays.asList(arr[i], arr[j], c));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, -2};
        System.out.println(((new Solution1()).threeSum(nums)));
    }
}
