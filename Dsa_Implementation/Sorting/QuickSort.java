public class QuickSort {

    public static void quickSort(int[] arr){

        int n = arr.length;

    }
    public static void main(String[] args) {
        int arr[] = {3,4,2,1,6,9,10,5,7,8};

        System.out.println("The initial Array");

        for(int i : arr){
            System.out.print(i+" ");
        }

        System.out.println();

        System.out.println("After Sorting...");

        quickSort(arr);

        for(int i:arr){
            System.out.print(i+" ");  // TC --> O(N log N);
        }
    }
}