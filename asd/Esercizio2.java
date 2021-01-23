/**
* BST - BinarySearchTree
*/
public class Esercizio2 {
    public static  Node root;

    public Esercizio2(int key){
        this.root = new Node(key);
    }


    public Node insert(int key){
        Node newNode = new Node(key);

        insert_iterative(newNode, this.root);
        return newNode;
    }
    public void stampa(Node node){
        if (node != null) {
            stampa(node.left);
            System.out.println("Node: " + node.key);
            stampa(node.right);
        }
    }

    public void insert_iterative(Node newNode, Node root){
        Node current = root; 
        Node parent = null;

        // trovare riferimento 
        while(current != null){
            parent = current;
            if (newNode.key > current.key) {
                current = current.right;
            }else if(newNode.key < current.key){
                current = current.left;
            }
        }
        
        // attacca il nodo nuovo all'albero
        link(parent,newNode);
    }

    public void link(Node p, Node newNode){
        if (newNode != null) {
            newNode.parent = p;
        } // aggiorniamo il padre del nodo nuovo.
        if (p != null) {
            if (newNode.key < p.key) {
                p.left = newNode;
            }else{
                p.right = newNode;
            }
        } // aggiorno il figlio del nodo di riferimento (trovato dal while)
    }

 

    public static void main(String arg[]){
        System.out.println("Creo alberto ...");

        Esercizio2 b = new Esercizio2(9); // istanza della classe Albero binario di ricerca
        

        Node c = b.insert(6);
        Node d = b.insert(10);
        Node e = b.insert(4);
        Node f = b.insert(7);

        Node g = inorderSucc(f);

        System.out.println("Val: "+g.key);


        // System.out.println("Stampa ricorsiva: ");
        // b.stampa(b.root);


    }

    static Node inorderSucc(Node n){
        if (n == null) {
            return null;
        }
        if (n.right != null) {
            return leftMostChild(n.right);
        }else{
            Node q = n;
            Node x = q.parent;
            while(x != null && x.left != q){
                q = x;
                x = x.parent;

            }
            return x;
        }

    }

    static Node leftMostChild(Node n){
        if (n == null) {
            return null;            
        }
        while(n.left != null){
            n = n.left;
        }
        return n;

    }
}

class Node{
    int key;
   
    Node left; // figlio 1
    Node right; // figlio 2
    Node parent;
    
    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }



}