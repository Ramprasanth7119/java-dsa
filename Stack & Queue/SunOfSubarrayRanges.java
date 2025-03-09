
import java.util.*;

public class SunOfSubarrayRanges{

    public static int sumOfSubarrayRangesI(int arr[]){

        int n = arr.length;

        int large = 0 , small = 0 , res = 0;

        for(int i = 0 ; i < n ; i++){

            large = arr[i];
            small = arr[i];

            for(int j = i + 1 ; j < n ; j++){

                large = Math.max(large , arr[j]);
                small = Math.min(small , arr[j]);

                res += large - small;

            }

        }
        return res;
    }

    public static List<Integer> nse(int arr[]){

        int n = arr.length;

        List<Integer> temp = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1 ; i >= 0 ; i--){

            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();

            temp.add(st.isEmpty() ? n : st.peek());

            st.push(i);

        }

        Collections.reverse(temp);

        return temp;

    }

    public static List<Integer> psee(int arr[]){

        int n = arr.length;

        List<Integer> temp = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){

            while(!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();

            temp.add(st.isEmpty() ? -1 : st.peek());

            st.push(i);

        }
        return temp;
    }

    public static int sumOfMinSubarray(int arr[]){

        int n = arr.length;

        List<Integer> nse = nse(arr);

        List<Integer> pse = psee(arr);

        int prev = 0 , next = 0 , ans = 0;

        int mod = (int)(1e9) + 7;

        for(int i = 0 ; i < n ; i++){

            prev = i - pse.get(i);

            next = nse.get(i) - i;

            ans = (ans + (prev * next * arr[i]) % mod) % mod;

        }
        return ans;
    }

    public static int sumOfMaxSubarray(int arr[]){

        int  n = arr.length;

        int min = 0 , mod = (int) (1e9) + 7 , sum = 0;

        for(int i = 0 ; i < n ; i++){

            min = arr[i];

            for(int j = i ; j < n ; j++){

                min = Math.min(min , arr[j]);

                sum += min % mod;

            }

        }
        return sum;
    }

    public static int sumOfSubarrayRangesII(int arr[]){

        return sumOfMinSubarray(arr) - sumOfMaxSubarray(arr);

    }

    public static void main(String args[]){

        int arr[] = {3,1,2,4};

        System.out.println(sumOfSubarrayRangesI(arr)); // O(N^2) , O(1)

        System.out.println(sumOfSubarrayRangesII(arr)); // O(10) , O(10)

    }

}