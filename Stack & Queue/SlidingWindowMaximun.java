import java.util.*;

public class SlidingWindowMaximun {

    public static int[] slidingWindowMaximumI(int arr[] , int n , int k){

        int ans[] = new int[n - k + 1];

        int max = 0 , ind = 0;

        for(int i = 0 ; i < n - k + 1; i++){

            max = arr[i];

            for(int j = i ; j < i + k ; j++){

                max = Math.max(max , arr[j]);

            }

            ans[ind++] = max;

        }
        return ans;
    }

    public static List<Integer> slidingWindowMaximumII(int arr[] , int n ,int k){

        List<Integer> ls = new ArrayList<>();

        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){

            if(!dq.isEmpty() && dq.peekFirst() <= i - k)  dq.pollFirst();

            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.pollLast();

            dq.addLast(i);

            if(i >= k - 1) ls.add(arr[dq.peekFirst()]);

        }

        return ls;

    }

    public static void main(String[] args) {
        
        int arr[] = {1,3,-1,-3,5,3,2,1,6};

        int n = arr.length;

        int k = 3;

        int ans[] = slidingWindowMaximumI(arr , n , k); // TC --> O(N - K) * K , SC --> O(N-K)

        for(int i : ans) System.out.print(i + " ");

        System.out.println();

        List<Integer> ls = slidingWindowMaximumII(arr, n, k); // TC --> O(2N) , SC --> O(K) + O(N - K) 

        for(int i : ls) System.out.print(i + " ");



    }

}
