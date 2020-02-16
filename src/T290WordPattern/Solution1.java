package T290WordPattern;

import java.util.HashMap;

// 290. 单词规律
// https://leetcode-cn.com/problems/word-pattern/
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 查找表
public class Solution1 {
    public boolean wordPattern(String pattern, String str) {

        // 判断长度是否一致
        String[] s = str.split(" ");
        if (s.length != pattern.length())
            return false;

        // 判断规则是否一致
        HashMap<Character, String> record = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!record.containsKey(pattern.charAt(i))) {// key没有映射
                if (record.containsValue(s[i])) // 但是该单词被其他key映射了.
                    return false;
                record.put(pattern.charAt(i), s[i]);// 添加到映射中
            } else {
                if (!record.get(pattern.charAt(i)).equals(s[i]))
                    return false; // 有映射,但是value和当前的不一致
            }
        }

        return true;
    }

    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {
        String str = "dog dog dog dog", pattern = "abba";
        printBool((new Solution1()).wordPattern(pattern, str));
    }
}
