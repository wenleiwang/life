package ink.poesy.life.service.learn.ThreadLearn;

import ink.poesy.life.service.learn.AOP.Animal;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author WangWenLei
 * @DATE: 2020/10/26
 **/
public class Test1 {
    public int loadTheArk(Collection<Animal> cnadidates){
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        //Animals被限制在方法中，不要让他们溢出
//        animals = new TreeSet<Animal>(new SpeciesGenderComparator());
        return 0;
    }
}
