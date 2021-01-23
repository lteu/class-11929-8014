import java.util.Random;


public class Run { 
  
    // Driver code 
    public static void main(String[] args) 
    { 

    
        Random rd = new Random(); // creating Random object
        Bst b = new Bst();
        // int[] arr = new int[5];
        for (int i = 0; i < 1000000; i++) {
             int numb = rd.nextInt(1000000); // storing random integers in an array
             b.insert(numb);
        }

        // for (int i = 0; i < 5000; i++) {
        //      int numb = rd.nextInt(10000); // storing random integers in an array
        //      Boolean ris = b.lookupNode(numb);
        //      // System.out.println(ris);
        // }


    } 
}