public class InsertionSort {

    public static void insertionSort(int[] arr){

        int n = arr.length;

        int key = 0;
        int j = 0;

        for(int i=1;i<n;i++){
            j = i - 1;
            key = arr[i];
            while (j >= 0 && arr[j] > key) { 
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,4,2,1,6,9,5,7,8};

        System.out.println("The initial Array");

        for(int i : arr){
            System.out.print(i+" ");
        }

        System.out.println();

        System.out.println("After Sorting...");

        insertionSort(arr);

        for(int i:arr){
            System.out.print(i+" ");  // TC - Average & Worst case-> O(N^2);
                                      // TC - Best case-> O(N);
        }
    }
}
