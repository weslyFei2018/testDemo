package abstractclass;

public class RealClass2 extends AbstractClass{
    public RealClass2(int key, String value){
        this.setKey(key);
        this.setValue(value);
    }

    public void exec() {
        System.out.println("RealClass2中的exec()");
    }
}
