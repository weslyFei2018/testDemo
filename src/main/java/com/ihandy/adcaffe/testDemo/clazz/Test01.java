package com.ihandy.adcaffe.testDemo.clazz;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Test01 {
    private String code;
    private String name;

    public Test01(){
        System.out.println("我是tset01无参构造器");
    }

    public Test01(String code,String name){
        this.code=code;
        this.name=name;
        System.out.println("我是tset01有参构造器，String code,String name");
    }
    public void t1(){}
    public void t2(String sss){
        System.out.println("通过反射调用本方法-"+sss);
    }
    public void t3(Integer integer,Boolean boo,String t){}
}
