import java.util.ArrayList; 

abstract class SimpleDataStructure { 
    ArrayList<Integer> datalist;

    // An abstract function (like a pure virtual function in C++) 
    abstract int lookup(int keyword);  
    abstract boolean isEmpty();
    abstract void insert(int value);
      
} 