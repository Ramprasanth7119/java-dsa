import java.util.*;

public class nearestSmallestElement {

    public static List<Integer> nseI(int arr[]){

        int n = arr.length;

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){

            int found = -1;

            for(int j = i - 1 ; j >= 0 ; j--){

                if(arr[j] < arr[i]){

                    found = arr[j];
                    break;

                }

            }

            ans.add(found);

        }
        return ans;

    }

    public static List<Integer> nseII(int arr[]){

        int n = arr.length;

        List<Integer> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){

            while(!st.isEmpty() && st.peek() >= arr[i]) st.pop();

            ans.add(st.isEmpty() ? -1 : st.peek());

            st.push(arr[i]);

        }
        return ans;

    }
    

    public static void main(String[] args) {
        
        int arr[] = {6,5,2,4,7,5,4,2,9,4,2,1};

        List<Integer> nse1 = nseI(arr); // TC --> O(N^2) , SC --> O(N)

        List<Integer> nse2 = nseII(arr); // TC --> O(2N) , SC --> O(N) + o(N)

        for(int i : nse1) System.out.print(i + " "); 
 
        System.out.println();

        for(int i : nse2) System.out.print(i + " ");

        // OP --> [-1,-1,-1,2,4,4,2,-1,2,2,-1,-1]

    }

}
