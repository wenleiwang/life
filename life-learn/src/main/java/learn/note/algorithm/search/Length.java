package learn.note.algorithm.search;

import java.util.*;

/**
 * @author WangWenLei
 * @DATE: 2021/8/7
 **/
public class Length {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map  = new LinkedHashMap<>();
        for(int i = 0 ; i < 3 ; i++){
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            map.put(Integer.parseInt(s1[0]),Integer.parseInt(s1[1]));
        }
        for (Map.Entry<Integer,Integer> m : map.entrySet()) {
            System.out.println(test1(m.getKey(),m.getValue()));
        }
    }

    public static int test1 (int N,int L){
        if(N == 0 || L == 0 ) return 0;
        int count = 0;
        for (int i = 1; i<=L ; i++){
            count = (int ) (Math.pow(N,i) + count) ;
        }
        return count % 1000000007;
    }
}
