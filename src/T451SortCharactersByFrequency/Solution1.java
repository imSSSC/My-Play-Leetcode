package T451SortCharactersByFrequency;

import java.util.*;
import java.util.stream.Collectors;

// 451. 根据字符出现频率排序
// https://leetcode-cn.com/problems/sort-characters-by-frequency/
//
// 时间复杂度: O(?)
// 空间复杂度: O(?)
// 查找表
public class Solution1 {
    public String frequencySort(String s) {

        HashMap<Character, Integer> record = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (record.containsKey(s.charAt(i))) {
                record.put(s.charAt(i), record.get(s.charAt(i)) + 1);
            } else {
                record.put(s.charAt(i), 1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        record.entrySet().stream().sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(entry -> {
            for (int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(entry.getKey());
            }
        });

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(((new Solution1()).frequencySort(s)));
    }
}
