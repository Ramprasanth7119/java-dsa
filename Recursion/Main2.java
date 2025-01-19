import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2 {
 
    public static void swap(int arr[],int n1,int n2){

        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public static void merge(int arr[] , int low , int mid , int high){

        int left = low;
        int right = mid + 1;

        List<Integer> temp = new ArrayList<>();

       while(left <= mid && right <= high){

            if(arr[left] <= arr[right]){

                temp.add(arr[left]);
                left++;

            } else{

                temp.add(arr[right]);
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
         arr[i] = temp.get(i-low);
       }
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void mergeSort(int arr[] , int low , int high){

        if(low == high){
            return;
        }
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);

        mergeSort(arr,mid+1,high);

        merge(arr,low,mid,high);
    }

    public static int partition(int arr[] , int low , int high){

        int i = low;
        int j = high;
        int pivot = arr[low];

        while(i<j){

            while(arr[i] <= pivot && i <= high-1){
                i++;
            }

            while(arr[j] > pivot && j >= low+1){
                j--;
            }

            if(i<j){
                swap(arr , i , j);
            }
        }

        swap(arr,low,j);

        return j;
    }

    public static void quickSort(int arr[] , int low , int high){

        if(low < high){

            int pIndex = partition(arr,low,high);

            quickSort(arr,low,pIndex-1);

            quickSort(arr,pIndex+1,high);
        }
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void combinationSumI(int ind , int arr[] , int target , List<List<Integer>> ans , List<Integer> temp , int n){
        
        if(ind == n){
            if(target == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(arr[ind] <= target){

            temp.add(arr[ind]);
            combinationSumI(ind, arr, target-arr[ind], ans, temp, n);
            temp.remove(temp.size()-1);
        }

        combinationSumI(ind+1,arr,target,ans,temp,n);

    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void combinationSumII(int ind , int arr[] , int target , List<List<Integer>> ans , List<Integer> temp , int n){
        
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = ind ; i < n ; i++){

            if(i > ind && arr[i] == arr[i-1]) continue;

            if(arr[i] > target) break;

            temp.add(arr[i]);
            combinationSumII(ind + 1, arr, target - arr[i], ans, temp, n);
            temp.remove(temp.size() - 1);

        }
    }

    public static void subsetSumI(int ind , int arr[] , List<Integer> ans , int n , int sum){

        if(ind == n){
            ans.add(sum);
            return;
        }

        subsetSumI(ind + 1, arr , ans , n , sum + arr[ind]);

        subsetSumI(ind + 1, arr, ans, n, sum);
    }

    public static void subsetSumII(int ind , int arr[] , List<Integer> temp  , List<List<Integer>> ans , int n){
        ans.add(new ArrayList<>(temp));

        for(int i = ind ; i < n ; i++){
            
            if(i != ind && arr[i] == arr[i-1]) continue;

            temp.add(arr[i]);
            subsetSumII(i + 1,arr,temp,ans,n);
            temp.remove(temp.size() - 1);

        }
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,4,3,5};

        int target = 4;

        int len = arr.length;

        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> sum = new ArrayList<>();

        System.out.print("Before Sorting : ");
        for(int i = 0;i<len;i++){
            
            System.out.print(arr[i]+" ");
 
        }
        System.out.println();

        mergeSort(arr, 0, len - 1); // O(N Log N)  // SpaceComplexity --> O(N)

        quickSort(arr, 0, len-1);  // O(N Log N) // SpaceComplexity --> O(1)  // WorstCase --> O(N*2)

        combinationSumI(0, arr, target, ans, new ArrayList<>(), len);  // O(2 ^ n)

        combinationSumII(0, arr, target, ans, new ArrayList<>(), len);  // O(2 ^ n * k);

        subsetSumI(0, arr, sum, len, 0); // O(2 ^ N * log(2 ^ N))

        subsetSumII(0, arr, new ArrayList<>(), ans, len); // O(2 ^ n * N)  // O(2 ^ N) *  O(K) O(N) 

        Collections.sort(sum);

        System.out.print("After Sorting : ");
        for(int i = 0;i<len;i++){
            
            System.out.print(arr[i]+" ");
        }

        for(List<Integer> i : ans){
            System.out.println(i);
        }

        for(int i : sum){
            System.out.print(i + " ");
        }

    }
}
