package learn.designpatterns.strategy.v4;

/**
 * 体重策略
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class PersonWeightStrategy implements Comparable<Person>{
    @Override
    public int compareTo(Person[] data, int c0, int c1) {
        if(data[c0].weight > data[c1].weight){
            return 1;
        }else if(data[c0].weight < data[c1].weight){
            return -1;
        }else {
            return 0;
        }
    }
}
