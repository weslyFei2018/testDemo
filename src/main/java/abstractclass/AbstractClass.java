package abstractclass;

public abstract class AbstractClass {

    private int key;
    private String value;

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void fetch(){
        System.out.println("抽象类中的方法开始执行" +this.getClass().getName());
        this.exec();
    }

    public abstract void exec();
}
