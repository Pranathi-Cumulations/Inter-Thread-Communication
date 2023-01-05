public class Main {
    public static void main(String[] args) {
        HTTPRequests httpRequests = new HTTPRequests();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                httpRequests.get();

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                httpRequests.post();

            }
        });

         t2.start();
         t1.start();
//        try{
//            t1.join();
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }

    }
}
