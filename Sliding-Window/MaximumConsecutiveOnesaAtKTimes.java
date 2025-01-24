

public class MaximumConsecutiveOnesaAtKTimes {

    // Brute Force TC --> O(N * N) SC --> O(1)
    public static int maximumConsecutiveOnesaAtKTimesI(int arr[] , int k){

        int n  = arr.length;

        int maxLen = 0;

        for(int i = 0 ; i < n ; i++){

            int zero = 0;

            for(int j = i ; j < n ; j++){

                if(arr[j] == 0) zero++;

                if(zero <= k){
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen , len);
                }

                if(zero > k) break;
            }
        }
        return maxLen;
    }

        // Better Solution TC --> O(N) + O(N) = O(2N)  SC --> O(1)
    public static int maximumConsecutiveOnesaAtKTimesII(int arr[] , int k){

        int n = arr.length;

        int left = 0 , right = 0 , zero = 0 , maxLen = 0;

        while(right < n){

            if(arr[right] == 0) zero++;

            while(zero > k){
                
                if(arr[left] == 0) zero--;
                left++;

            }

            if(zero <= k){
                maxLen = Math.max(maxLen , right - left + 1);
            }

            right++;
        }
        return maxLen;
    }

    // Optimal TC --> O(N) SC --> O(1)
    public static int maximumConsecutiveOnesaAtKTimesIII(int arr[] , int k){

        int n = arr.length;

        int left = 0 , right = 0 , maxLen = 0 , zero = 0;

        while(right < n){

            if(arr[right] == 0) zero++;

            if(zero > k){

                if(arr[left] == 0) zero--;
                left++;
            }

            if(zero <= k) maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};

        int k = 2;

        System.out.println(maximumConsecutiveOnesaAtKTimesI(arr, k));      // Brute Force TC --> O(N * N) SC --> O(1)

        System.out.println(maximumConsecutiveOnesaAtKTimesII(arr, k));      // Better Solution TC --> O(N) + O(N) = O(2N)  SC --> O(1)

        System.out.println(maximumConsecutiveOnesaAtKTimesIII(arr, k));     // Optimal TC --> O(N) SC --> O(1)
    }
}
