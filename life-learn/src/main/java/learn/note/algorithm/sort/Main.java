package learn.note.algorithm.sort;

import java.util.Arrays;

/**
 * @author WangWenLei
 * @DATE: 2021/5/25
 **/
public class Main {
    public static void main(String[] args) {
        Integer [] a = new Integer[] {123,213,452,42,412,532,6,427643,14,24,1,24,72,5132,41,2,624,576,1245,125,3,64,27,2,51,365,324,735,83,213,5,1365,123,327,24,51,2};
//        ChooseSort sort = new ChooseSort();
//        Sort sort = new InsertSort();
        Sort sort = new ShellSort();
        sort.sort(a);
        Arrays.stream(a).forEach(item -> System.out.println(item));
    }
}
