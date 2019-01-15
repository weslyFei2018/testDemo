package abstractclass;

public class RealClass1 extends AbstractClass{
    public RealClass1(int key, String value){
        this.setKey(key);
        this.setValue(value);
    }

    public void exec() {
        System.out.println("RealClass1中的exec()");
    }
}
