
import java.util.ArrayList;
import java.util.List;

public class CountInversion {

    // static int cnt = 0; // Either declare it as global variable or inside the function

    public static int merge(int arr[] , int low , int mid , int high){

        int left = low;
        int right = mid + 1;
        int cnt = 0;

        List<Integer> temp = new ArrayList<>();

        while(left <= mid && right <= high){

            if(arr[left] <= arr[right]){

                temp.add(arr[left]);
                left++;

            } else{

                temp.add(arr[right]);
                cnt  += (mid - left + 1);
                right++;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        for(int i = low ; i <= high ; i++){
            arr[i] = temp.get(i - low);
        }

        return cnt;
    }

    public static int mergeSort(int arr[] , int low , int high){

        int cnt = 0;
        
        if(low == high){
            return cnt;
        }

        int mid = (low + high) /2;

        cnt += mergeSort(arr, low, mid);

        cnt += mergeSort(arr, mid + 1, high);

        cnt += merge(arr , low , mid ,high);

        return cnt;

    }
    
    public static void main(String[] args) {
        
        int arr[] = {5,3,2,4,1};

        int n = arr.length;

        int cnt = mergeSort(arr,0,n-1);

        System.out.println(cnt);
    }

}
