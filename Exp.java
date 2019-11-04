
// main experiment

import java.util.concurrent.TimeUnit;

public class Exp { 
    public static String millisToShortDHMS(long duration) {
    String res = "";    // java.util.concurrent.TimeUnit;
    long days       = TimeUnit.MILLISECONDS.toDays(duration);
    long hours      = TimeUnit.MILLISECONDS.toHours(duration) -
                      TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
    long minutes    = TimeUnit.MILLISECONDS.toMinutes(duration) -
                      TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
    long seconds    = TimeUnit.MILLISECONDS.toSeconds(duration) -
                      TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
    long millis     = TimeUnit.MILLISECONDS.toMillis(duration) - 
                      TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(duration));
    if (days == 0)      res = String.format("%02d:%02d:%02d.%04d", hours, minutes, seconds, millis);
    else                res = String.format("%dd %02d:%02d:%02d.%04d", days, hours, minutes, seconds, millis);
    return res;
}

  
    // Driver code 
    public static void main(String[] args) 
    { 
  
        long startTime = System.currentTimeMillis();
    
        Queue q = new Queue(); 
  
        // print Queue elements 
        q.queueDisplay(); 
        
        System.out.printf("\n\nNow add 4 elements\n"); 
        // inserting elements in the queue 
        q.enqueue(20); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50); 
  
        // print Queue elements 
        q.queueDisplay(); 
  
        System.out.printf("\n\nNow dequeue 2 elements\n\n"); 
        q.dequeue(); 
        q.dequeue(); 

        q.queueDisplay(); 
  

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);  

        System.out.println("\n\n----\nTime lapse: "+millisToShortDHMS( duration ) +"\n");

        // System.out.println(""+Math.random());

    } 
}