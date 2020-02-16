package T49GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @auther: snake
 * @date: 2020/2/17 01:17
 */
// 49. 字母异位词分组
// https://leetcode-cn.com/problems/group-anagrams/
//
// 时间复杂度: O(?)
// 空间复杂度: O(?)
// 哈希表
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> record = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (record.containsKey(key)) {
                record.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                record.put(key, list);
            }
        }

        return new ArrayList<>(record.values());
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution1().groupAnagrams(strs));
    }
}