package learn.note.algorithm.list;

/**
 * @ClassName Test1
 * @Author wwl
 * @Date 2021/8/13 21:02
 * @Version 1.0
 **/
public class Test1 {
    public static void main(String[] args) {

    }

    private static void store(char[] data,int low,int high) {
        if(low > high){
            return;
        }
        int i = low;
        int j = high;
        int soup = data[i];
        while (i < j){
            while(i < j && data[j] > soup){
                j--;
            }
            if(i < j){
                data[i] = data[j];
                i++;
            }
            while(i < j && data[i] < soup){
                i++;
            }
            if(i < j){
                data[j] = data[i];
                j--;
            }
        }
        store(data,low,--i);
        store(data,++j,high);
    }
}
