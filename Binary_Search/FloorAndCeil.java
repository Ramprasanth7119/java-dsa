
public class FloorAndCeil {

    public static int floor(int arr[],int n, int el){

        int low = 0, high = n - 1;

        int ans = -1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] <= el){

                ans = arr[mid];

                low = mid + 1;

            } else{

                high = mid - 1;

            }
        }
        return ans;

    }
    
     public static int ceil(int arr[], int n, int target){
        int low = 0, high = n - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] >= target) high = mid - 1;

            else low = mid + 1;

        }
        return arr[low];
     }
    public static void main(String[] args) {
        
        int arr[] = {10, 20, 30, 40, 50};

        int n = arr.length;

        int target = 25;

        System.out.println(floor(arr, n, target)); // 20

        System.out.println(ceil(arr, n, target)); // 30

    }

}
