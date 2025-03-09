import java.util.*;

public class SumOfMinimumSubArrayElements {

    public static int sumOfMinimumSubArrayElementsI(int arr[]){

        int n = arr.length;

        int mini = 0 , ans = 0;

        int mod = (int) (1e9 + 7);

        for(int i = 0 ; i < n ; i++){

            mini = arr[i];

            for(int j = i ; j < n ; j++){

                mini = Math.min(mini , arr[j]);
                System.out.print(mini + " ");

                ans = (ans + mini) % mod;

            }
            System.out.println();
        }
        return ans;

    }

    public static int sumOfMinimumSubArrayElementsII(int arr[]){

        int n = arr.length;

        List<Integer> nse = nse(arr);

        for(int i : nse) System.out.print(i + " ");

        System.out.println();

        List<Integer> pse = psee(arr);

        for(int i : pse) System.out.print(i + " ");

        System.out.println();

        int mod = (int) (1e9 + 7);

        int next = 0 , prev = 0 , ans = 0;

        for(int i = 0 ; i < n ; i++){

            next = nse.get(i) - i;

            prev = i - pse.get(i);

            System.out.println("next : " + next + " prev : " + prev);

            ans = (ans + (next * prev  * arr[i]) % mod) % mod;

        }
        return ans;
    }

    public static List<Integer> nse(int arr[]){

        List<Integer> temp = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        int n = arr.length;

        for(int i = n - 1 ; i >= 0 ; i--){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();

            temp.add(st.isEmpty() ? n : st.peek());

            st.push(i);

        }
        Collections.reverse(temp);
        
        return temp;
    }

    public static List<Integer> psee(int arr[]){

        List<Integer> temp = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        int n = arr.length;

        for(int i = 0 ; i < n ; i++){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();

            temp.add(st.isEmpty() ? -1 : st.peek());

            st.push(i);
            
        }
        return temp;
    }

    public static void main(String[] args) {
        
        int arr[] = {3,1,2,4};

        System.out.println(sumOfMinimumSubArrayElementsI(arr));

        System.out.println(sumOfMinimumSubArrayElementsII(arr));

    }

}
