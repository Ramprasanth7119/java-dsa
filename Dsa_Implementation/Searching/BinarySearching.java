public class BinarySearching {

    public static int binarySearch(int arr[],int target,int left,int right){
        
        while(left <= right){
            int mid = (left + right) / 2;

            if(target == arr[mid]) return mid;
            else if(target < arr[mid]) return binarySearch(arr, target , left , mid-1);
            else if(target > arr[mid]) return binarySearch(arr, target, mid+1, right);
        }
        return -1;
    }
    public static void main(String[] args) {

        int arr[] = {2,4,3,8,10,14};
        int target = 14;
        int left = 0;
        int right = arr.length;

        int ans = binarySearch(arr,target,left,right);

        System.out.println(ans); // TC --> O(log N);
    }
}
