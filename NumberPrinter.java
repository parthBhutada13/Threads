//NumberPrinter.java
public class NumberPrinter implements Runnable {
   /**
    * The run method that contains the thread's execution logic
    */
   @Override
   public void run() {
       // Get the current thread's name
       String threadName = Thread.currentThread().getName();


       // Print numbers from 1 to 5
       for (int i = 1; i <= 5; i++) {
           System.out.println(threadName + ": " + i);


           // Add small delay to see interleaving of threads
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               System.out.println(threadName + " interrupted: " + e.getMessage());
           }
       }
   }
}
