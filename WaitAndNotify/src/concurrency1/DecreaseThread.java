package concurrency1;

public class DecreaseThread extends Thread{
    private WaitAndNotify waitAndNotify;

    public DecreaseThread( WaitAndNotify waitAndNotify){
        this.waitAndNotify = waitAndNotify;
    }

    @Override
    public void run(){
        for(int i =0;i<30;i++){
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitAndNotify.decrease();
        }
    }
}
