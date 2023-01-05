import java.util.Scanner;

public class ThreadAThreadB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MessageHandler messageHandler = new MessageHandler();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                        messageHandler.thread1();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                     messageHandler.thread2();
                }
            }
        });

        t2.start();
        t1.start();
    }
}
