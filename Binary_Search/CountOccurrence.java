

public class CountOccurrence{

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
    public static int countOccuranceI(int arr[], int n, int target){

        int left = -1, right = -1;

        for(int i = 0 ; i < n ; i++){

            if(arr[i] == target){

                if(left == -1) left = i;

                right = i;

            }

        }
        return right - left + 1;

    }

    // Better --> 2 * O(log N)
    public static int countOccuranceII(int arr[], int n, int target){

        int left = lowerBound(arr, n, target);

        if(left == n || arr[left] != target) return 0;

        int right = upperBound(arr, n, target) - 1;

        return right - left + 1;

    }

    // Optimal --> O(log N)
    public static int countOccuranceIII(int arr[], int n, int target){

        int first = firstOccurance(arr, n, target);

        if(first == -1) return 0;

        int last = lastOccurance(arr, n, target);

        return last - first + 1;

    }
    
    public static void main(String[] args) {
        
        int arr[] = {5,7,7,7,8,8,10};

        int n = arr.length;

        int target1 = 7, target2 = 1;

        System.out.println(countOccuranceI(arr,n,target1)); // 3 --> O(N) 

        System.out.println(countOccuranceII(arr,n,target2)); // 0 --> 2 * O(log N)

        System.out.println(countOccuranceIII(arr,n,target1)); // 3 --> O(log N)

        System.out.println(countOccuranceIII(arr,n,target2)); // 0 --> O(log N)

    } 

}

