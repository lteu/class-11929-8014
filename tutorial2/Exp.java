import java.util.Random;
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
        long endTime;
        long duration;
    
    
        Random rd = new Random(); // creating Random object
        BinarySearchTree b = new BinarySearchTree();
        // int[] arr = new int[5];
        for (int i = 0; i < 1000000; i++) {
             int numb = rd.nextInt(1000000); // storing random integers in an array
             b.insert(numb);
        }

        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);  

        System.out.println("inserted all the elements in "+millisToShortDHMS( duration ) +" secs");

        for (int i = 0; i < 5000; i++) {
             int numb = rd.nextInt(10000); // storing random integers in an array
             Boolean ris = b.lookupNode(numb);
             // System.out.println(ris);
        }

        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);  

        System.out.println("search operation done in "+millisToShortDHMS( duration ) +" secs");

        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);  

        System.out.println("\n\n----\nTotal time lapse: "+millisToShortDHMS( duration ) +"\n");


    } 
}