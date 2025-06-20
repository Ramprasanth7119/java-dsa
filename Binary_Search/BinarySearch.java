
public class BinarySearch {

    // Iterative Approach
    public static int binarySearchI(int arr[], int n, int target){

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] == target) return mid;

            else if(arr[mid] < target) low = mid + 1;

            else high = mid - 1;

        }

        return -1;

    }

    // Recursive Approach
    public static int binarySearchII(int arr[], int low, int high, int target){

        if(low > high) return -1;

        int mid = (low + high ) / 2;

        if(arr[mid] == target) return mid;

        else if(arr[mid] < target) return binarySearchII(arr, mid + 1, high, target);

        return binarySearchII(arr, low, mid - 1, target);

    }

    public static void main(String args[]){

        int arr[] = {1,4,7,10,15,20,25,28,34,40,45,51};

        int target1 = 28, target2 = 82;

        int n = arr.length;
 
        System.out.println(binarySearchI(arr, n, target1));  // 7

        System.out.println(binarySearchII(arr, 0, n - 1, target2));  // -1

        // TC --> O(log N) => 
        //  if N = 32 --> 2 ^ 5 --> log 2 ^ 5 --> 5 log 2 --> 5 * 1 --> 5
        // Where the iteration required is approximately 5.

        // Overflow Case
        //
    }

}
