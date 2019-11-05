// An array is said to be bitonic if the elements in the array are first strictly increasing then strictly decreasing.
// credits: https://www.geeksforgeeks.org/program-to-check-if-an-array-is-bitonic-or-not/

class Bitonic 
{ 
    // Function to check if the  
    // given array is bitonic 
    static Boolean checkBitonic(int arr[])  
    {   
        int n = arr.length;
        int i, j; 
      
        // Check for increasing sequence 
        for (i = 1; i < n; i++) 
        { 
            if (arr[i] > arr[i - 1]) 
                continue; 
      
            if (arr[i] <= arr[i - 1]) 
                break; 
        } 
      
        if (i == n - 1) // one last element remain
            return true; 
      
        // Check for decreasing sequence 
        for (j = i + 1; j < n; j++)  
        { 
            if (arr[j] < arr[j - 1]) 
                continue; 
      
            if (arr[j] >= arr[j - 1]) 
                break; 
        } 
      
        i = j; 
      
        if (i != n) 
            return false; 
      
        return true; 
    } 
  
    // Driver Code 
    public static void main(String args[])  
    { 
        // int arr[] = { -3, 9, 7, 20, 17, 5, 1 }; 
        int arr[] = { -3, 9, 17, 20, 17, 5, 1 }; 
        System.out.println( checkBitonic(arr) ? "YES" : "NO"); 
    } 
} 