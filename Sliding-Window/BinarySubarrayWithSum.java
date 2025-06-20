 
 
public class BinarySubarrayWithSum{

    public static int binarySubarrayWithSum(int arr[] , int goal){

        int n = arr.length;

        if(goal < 0) return 0;

        int left = 0 , right = 0 , sum = 0 , cnt = 0;

        while(right < n){

            sum += arr[right];

            while(sum > goal){

                sum -= arr[left];
                left++;

            }
            cnt += (right - left + 1);
            right++;
        }
        
        return cnt;
    }


    public static void main(String[] args) {
        
        int arr[] = {1,0,1,0,1};

        int goal = 2;

        int result = binarySubarrayWithSum(arr, goal) - binarySubarrayWithSum(arr, goal - 1);

        System.err.println(result);
    }
}
