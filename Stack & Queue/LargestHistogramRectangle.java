import java.util.*;

public class LargestHistogramRectangle {

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

    public static List<Integer> pse(int arr[]){

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

    public static int largestHistogramRectangleI(int arr[]){

        int n = arr.length;

        List<Integer> nse = nse(arr);

        List<Integer> pse = pse(arr);

        int max = 0 , next = 0 , prev = 0;

        for(int i = 0 ; i < n ; i++){

            max = Math.max(max , (arr[i] * (nse.get(i) - pse.get(i) - 1)));

        }
        return max;
    }

    public static int largestHistogramRectangleII(int arr[]){

        int n = arr.length;

        int max = 0 , pse = 0 , nse = 0 , el = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){

                el = st.pop();

                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();

                max = Math.max(max , arr[el] * (nse - pse - 1));

            }
            st.push(i); // 2,1,5,6,2,3
        }

        while(!st.isEmpty()){

            el = st.pop();

            nse = n;
            pse = st.isEmpty() ? -1 : st.peek();

            max = Math.max(max , arr[el] * (nse - pse - 1));

        }
        return max;
    }
   
    public static void main(String[] args) {
        
        int arr[] = {2,1,5,6,2,3};

        System.out.println(largestHistogramRectangleI(arr)); // O(5N) , O(4N)

        System.out.println(largestHistogramRectangleII(arr)); // O(2N) , O(N)

    }

}
