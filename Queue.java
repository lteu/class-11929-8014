import java.util.ArrayList; 

// Java program to implement a queue using an ArrayList 
class Queue extends SimpleDataStructure{ 
    private static int front, rear, capacity; 
    private static int queue[]; 
  
    Queue() 
    { 
        this.datalist = new ArrayList<Integer>();
    } 

    int lookup(int index){
        return this.datalist.get(index);
    }
    public boolean isEmpty(){
        return this.datalist.isEmpty();
    }
    public void insert(int value){
        this.datalist.add(value);
    }

    public void enqueue(int data) 
    { 
        this.datalist.add(data);
    } 
    
    public int dequeue() 
    { 
        int item = this.datalist.get(0);
        this.datalist.remove(0);
        return item;
    }


    public void queueDisplay() 
    { 
        if (isEmpty()) { 
            System.out.printf("\nQueue is Empty\n"); 
            return; 
        } 

        for (int i = 0; i < this.datalist.size(); i++) { 
            System.out.printf(" %d <-- ", this.datalist.get(i)); 
        } 
        return; 
    } 
} 

