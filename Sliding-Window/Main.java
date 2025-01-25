


public class Main {

    public static int longestSubarrayLengthLessThanK(int arr[] , int k){

        int left = 0 , tempLeft = 0;
        int right = 0 , tempRight = 0;
        int maxIndex = 0;
        int sum = 0;

        int n = arr.length;
  
        while(right < n){
            sum += arr[right];
            while(sum >= k){
                sum -= arr[left];
                left++;
            }
            // maxIndex = Math.max(maxIndex , right - left + 1);
            if(right - left + 1 > maxIndex){
                maxIndex = right - left + 1;
                tempLeft = left;
                tempRight = right;
            }
            right += 1;

        }

        for(int i = tempLeft ; i <= tempRight ; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        return maxIndex;

    }
    public static void main(String[] args) {

        int arr[] = {2,5,1,7,10};

        int k = 14;

        System.out.println(longestSubarrayLengthLessThanK(arr, k));
    }

}
