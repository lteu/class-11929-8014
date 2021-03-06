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
    
        // Queue q = new Queue(10); 
  
        // // print Queue elements 
        // q.display(); 
        
        // System.out.printf("\n\nNow add 4 elements\n"); 
        // // inserting elements in the queue 
        // q.enqueue(20); 
        // q.enqueue(30); 
        // q.enqueue(40); 
        // q.enqueue(50); 
  
        // // print Queue elements 
        // q.display(); 
  
        // System.out.printf("\n\nNow dequeue 2 elements\n\n"); 
        // q.dequeue(); 
        // q.dequeue(); 

        // q.display(); 

        // System.out.printf("\nStack exp\n"); 
        // Stack s = new Stack(); 
        // s.push(12);
        // s.push(31);
        // s.display();
        // s.pop();
        // System.out.printf("\n\nafter pop\n\n"); 
        // s.display();
        
        Random rd = new Random(); // creating Random object
        LinkedList list = new LinkedList();
        // int[] arr = new int[5];
        for (int i = 0; i < 1000000; i++) {
             int numb = rd.nextInt(1000000); // storing random integers in an array
             list.insert(numb);
             // System.out.println(arr[i]); // printing each array element
        }
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);  

        System.out.println("inserted all the elements in "+millisToShortDHMS( duration ) +" secs");

        for (int i = 0; i < 5000; i++) {
             int numb = rd.nextInt(10000); // storing random integers in an array
             Integer ris = list.lookup(numb);
             // System.out.println(ris);
        }

        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);  

        System.out.println("search operation done in "+millisToShortDHMS( duration ) +" secs");

        // System.out.printf("\nLinkedList exp\n"); 
        // LinkedList list = new LinkedList();
        // list.insert(4);
        // list.insert(5);
        // list.insert(6);
        // list.insert(7);
        // list.insert(8);
        // list.display();
        // System.out.printf("\n removing index %d \n ", 1); 
        // list.remove(1);
        // System.out.printf("\n removing index %d again\n ", 1); 
        // list.remove(1);
        // list.display();
        // System.out.printf("\n lookup %d <-- ", list.lookup(1)); 

        // System.out.printf("\nCircularQueue exp\n"); 
        // CircularQueue cq = new CircularQueue(5);
        // cq.enqueue(20); 
        // cq.enqueue(30); 
        // cq.enqueue(40); 
        // cq.enqueue(50);
        // cq.enqueue(60); 
        // cq.display(); 
        // cq.dequeue(); 
        // cq.enqueue(70); 
        // cq.dequeue(); 
        // cq.dequeue(); 
        // cq.dequeue(); 
        // cq.enqueue(80);
        // cq.enqueue(90);
        // System.out.printf("\nAfter operations \n"); 
        // cq.display(); 

        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);  

        System.out.println("\n\n----\nTotal time lapse: "+millisToShortDHMS( duration ) +"\n");

        // System.out.println(""+Math.random());

    } 
}