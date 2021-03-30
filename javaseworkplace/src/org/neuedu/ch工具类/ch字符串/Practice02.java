package org.neuedu.ch工具类.ch字符串;

public class Practice02 {
    /**
     * 返回 str 中出现过多少次 e
     * @param str 字符串
     * @return e 出现的次数
     */
    public int getCounts(String str) {
        char[] arr = str.toCharArray();
        int count = 0;
        for (char c : arr) {
            if (c == 'e') {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Practice02 p = new Practice02();
        int counts = p.getCounts("eaebecede");
        System.out.println(counts);
    }
}
