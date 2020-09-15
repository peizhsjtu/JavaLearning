package concurrency1;

public class Client {
    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread increaseThread = new IncreaseThread(waitAndNotify);
        Thread decreaseThread = new DecreaseThread(waitAndNotify);

        increaseThread.start();
        decreaseThread.start();
    }
}
