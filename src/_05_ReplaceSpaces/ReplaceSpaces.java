package _05_ReplaceSpaces;

/**
 * @author huwei
 * @date 2020/5/31 15:34
 */
public class ReplaceSpaces {

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    /**
     * 实际上在Java中使用StringBuilder就可以轻松解决该题
     * 但是为了领悟算法本质，用Java模拟C/C++方式解决该题
     */
    public static String replaceSpace(String s) {
        if( s == null || s.length() < 1 )
            return "";
        //将String类型的字符串复制到char数组中，并预留好空间用于替换操作
        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == ' ' )
                spaceCount++;
        }
        char[] str = new char[s.length() + 2 * spaceCount];
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.charAt(i);
        }
        //从数组char末尾移动
        int pre_end = s.length() - 1;
        int cur_end = str.length - 1;
        while( pre_end >= 0 ){
            if( str[pre_end] == ' ' ){
                str[cur_end--] = '0';
                str[cur_end--] = '2';
                str[cur_end--] = '%';
                pre_end--;
            } else {
                str[cur_end--] = str[pre_end--];
            }
        }
        return new String(str);
    }
}
