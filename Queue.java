
// Java program to implement a queue using an ArrayList 
class Queue extends AbstractQueue{ 
  
    Queue(int dim) 
    { 
        this.datalist = new int[dim];
        this.capacity = dim;
        this.head = 0 ;this.tail = 0 ;
    } 

    Integer lookup(int index){
        return this.datalist[index];
    }
    
    public boolean isEmpty(){
        return this.datalist.length == 0;
    }
    
    public void enqueue(int data) 
    { 
        if (this.tail == this.capacity){
             System.out.printf("\nThe Queue is FULL.\n"); 
        }else{
            this.datalist[this.tail] = data;
            this.tail++;
        }
    } 
    
    public Integer dequeue() 
    { 
        if (this.tail == 0) {
            System.out.printf("\nThe Queue is Empty.\n"); 
            return null;
        }
        else{
            int item = this.datalist[0];

            // shift
            for (int i = 0; i < this.tail - 1; i++) { 
                this.datalist[i] = this.datalist[i + 1]; 
            } 
            this.tail--;
            this.datalist[this.tail] = 0;

            return item;
        }

    }

    public Integer top() 
    { 
        return this.datalist[0];
    }


    public void display() 
    { 
        if (isEmpty()) { 
            System.out.printf("\nQueue is Empty\n"); 
            return; 
        } 

        for (int i = 0; i < this.datalist.length; i++) { 
            System.out.printf(" %d <-- ", this.datalist[i]); 
        } 
        return; 
    } 
} 

