// An array is said to monotonic if the elements in the array are strictly increasing.
// credits: https://helloacm.com/how-to-check-if-an-array-is-monotonic/

class Monotonic 
{ 
    static public Boolean isMonotonicIncreasing(int arr[]) {
        for (int i = 1; i < arr.length; ++ i) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    static public Boolean isMonotonicDecreasing(int arr[]) {
        for (int i = 1; i < arr.length; ++ i) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    static Boolean isMonotonic(int arr[])  
    { 
        return isMonotonicIncreasing(arr) || isMonotonicDecreasing(arr);
    } 
  
    // Driver Code 
    public static void main(String args[])  
    { 
        int arr[] = { -3, 9, 7, 20, 17, 5, 1 }; 
        // int arr[] = { 3, 9, 17, 20, 27, 51, 100 }; 

        int n = arr.length; 
      
        System.out.println(isMonotonic(arr) ?"YES" : "NO"); 
    } 
} 