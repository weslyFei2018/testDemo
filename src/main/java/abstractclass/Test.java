package abstractclass;


public class Test {

    public static void main(String[] args){
        AbstractClass class1 = new RealClass1(1,"realClass1");
        class1.fetch();
        AbstractClass class2 = new RealClass2(2,"realClass2");
        class2.fetch();

        try{
            Integer a = 0;
            a.byteValue();
            System.out.println(a.byteValue());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
