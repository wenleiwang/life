package com.wenwen.blog.service.learn.ANNOTATIONS;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 编写注解处理器
 * @author WangWenLei
 * @DATE: 2020/11/26
 **/
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl){
        for(Method m : cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found Use Case" +
                        uc.id() + "\n" + uc.description());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }

        useCases.forEach(i -> System.out.println("Mising use Case "+ i) );
    }

    public static void main(String [] args){
        List<Integer> useCases = IntStream.range(47,51).boxed().collect(Collectors.toList());
        trackUseCases(useCases,PasswordUtils.class);
    }
}
