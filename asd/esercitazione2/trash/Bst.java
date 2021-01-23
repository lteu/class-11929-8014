public class Bst {
    public static  Node root;
    public Bst(){
        this.root = null;
    }
    

    public Node lookupNode(int data){
        Node current = root;
        // return lookup_iterative(current,data);
        return lookup_recursive_node(current,data);
    }

    public Node lookup_recursive_node(Node current, int data){
        // Node current = root;
        if (current == null) {
            return null;
        }
        if (current.key == data) {
            return current;
        }
        return lookup_recursive_node((current.key > data) ? current.left : current.right, data);
    }



    public boolean lookup(int data){
        Node current = root;
        // return lookup_iterative(current,data);
        return lookup_recursive(current,data);
    }

    public boolean lookup_iterative(Node current, int data){
        // Node current = root;
        while(current!=null){
            if(current.key==data){
                return true;
            }else if(current.key>data){
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
        if (current.key == data) {
            return true;
        }
        return lookup_recursive((current.key > data) ? current.left : current.right, data);
    }

    public void insert_iterative(Node newNode,Node root){
        Node current = root;
        Node parent = null;
        while(current != null && current.key != newNode.key){
            parent = current;
            current = ((newNode.key < current.key) ? current.left : current.right );
        }
        link(parent,newNode);
    }

    public void insert_recursive(Node newNode,Node visiting){
        if (newNode.key < visiting.key) {
            if (visiting.left == null) {
                link(visiting,newNode);
            }else{
                visiting = visiting.left;
                insert_recursive( newNode, visiting);
            }
        }else{
            if (visiting.right == null) {
                link(visiting,newNode);
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
        // System.out.println("inserting "+id);
        insert_recursive(newNode,root);
        // insert_iterative(newNode,root);
    }

    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.key);
            display(root.right);
        }
    }

    public void link(Node p,Node u){
        if(u!=null){
            u.parent = p;
        }

        if (p != null) {
            if (u.key < p.key) {
                p.left = u;
            }else{
                p.right = u;
            }
        }
    }

    public void unlink(Node p,Node u, int k){
        if(u!=null){
            u.parent = p;
        }

        if (p != null) {
            if (k < p.key) {
                p.left = u;
            }else{
                p.right = u;
            }
        }
    }

    public void remove(Node root,int k){
        Node u = lookupNode(k);
        System.out.println("Got "+u.key);

        if( u!=null){ // caso 1
            if (u.left== null && u.right==null )
                if (u.parent != null){
                    unlink(u.parent, null, k);
                }
        }
    }

    public static void main(String arg[]){
        Bst b = new Bst();
        b.insert(3);b.insert(8);
        b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
        b.insert(20);b.insert(25);b.insert(15);b.insert(16);
        System.out.println("Original Tree : ");
        b.display(b.root);      
        System.out.println("");
        System.out.println("Check whether Node with value 4 exists : " + b.lookup(4));  
        System.out.println("Check whether Node with value 7 exists : " + b.lookup(7));            
        b.remove(b.root,25);
        b.display(b.root);  
    }
}

class Node{
    int key;
    int value;
    Node left;
    Node right;
    Node parent; 
    public Node(int key){
        this.key = key;
        left = null;
        right = null;
    }
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }
}