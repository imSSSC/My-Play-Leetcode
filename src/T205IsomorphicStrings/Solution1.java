package T205IsomorphicStrings;

import java.util.HashMap;

// 205. 同构字符串
// https://leetcode-cn.com/problems/isomorphic-strings/
//
// 时间复杂度: O(?)
// 空间复杂度: O(?)
// 查找表
public class Solution1 {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> record = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!record.containsKey(s.charAt(i))) {
                if (record.containsValue(t.charAt(i))) {
                    return false;
                }
                record.put(s.charAt(i), t.charAt(i));
            } else {
                if (!record.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {
        String s = "paper", t = "bbbbb";
        printBool((new Solution1()).isIsomorphic(s, t));
    }
}
