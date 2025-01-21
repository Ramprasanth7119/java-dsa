
public class MaximumPointsFromCards {

    public static int maximumPointsFromCardsSum(int arr[] , int k){

        int lsum = 0 , rsum = 0;


        int n = arr.length;

        for(int i = 0 ; i < k ; i++){
            lsum += arr[i];
        }

        int maxsum = lsum;
        // int rIndex = n - 1;
        // for(int i = k - 1 ; i >= 0 ; i--){
        //     lsum -= arr[i];
        //     rsum += arr[rIndex];
        //     rIndex--;
        //     maxsum = Math.max(maxsum , rsum + lsum);
        // }

        for(int i = 0 ; i < k ; i++){

            lsum -= arr[k-i-1];

            rsum += arr[n-i-1];

            maxsum = Math.max(maxsum , rsum + lsum);
            
        }
        return maxsum;
    }

    public static void main(String[] args) {

        int arr[] = {6,2,3,4,7,2,1,7,1};

        int k = 4;

        System.out.println(maximumPointsFromCardsSum(arr, k));

        
    }
}
