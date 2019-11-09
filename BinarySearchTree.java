public class BinarySearchTree {
    public static  Node root;
    public BinarySearchTree(){
        this.root = null;
    }
    
    public boolean lookupNode(int data){
        Node current = root;
        // return lookup_iterative(current,data);
        return lookup_recursive(current,data);
    }

    public boolean lookup_iterative(Node current, int data){
        // Node current = root;
        while(current!=null){
            if(current.data==data){
                return true;
            }else if(current.data>data){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }
    
    public boolean lookup_recursive(Node current, int data){
        // Node current = root;
        if (current == null) {
            return false;
        }
        if (current.data == data) {
            return true;
        }
        return lookup_recursive((current.data > data) ? current.left : current.right, data);
    }

    public void insert_iterative(Node newNode,Node root){
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(newNode.data<current.data){                
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void insert_recursive(Node newNode,Node visiting){
        if (newNode.data < visiting.data) {
            if (visiting.left == null) {
                visiting.left = newNode;
            }else{
                visiting = visiting.left;
                insert_recursive( newNode, visiting);
            }
        }else{
            if (visiting.right == null) {
                visiting.right = newNode;
            }else{
                visiting = visiting.right;
                insert_recursive( newNode, visiting);
            }
        }
    }

    public void insert(int id){
        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return;
        }
        // insert_recursive(newNode,root);
        insert_iterative(newNode,root);
    }

    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public static void main(String arg[]){
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);b.insert(8);
        b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
        b.insert(20);b.insert(25);b.insert(15);b.insert(16);
        System.out.println("Original Tree : ");
        b.display(b.root);      
        System.out.println("");
        System.out.println("Check whether Node with value 4 exists : " + b.lookupNode(4));  
        System.out.println("Check whether Node with value 7 exists : " + b.lookupNode(7));            
    }
}

class Node{
    int data;
    Node left;
    Node right; 
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}