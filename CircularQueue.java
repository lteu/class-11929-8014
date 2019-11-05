class CircularQueue extends SimpleDataStructure{ 

    int[] queue;
    int size,front,rear;
    int capacity;
  
    CircularQueue(int capacity) 
    { 
        this.queue = new int[capacity];
        this.capacity = capacity;
        this.size = 0 ;this.front = 0 ;this.rear = 0 ;
    } 

    Integer lookup(int index){
        return this.queue[index % this.capacity];
    }

    public boolean isEmpty(){
        return this.queue == null || this.queue.length == 0;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }
    public int top() 
    { 
        return this.queue[this.front];
    } 

    public void enqueue(int data) 
    {
        if (this.size == this.capacity) {
             System.out.printf("\nThe CircularQueue is FULL.\n"); 
             System.out.printf(" size %d capacity %d ", this.size,this.capacity); 
        }else{
            this.size++;
            this.queue[this.rear] = data;
            rear = (rear+1) % this.capacity;
        } 

    } 
    
    public Integer dequeue() 
    { 
        if (this.size == 0) {
             System.out.printf("\nThe CircularQueue is EMPTY.\n"); 
        }else{
            int data = this.queue[(this.front)];
            this.front = (this.front + 1) % this.capacity;
            this.size--;
            return data;
        } 
        return null;
    }


    public void display() 
    {   

        System.out.printf("\nCircularQueue, front:%d rear:%d\n",this.front,this.size); 
        if (isEmpty()) { 
            System.out.printf("\nQueue is Empty\n"); 
            return; 
        } 

        for (int i = 0; i < this.size; i++) { 
            System.out.printf(" %d --> ", this.lookup(this.front+i)); 
        } 
        return; 
    } 
} 

