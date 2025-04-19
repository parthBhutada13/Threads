//ThreadOperations.java
public class ThreadOperations {


   public static void joinThreads(Thread... threads) {
       System.out.println("\n--- Joining Threads ---");
       for (Thread thread : threads) {
           try {
               System.out.println("Waiting for " + thread.getName() + " to complete...");
               thread.join();
               System.out.println(thread.getName() + " has completed.");
           } catch (InterruptedException e) {
               System.out.println("Thread interrupted: " + e.getMessage());
           }
       }
       System.out.println("All threads have completed.\n");
   }


   public static void threadSleepDemo() {
       System.out.println("--- Thread Sleep Demo ---");
       Thread sleepThread = new Thread(() -> {
           System.out.println(Thread.currentThread().getName() + " is going to sleep for 2 seconds");
           try {
               Thread.sleep(2000); // Sleep for 2 seconds
           } catch (InterruptedException e) {
               System.out.println("Sleep interrupted: " + e.getMessage());
           }
           System.out.println(Thread.currentThread().getName() + " has woken up");
       }, "Sleep-Thread");


       sleepThread.start();
       try {
           sleepThread.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println();
   }


   public static void threadPriorityDemo() {
       System.out.println("--- Thread Priority Demo ---");
       Thread lowPriorityThread = new Thread(new NumberPrinter(), "Low-Priority-Thread");
       Thread highPriorityThread = new Thread(new NumberPrinter(), "High-Priority-Thread");


       // Set priorities
       lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // Priority 1
       highPriorityThread.setPriority(Thread.MAX_PRIORITY); // Priority 10


       System.out.println(lowPriorityThread.getName() + " priority: " + lowPriorityThread.getPriority());
       System.out.println(highPriorityThread.getName() + " priority: " + highPriorityThread.getPriority());


       highPriorityThread.start();
       lowPriorityThread.start();
   }
}
