package com.ihandy.adcaffe.testDemo.abstractclass;


import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args){
//        AbstractClass class1 = new RealClass1(1,"realClass1");
//        class1.fetch();
//        AbstractClass class2 = new RealClass2(2,"realClass2");
//        class2.fetch();
//
//        try{
//            Integer a = 0;
//            a.byteValue();
//            System.out.println(a.byteValue());
//        }catch (Exception e){
//            e.printStackTrace();
//        }


        List<String> a = new ArrayList<>();
        for (int i=0;i<10;i++){
            a.add(i+"");
        }
        System.out.println(a.subList(1,11).toString());



    }

    public static class TestZero {
        public static void main(String[] args){
            double a = 0;
            if (a != 0 ){
                System.out.println(111);
            }else {
                System.out.println(22);
            }
        }
    }
}
