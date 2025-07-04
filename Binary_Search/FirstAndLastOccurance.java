
import java.util.Arrays;

public class FirstAndLastOccurance {

     public static int lowerBound(int arr[], int n, int target){

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] >= target) high = mid - 1;

            else low = mid + 1;

        }
        return low;
    }

    public static int upperBound(int arr[], int n, int target){

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] > target) high = mid - 1;

            else low = mid + 1;

        }
        return low;
    }

     public static int firstOccurance(int arr[], int n, int target){

        int low = 0, high = n - 1;

        int left = -1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] == target){
                
                left = mid;

                high = mid - 1;

            }

            else if(arr[mid] > target) high = mid - 1;

            else low = mid + 1;
        }
        return left;

    }
    public static int lastOccurance(int arr[], int n, int target){

        int low = 0, high = n - 1;

        int right = -1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] == target){
                
                right = mid;

                low = mid + 1;

            }

            else if(arr[mid] < target) low = mid + 1;

            else high = mid - 1;
        }
        return right;
    }

    // Brute - O(N)
    public static int[] firstAndLastOccuranceI(int arr[], int n, int target){

        int left = -1, right = -1;

        for(int i = 0 ; i < n ; i++){

            if(arr[i] == target){

                if(left == -1) left = i;

                right = i;

            }

        }
        return new int[]{left,right};

    }

    // Better --> 2 * O(log N)
    public static int[] firstAndLastOccuranceII(int arr[], int n, int target){

        int left = lowerBound(arr, n, target);

        if(left == n || arr[left] != target) return new int[]{-1,-1};

        int right = upperBound(arr, n, target) - 1;

        return new int[]{left, right};

    }

    // Optimal --> O(log N)
    public static int[] firstAndLastOccuranceIII(int arr[], int n, int target){

        int first = firstOccurance(arr, n, target);

        if(first == -1) return new int[]{-1,-1};

        int last = lastOccurance(arr, n, target);

        return new int[]{first,last};

    }
    
    public static void main(String[] args) {
        
        int arr[] = {5,7,7,8,8,10};

        int n = arr.length;

        int target1 = 8, target2 = 6;

        System.out.println(Arrays.toString(firstAndLastOccuranceI(arr,n,target1))); // [3,4] --> O(N)

        System.out.println(Arrays.toString(firstAndLastOccuranceII(arr,n,target2))); // [-1,-1] --> 2 * O(log N)

        System.out.println(Arrays.toString(firstAndLastOccuranceIII(arr,n,target1))); // [3,-4] --> O(log N)

        System.out.println(Arrays.toString(firstAndLastOccuranceIII(arr,n,target2))); // [-1,-1] --> O(log N)

    } 

}
