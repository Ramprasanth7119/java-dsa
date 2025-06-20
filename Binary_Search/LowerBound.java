
// Smallest Index such that arr[mid] >= el

// It is also a search Index Position Problem.

public class LowerBound {

    public static int lowerBound(int arr[], int n, int el){

        int low = 0, high = n - 1;

        int ans = n;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] >= el){

                ans = mid;

                high = mid - 1;
                
            } else{

                low = mid + 1;

            }

        }

        return ans;

    }
    
    public static void main(String[] args) {
        
         int arr[] = {1,4,7,10,15,20,25,28,34,40,45,51};

         int n = arr.length;

         int lb1 = 1, lb2 = 22, lb3 = 38, lb4 = 51, lb5 = 60;

        System.out.println(lowerBound(arr, n, lb1)); // 0

        System.out.println(lowerBound(arr, n, lb2)); // 6

        System.out.println(lowerBound(arr, n, lb3)); // 9

        System.out.println(lowerBound(arr, n, lb4)); // 11

        System.out.println(lowerBound(arr, n, lb5)); // 12

        // TC --> O(log N)
    }

}
