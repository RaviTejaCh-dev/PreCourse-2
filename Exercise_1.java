// Time Complexity:
// Best Case:    O(1) [if the element is found at the middle]
// Average Case: O(log n)
// Worst Case:   O(log n)

// Space Complexity:
// O(1) for iterative version
// O(log n) for recursive version due to call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BinarySearch {
    // Returns index of x if it is present in arr[l.. r], else return -1 
    int binarySearch(int arr[], int l, int r, int x) 
    { 
        //Write your code here --- recursive approach
        if ( r >= l){
            int mid = l + (r - l) / 2; // calculating mid value of array

            if (arr[mid] == x)
                return mid; // if mid value is x then return mid index

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x); // if mid index value is greater than x then search left part of arr(left to mid - 1 index).

            return binarySearch(arr, mid + 1, r, x); // if mid index value is less than x then search right part of arr(mid + 1 to right index).
        }
        return -1;
    } 
  
    // Driver method to test above 
    public static void main(String args[]) 
    { 
        BinarySearch ob = new BinarySearch(); 
        int arr[] = { 2, 3, 4, 10, 40 }; 
        int n = arr.length; 
        int x = 10; 
        int result = ob.binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
    } 
} 
