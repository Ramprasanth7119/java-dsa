import java.util.ArrayList;
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

    public static void main(String[] args) {
        
        int arr[] = {1,4,3,5,2,7,6,9,8};

        int len = arr.length;

        System.out.print("Before Sorting : ");
        for(int i = 0;i<len;i++){
            
            System.out.print(arr[i]+" ");

        }
        System.out.println();

         mergeSort(arr, 0, len - 1);

        quickSort(arr, 0, len-1);


        System.out.print("After Sorting : ");
        for(int i = 0;i<len;i++){
            
            System.out.print(arr[i]+" ");
        }
    }
}
