// Java program to print largest contiguous array sum 
// Kadane's Algorithm
// https://www.algorithmist.com/index.php/Kadane's_Algorithm
// 
// for  {-2, -3, 4, -1, -2, 1, 5, -3}
// the ans is 7 with maxStartIndex:2; maxEndIndex:6

import java.util.*; 
  
class Maxsubsum 
{ 
    public static void main (String[] args) 
    { 
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        System.out.println("Maximum contiguous sum is " + 
                                       maxSubArraySum(a)); 
    } 
  
    // static int maxSubArraySum(int a[]) 
    // { 
    //     int size = a.length; 
    //     int max_so_far = Integer.MIN_VALUE, max_ending_here = 0; 
  
    //     for (int i = 0; i < size; i++) 
    //     { 
    //         max_ending_here = max_ending_here + a[i]; 
    //         if (max_so_far < max_ending_here) 
    //             max_so_far = max_ending_here; 
    //         if (max_ending_here < 0) 
    //             max_ending_here = 0; 

    //         System.out.println("max_ending_here " + max_ending_here); 
    //     } 
    //     return max_so_far; 
    // } 


    static int maxSubArraySum(int a[]) 
    { 
        int size = a.length; 
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0; 
        int maxStartIndex = 0, maxEndIndex =0;
        int currentStartIndex = 0;
        for (int i = 0; i < size; i++) 
        { 
            max_ending_here = max_ending_here + a[i]; 
            if (max_so_far < max_ending_here){
                max_so_far = max_ending_here; 
                maxStartIndex = currentStartIndex;
                maxEndIndex = i;
            }
            if (max_ending_here < 0){
                max_ending_here = 0; 
                currentStartIndex = i + 1;
            }

            System.out.println("max_ending_here " + max_ending_here); 
        } 
        
        System.out.println("info: maxStartIndex:"+maxStartIndex +"; maxEndIndex:"+ maxEndIndex);  
        return max_so_far; 
    } 
} 
