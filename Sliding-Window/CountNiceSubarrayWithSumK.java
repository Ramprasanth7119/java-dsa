
public class CountNiceSubarrayWithSumK {

    
    // Check for Odd values in the array with sum K
    
    public static int countNiceSubarrayWithSumK(int arr[] , int goal){

        int n = arr.length;

        if(goal < 0) return 0;

        int left = 0 , right = 0 , cnt = 0 , sum = 0;

        while(right < n){

            sum += arr[right] % 2;

            while(sum > goal){

                sum -= arr[left] % 2;
                left++;

            }

            cnt += (right - left + 1);
            right++;

        }

        return cnt;

    }
    
    public static void main(String[] args) {
        
        int arr[] = {2,2,2,1,2,2,1,2,2,2};

        int goal = 2;

        int result = countNiceSubarrayWithSumK(arr, goal) - countNiceSubarrayWithSumK(arr, goal - 1);

        System.out.println(result);

    }

}
