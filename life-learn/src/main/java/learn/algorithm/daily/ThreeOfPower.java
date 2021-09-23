package learn.algorithm.daily;

/**
 * 3的幂
 * @author WangWenLei
 * @DATE: 2021/9/23
 **/
public class ThreeOfPower {
    public static boolean isPowerOfThree(int n) {
        int i = n;
        if (i <= 0) return  false;
        while (i > 1) {
            if((i % 3) == 0){
                i = i / 3;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(-3));
    }
}
