package learn.note.algorithm.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author WangWenLei
 * @DATE: 2021/8/7
 **/
public class Performance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> dataList = new ArrayList<>();
        for(int i = 0 ; i < 3 ; i++){
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            Student stu = new Student();
            stu.setName(s1[0]);
            stu.setCh(Integer.parseInt(s1[1]));
            stu.setEn(Integer.parseInt(s1[2]));
            stu.setM(Integer.parseInt(s1[3]));
            stu.setSum(Integer.parseInt(s1[1]) + Integer.parseInt(s1[2]) + Integer.parseInt(s1[3]));
            dataList.add(stu);
        }
        // 已经排好
        List<Student> collect = dataList.stream().sorted(Comparator.comparing(Student::getSum, Comparator.nullsFirst(Integer::compareTo))
                .thenComparing(Student::getCh, Comparator.nullsFirst(Comparator.naturalOrder()))
                .thenComparing(Student::getEn, Comparator.nullsFirst(Comparator.naturalOrder()))
                .thenComparing(Student::getM, Comparator.nullsFirst(Comparator.naturalOrder()))
                .thenComparing(Student::getName, Comparator.nullsFirst(Comparator.naturalOrder()))
                .reversed())
                .collect(Collectors.toList());

        System.out.println(collect.toString());

    }


    static class Student{
        private String name ;
        private Integer ch;
        private Integer en;
        private Integer m;
        private Integer sum;

        public int add(){
            return this.ch + this.en + this.m;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCh() {
            return ch;
        }

        public void setCh(Integer ch) {
            this.ch = ch;
        }

        public Integer getEn() {
            return en;
        }

        public void setEn(Integer en) {
            this.en = en;
        }

        public Integer getM() {
            return m;
        }

        public void setM(Integer m) {
            this.m = m;
        }

        public Integer getSum() {
            return sum;
        }

        public void setSum(Integer sum) {
            this.sum = sum;
        }
    }
}
