package learn.algorithm.recursion;

/**
 * @author WangWenLei
 * @DATE: 2021/5/20
 **/
public class Binomial {
    public static double binomial(int N ,int k , double p){
        if(N == 0 && k== 0) return  1.0;
        if(N < 0 || k <0) return 0.0;
        return (1.0 - p) * binomial(N-1,k,p) + p*binomial(N-1 ,k-1,p);
    }

    public static void main(String[] args) {
        Object aa = new Integer(1);
        Object bb = 2;
        System.out.println("1".equals(aa));
        System.out.println("2".equals(bb));
    }
}
