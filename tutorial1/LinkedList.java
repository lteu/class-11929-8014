class LinkedList{ 

    Node head;
    Node tail;

    class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    LinkedList() 
    {   

    } 
  
    LinkedList(int val) 
    { 
        this.head = new Node(val);
        this.tail = this.head;
    } 


    // Integer lookup(int index){
    //     if (index == 0) {
    //         return this.head.data;
    //     }
    //     Node next = this.head.next;
    //     int counter = 0;
    //     while (counter < index) { 
    //         if (index == counter+1) {
    //             return next.data;
    //         }
    //         next = next.next;
    //         counter++;
    //     }
    //     return null; 
    // }
    Integer lookup(int numb){
        if (numb == this.head.data) {
            return this.head.data;
        }
        Node next = this.head.next;
        int counter = 0;
        while (next != null) { 
            if (numb == next.data) {
                return next.data;
            }
            next = next.next;
            counter++;
        }
        return null; 
    }

    public boolean isEmpty(){
        if(this.head == null)
            return true;
        else
            return false;
    }

    public void remove(int index){
        if(this.head == null)
            System.out.printf("\nLinkedList is Empty\n"); 
        else{
            if (index == 0) {
                this.head = this.head.next;
                return;
            }

            Node tmpnode = this.head;
            int counter = 0;
            while (counter < index) { 
                if (index == counter+1) {
                    tmpnode.next = tmpnode.next.next;
                    return;
                }
                tmpnode = tmpnode.next;
                counter++;
            }
        }
    }

    public void insert( int data){
        Node nd = new Node(data);

        if (this.head == null) {
            this.head = nd;
            this.tail = nd;
        }else{
            this.tail.next = nd;
            this.tail = nd;
            // Node last = this.head;
            // while(last.next != null){
            //     last = last.next;
            // }
            // last.next = nd;
        }
    }

    public void display() 
    { 
        if (this.head ==  null ) { 
            System.out.printf("\nLinkedList is Empty\n"); 
            return; 
        } 

        Node next = this.head.next;
        System.out.printf(" %d --> ", this.head.data); 
        while (next != null) { 
            System.out.printf(" %d --> ", next.data); 
            next = next.next;
        } 
        return; 
    } 
} 

