
import java.util.*;


public class nextGreaterElementII{

    public static List<Integer> ngeI(int arr[]){

        List<Integer> ans = new ArrayList<>();

        int n = arr.length;

        for(int i = 0 ; i < n ; i++){

            int found = -1;

            for(int j = i + 1 ; j < i + n  ; j++){

                int ind = j % n;

                if(arr[ind] > arr[i]){

                    found = arr[ind];

                    break;

                } 
            
            }

            ans.add(found);

        }

        return ans;

    }

    public static List<Integer> ngeII(int arr[]){

        int n = arr.length;

        List<Integer> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for(int i = 2 * n - 1 ; i >= 0 ; i--){

            while(!st.isEmpty() && st.peek() <= arr[i % n]) st.pop();

            if(i < n){

                ans.add(st.isEmpty() ? -1 : st.peek());

            }

            st.push(arr[i % n]);

        }

        return ans;

    }

    public static void main(String[] args) {
        
        int arr1[] = {2,10,12,1,11};

        int arr2[] = {2,10,12,1,11};

        List<Integer> l1 = ngeI(arr1);  // TC --> O(N^2) , SC --> O(N)

        List<Integer> l2 = ngeII(arr2); // TC --> O(4N) , SC --> O(2N)

        for(int i : l1) System.out.print(i + " ");

        System.out.println();
        
        for(int i : l2) System.out.print(i + " ");

    }

}