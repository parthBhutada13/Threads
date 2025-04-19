//MainThread.java
public class MainThread {
   public static void main(String[] args) {
       // Create thread instances
       Thread thread1 = new Thread(new NumberPrinter(), "Thread-1");
       Thread thread2 = new Thread(new NumberPrinter(), "Thread-2");


       // Start the threads
       thread1.start();
       thread2.start();


       // Demonstrate thread joining
       ThreadOperations.joinThreads(thread1, thread2);


       // Demonstrate thread sleep
       ThreadOperations.threadSleepDemo();


       // Demonstrate thread priority
       ThreadOperations.threadPriorityDemo();
   }
}
