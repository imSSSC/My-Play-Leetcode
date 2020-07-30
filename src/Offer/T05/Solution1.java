package Offer.T05;

// 剑指 Offer 05. 替换空格
// https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/

// 时间复杂度：?
// 空间复杂度：?
public class Solution1 {

    public String replaceSpace(String s) {
        if (s.length() == 0) return s;
        String append = "%20";
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char aChar : chars) {
            if (aChar == ' ')
                stringBuffer.append(append);
            else
                stringBuffer.append(aChar);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(new Solution1().replaceSpace(s));
    }
}
