// Time Complexity:
// Best Case:    O(n log n)
// Average Case: O(n log n)
// Worst Case:   O(n^2) — when the pivot always divides poorly

// Space Complexity:
// O(log n) on average for stack usage
// O(n) in the worst case for highly unbalanced partitions
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;

class IterativeQuickSort {
    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
        int pivot = arr[h];
        int i = l - 1;

        for (int j = l; j <= h - 1; j++) {  //Used Lomuto partition schema
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, h);
        return i + 1;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
        // Create an explicit stack
        Stack<Integer> stack = new Stack<>();

        // Push initial values
        stack.push(l);
        stack.push(h);

        // Keep popping while stack is not empty
        while (!stack.isEmpty()) {
            h = stack.pop();
            l = stack.pop();

            // Partition the array
            int p = partition(arr, l, h);

            // If there are elements on the left side of pivot, push left subarray
            if (p - 1 > l) {
                stack.push(l);
                stack.push(p - 1);
            }

            // If there are elements on the right side of pivot, push right subarray
            if (p + 1 < h) {
                stack.push(p + 1);
                stack.push(h);
            }
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 