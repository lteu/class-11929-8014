import java.util.ArrayList; 

// Java program to implement a queue using an ArrayList 
class Queue extends SimpleDataStructure{ 
  
    Queue() 
    { 
        this.datalist = new ArrayList<Integer>();
    } 

    Integer lookup(int index){
        return this.datalist.get(index);
    }
    public boolean isEmpty(){
        return this.datalist.isEmpty();
    }
    
    public void enqueue(int data) 
    { 
        this.datalist.add(data);
    } 
    
    public Integer dequeue() 
    { 
        if (this.datalist.size() == 0) {
            return null;
        }
        else{
            int item = this.datalist.get(0);
            this.datalist.remove(0);
            return item;
        }

    }

    public int top() 
    { 
        int item = this.datalist.get(0);
        return item;
    }


    public void display() 
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

