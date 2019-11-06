
abstract class AbstractQueue { 
    int[] datalist;
    int head,tail;
    int capacity;

    abstract Integer lookup(int keyword);  
    abstract boolean isEmpty();
    abstract void enqueue(int data);
    abstract Integer dequeue();
    abstract void display();
    abstract Integer top();
        

} 