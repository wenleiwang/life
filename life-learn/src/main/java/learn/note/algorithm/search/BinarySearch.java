package learn.note.algorithm.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 二分查找
 * @author WangWenLei
 * @DATE: 2021/5/20
 **/
public class BinarySearch {
    public static int rank(int key, int [] a,int depth){
        return rank(key,a,0,a.length - 1,depth);
    }
    public static int rank ( int key, int [] a, int lo, int hi,int depth){
        if(lo > hi){
            return -1;
        }
        for(int i = 0 ; i < depth ; i ++){
            System.out.print(" ");
        }
        System.out.println(lo);
        for(int i = 0 ; i < depth ; i ++){
            System.out.print(" ");
        }
        System.out.println(hi);
        int mid = lo + (hi - lo) / 2;
        if(key < a[mid]){
            return rank(key,a,lo,mid -1,depth + 1);
        }else if(key > a[mid]){
            return rank(key,a,mid + 1, hi,depth + 1);
        }else{
            System.out.print(mid);
            return mid;
        }
    }

    public static void main(String[] args) {

        int [] whitelis = new int[]{23,1231,535,123,123,6,47,123,2143,64,875,234,245,754,24,1,74,2,421,3464,3245,12,4,6,457,2,42,36,34,634,4,234,2,6532,6};

        Arrays.sort(whitelis);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            if(rank(i,whitelis,0) >= 0){
                System.out.println(i);
            }
        }
    }
}
