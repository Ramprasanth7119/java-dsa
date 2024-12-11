
public class BubbleSort {

    public static void bubbleSort(int[] arr){

        int n = arr.length;

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < n - i - 1 ; j++){

                if(arr[j] > arr[j+1]){

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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

        bubbleSort(arr);

        for(int i:arr){
            System.out.print(i+" ");  // TC --> O(N^2);
        }
    }
}
