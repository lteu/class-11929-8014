// Java program for implementation of Heap Sort with Max-Heap
public class HeapSort 
{ 
    public void sort(int arr[]) 
    { 
        int dim = arr.length; 

        // Build heap ignoring the leaves (rearrange array) 
        heapBuild(arr, dim);

        // One by one extract an element from heap 
        for (int i=dim-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 

            // call max maxHeapRestore on the reduced heap 
            maxHeapRestore(arr, 0, i); 
        } 
    } 

    void heapBuild(int arr[], int dim){
        for (int i = dim / 2 - 1; i >= 0; i--) 
            maxHeapRestore(arr, i, dim); 
    }

    // To maxHeapRestore a subtree rooted with node i which is 
    // an index in arr[]. dim is size of heap 
    void maxHeapRestore(int arr[], int i, int dim) 
    { 
        int max = i; // Initialize max as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 

        // If left child is larger than root 
        if (l < dim && arr[l] > arr[max]) 
            max = l; 

        // If right child is larger than max so far 
        if (r < dim && arr[r] > arr[max]) 
            max = r; 

        // If max is not root 
        if (max != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[max]; 
            arr[max] = swap; 

            // Recursively maxHeapRestore the affected sub-tree 
            maxHeapRestore(arr, max, dim); 
        } 
    } 

    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 

    // Driver program 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
        int n = arr.length; 

        HeapSort ob = new HeapSort(); 
        ob.sort(arr); 

        System.out.println("Sorted array is"); 
        printArray(arr); 
    } 
} 

