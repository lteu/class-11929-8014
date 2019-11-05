import java.util.ArrayList; 

abstract class SimpleDataStructure { 
    ArrayList<Integer> datalist;

    abstract Integer lookup(int keyword);  
    abstract boolean isEmpty();
      
} 