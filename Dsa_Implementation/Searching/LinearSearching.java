class LinearSearching{

    public static boolean linearSearch(int arr[] , int target){
        for(int i:arr){
            if(i == target){
                return true;
            }
        }
        return false;
    }

    public static int linearSearchIndex(int arr[] , int target){
        for(int i:arr){
            if(i == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {2,3,4,7,10};
        int target = 30;

        boolean res = linearSearch(arr,target);

        int ans = linearSearchIndex(arr, target);

        System.out.println(res);
        System.out.println(ans); // TC --> O(N);
    }
}