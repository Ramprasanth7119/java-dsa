
public class SelectionSort {

    public static void selectionSort(int[] arr){

        int n = arr.length;
        int minIndex = -1;

        for(int i=0;i<n;i++){

            minIndex = i;
            for(int j = i+1;j<n;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

       
    }
    public static void main(String[] args) {
        int arr[] = {3,4,2,1,6,9,10,5,7,8};

        System.out.println("The initial Array");

        for(int i : arr){
            System.out.print(i+" ");
        }

        System.out.println();

        System.out.println("After Sorting...");

        selectionSort(arr);

        for(int i:arr){
            System.out.print(i+" ");  // TC --> O(N^2);
        }
    }
}
