package thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                dianping();
            }
        };

        t.start();
        System.out.println("dazhong");


}
    static void dianping(){
        System.out.println("dianping");
    }
}
