package org.neuedu.ch工具类.ch字符串;

public class Practice03 {

    /**
     * 返回 child 在 parent 出现过多少次
     * @param parent
     * @param child
     * @return 次数
     */
    public int getCounts(String parent,String child) {
        int count = 0;
        int index = parent.indexOf(child);
        while (index != -1) {
            count++;
            parent = parent.substring(index + child.length());
            index = parent.indexOf(child);
        }
        return count;
    }

    public static void main(String[] args) {
        Practice03 p = new Practice03();
        int count = p.getCounts("要深入学习、坚决贯彻党的十九届五中全会精神，准确把握新发展阶段，深入贯彻新发展理念，加快构建新发展格局，推动‘十四五’时期高质量发展，确保全面建设社会主义现代化国家开好局、起好步", "发展");
        System.out.println(count);
    }
}
