package learn.note.algorithm.daily;

/**
 * LeetCode 639
 * @ClassName D20210927
 * @Author wwl
 * @Date 2021/9/27 22:26
 * @Version 1.0
 **/
public class D20210927 {
    public static void main(String[] args) {

    }

    public int numDecodings(String s) {
        int len = s.length();
        int f1 = 0;
        int fa = 1;
        int fb = 0;
        for(int i = 0 ; i <= len ; i++){
            f1 = fa * getA(s.charAt(i - 1));
            if(i > 1){
                f1 = (f1 + fb * getB(s.charAt(i - 2 ), s.charAt(i - 1))) % 1000000007;
            }
            fb = fa;
            fa = f1;
        }
        return f1;
    }

    private int getB(char ch0, char ch1) {
        if(ch0 == '*' && ch1 == '*'){
            return 15;
        }
        if(ch0 == '*'){
            if(ch1 > '6') return  1;
            else return  2;
        }
        if(ch1 == '*'){
            if(ch0 == '1') return 9;
            else if (ch0 == '2') return 6;
            else return 0;
        }
        return (ch0 != '0' && (((ch0 - '0') * 10 + (ch1 - '0')) <= 26)) ? 1 : 0;
    }

    private int getA(char ch) {
        if(ch == '*'){
            return 9;
        }
        if(ch == '0'){
            return 0;
        }
        return 1;
    }
}
