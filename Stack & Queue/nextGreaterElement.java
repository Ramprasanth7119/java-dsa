import java.util.*;

// Monotonic Stack
public class nextGreaterElement {

    public static List<Integer> nge(int arr[]){

        List<Integer> res = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        int n = arr.length;

        for(int i = n - 1 ; i >= 0 ; i--){

            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();

            if(st.isEmpty()) res.add(-1);

            else res.add(st.peek());

            st.push(arr[i]);

        }

        return res;

    }
    
    public static void main(String[] args) {
        
        int arr[] = {4,12,5,3,1,2,5,3,1,2,4,6};

        List<Integer> ans = nge(arr);  // TC --> O(2N) , SC --> O(2N)

        for(int i = ans.size() - 1 ; i >= 0 ; i--) System.out.print(ans.get(i) + " ");
        // OP ->  [12,-1,6,5,2,5,6,4,2,4,6,-1]

    }

}
