import java.util.ArrayList; 

class Stack{
    ArrayList<Integer> datalist; 
  
    Stack() 
    { 
        this.datalist = new ArrayList<Integer>();
    } 

    Integer lookup(int index){
        return this.datalist.get(index);
    }
    public boolean isEmpty(){
        return this.datalist.isEmpty();
    }

    public void push(int data) 
    { 
        this.datalist.add(data);
    } 
    
    public int pop() 
    {
        if (isEmpty()) { 
            System.out.printf("\nStack is Empty\n"); 
            return -1; 
        }  
        int item = this.datalist.get(this.datalist.size() - 1);
        this.datalist.remove(this.datalist.size() - 1);
        return item;
    }

    public int top() 
    {
        if (isEmpty()) { 
            System.out.printf("\nStack is Empty\n"); 
            return -1; 
        } 

        int item = this.datalist.get(this.datalist.size() - 1);
        return item;
    }


    public void display() 
    { 
        if (isEmpty()) { 
            System.out.printf("\nStack is Empty\n"); 
            return; 
        } 

        for (int i = 0; i < this.datalist.size(); i++) { 
            System.out.printf(" %d <-- ", this.datalist.get(i)); 
        } 
        return; 
    } 
} 

