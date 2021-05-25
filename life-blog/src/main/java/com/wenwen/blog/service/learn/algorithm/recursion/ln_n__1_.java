package com.wenwen.blog.service.learn.algorithm.recursion;

/**
 * 编写一个递归的静态方法计算ln(N!)
 * @author WangWenLei
 * @DATE: 2021/5/20
 **/
public class ln_n__1_ {
    private static int recursion(int n){
        if(n == 2){
            return 2;
        }
        if(n == 1){
            return 1;
        }
        return n * recursion(n - 1);
    }

    public static void main(String[] args){
        int n = 4;
        int recursion = recursion(n);
        System.out.println(recursion);
        System.out.println("ln(n!) = " + Math.log1p(recursion));
    }
}
