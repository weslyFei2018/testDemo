package clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestClazz {

    public static void main(String[] args) throws Exception{
        try {
            Class<?> clazz = Class.forName("clazz.Test01");
            //获取本类的所有方法，存放入数组
            Method[] methods = clazz.getDeclaredMethods();////获取自身所有的方法(private、public、protected，和访问权限无关)，不包括继承的
            //methods = clazz.getMethods();//获取包括自身和继承（实现）过来的所有的public方法
            Method m = clazz.getMethod("t2",String.class);
            Object o = clazz.newInstance();
            m.invoke(o,"123");
            System.out.println("-------------------------");
            for (Method method : methods) {
                System.out.println("方法名："+method.getName());
                //获取本方法所有参数类型，存入数组
                Class<?>[] getTypeParameters = method.getParameterTypes();
                if(getTypeParameters.length==0){
                    System.out.println("此方法无参数");
                }
                for (Class<?> class1 : getTypeParameters) {
                    String parameterName = class1.getName();
                    System.out.println("参数类型："+parameterName);
                }
                System.out.println("****************************");
            }

            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println("构造器名："+constructor.getName());
            }

            Constructor<?> c1 = clazz.getConstructor(null);
            System.out.println("构造器名："+c1.getName());
            Test01 o1 = (Test01)c1.newInstance();
            System.out.println(o1);
            Constructor<?> c2 = clazz.getConstructor(String.class, String.class);
            System.out.println("构造器名："+c2.getName());
            Test01 o2 = (Test01)c2.newInstance("1", "1");
            System.out.println(o2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}