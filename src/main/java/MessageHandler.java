import java.util.Scanner;

public class MessageHandler {
    public String message ="hi";
    Scanner sc = new Scanner(System.in);
    public void thread1(){
        synchronized (this){

            message = sc.nextLine();
            notify();
            try {
                wait();
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println(Thread.currentThread() + message);

        }
    }

    public void thread2(){
        synchronized (this){
            try{
                wait();
            }
            catch(Exception e){
                System.out.println(e);
            }
            System.out.println(Thread.currentThread()+ message);
            message = sc.nextLine();
            notify();
        }
    }
}
