package learn.algorithm.list;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName Test
 * @Author wwl
 * @Date 2021/8/13 20:45
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        int t = Integer.parseInt(s.substring(s.length() - 1, s.length()));
        String[] a = s.substring(1, s.length() - 3).split(",");

        int count = 0;
        for(int i = 0 ; i < a.length ; i++){
            for (int j = i ;j < a.length ; j++){
                int i1 = Integer.parseInt(a[i]);
                int j1 = Integer.parseInt(a[j]);
                if((i1 ^j1) == t){
                    ++count;
                }
            }
        }
        System.out.println(count);
    }
}
