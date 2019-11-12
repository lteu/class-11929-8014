class CircularQueue extends AbstractQueue{ 

    int size;
  
    CircularQueue(int capacity) 
    { 
        this.datalist = new int[capacity];
        this.capacity = capacity;
        this.size = 0 ;this.head = 0 ;this.tail = 0 ;
    } 

    Integer lookup(int index){
        return this.datalist[index % this.capacity];
    }

    public boolean isEmpty(){
        return this.datalist == null || this.datalist.length == 0;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }
    public Integer top() 
    { 
        return this.datalist[this.head];
    } 

    public void enqueue(int data) 
    {
        if (this.size == this.capacity) {
             System.out.printf("\nThe Circulardatalist is FULL.\n"); 
             System.out.printf(" size %d capacity %d ", this.size,this.capacity); 
        }else{
            this.size++;
            this.datalist[this.tail] = data;
            tail = (tail+1) % this.capacity;
        } 

    } 
    
    public Integer dequeue() 
    { 
        if (this.size == 0) {
             System.out.printf("\nThe Circulardatalist is EMPTY.\n"); 
        }else{
            int data = this.datalist[(this.head)];
            this.head = (this.head + 1) % this.capacity;
            this.size--;
            return data;
        } 
        return null;
    }


    public void display() 
    {   

        System.out.printf("\nCirculardatalist, head:%d tail:%d\n",this.head,this.size); 
        if (isEmpty()) { 
            System.out.printf("\ndatalist is Empty\n"); 
            return; 
        } 

        for (int i = 0; i < this.size; i++) { 
            System.out.printf(" %d --> ", this.lookup(this.head+i)); 
        } 
        return; 
    } 
} 

