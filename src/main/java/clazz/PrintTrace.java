package clazz;

public class PrintTrace {
    private static final int _1M = 1024 * 1024;
    public static void main(String[] args){
        //String s ="abcabcbb";
//       String s ="powwkew";
//       int ans = lengthOfLongestSubstring(s);
//       System.out.println(ans);
        printTrack();
        byte[] byte1 = new byte[2 * _1M]; printTrack();
        byte[] byte2 = new byte[2 * _1M]; printTrack();
        byte[] byte3 = new byte[2 * _1M]; printTrack();
        byte[] byte4 = new byte[2 * _1M]; printTrack();
        byte[] byte5 = new byte[2 * _1M]; printTrack();
        byte[] byte6 = new byte[5 * _1M]; printTrack();
        byte[] byte7 = new byte[2 * _1M]; printTrack();
    }

    /**
     * 打印当前线程的调用堆栈
     *
     */
    static void printTrack(){
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if(st==null){
            System.out.println("无堆栈...");
            return;
        }
        StringBuffer sbf =new StringBuffer();
        for(StackTraceElement e:st){
            //System.out.println( e.toString());
            if(sbf.length()>0){
                sbf.append(" <- ");
                sbf.append(System.getProperty("line.separator"));
            }
            sbf.append(java.text.MessageFormat.format("{0}.{1}() {2}"
                    ,e.getClassName()
                    ,e.getMethodName()
                    ,e.getLineNumber()));
        }
        System.out.println(sbf.toString());
        System.out.println("---------------------------------");
    }
}
