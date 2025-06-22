
import java.util.*;

public class SearchInRotatedSortedArray {


    public static int search(List<Integer> arr, int n, int k) {
       int low = 0, high = n - 1;

       while(low <= high){
           int mid = (low + high) / 2;

           if(arr.get(mid) == k) return mid;

           if(arr.get(low) <= arr.get(mid)){

               if(arr.get(low) <= k && k <= arr.get(mid)){

                   high = mid - 1;

               } else{

                   low = mid + 1;

               }

           } else{

               if(arr.get(mid) <= k && k <= arr.get(high)){

                   low = mid + 1;

               } else {

                   high = mid - 1;

               }

           }
       }
       return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2));
        int n = arr.size();
        int k = 0;

        int result = search(arr, n, k);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}