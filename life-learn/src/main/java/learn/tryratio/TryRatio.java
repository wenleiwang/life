package learn.tryratio;

/**  97 604   94 318
 * @author WangWenLei
 * @DATE: 2021/6/8
 **/
public class TryRatio {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        for(int i = 0 ; i < 10000000; i++){
//            try{
//                throw new Exception();
//            } catch (Exception e) {
//                System.out.println(i);
//            }
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("使用时间：" + (end - begin));
    }
}
