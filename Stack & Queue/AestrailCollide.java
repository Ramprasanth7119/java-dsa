import java.util.*;

public class AestrailCollide {

    public static Stack<Integer> aestrailCollide(int arr[]){

        int  n = arr.length;

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){

            if(arr[i] > 0) st.push(arr[i]);

            else{

                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])) st.pop();

                if(!st.isEmpty() && st.peek() == Math.abs(arr[i])) st.pop();

                else if(st.isEmpty() || st.peek() < 0) st.push(arr[i]);

            }

        }
        return st;

    }
    
    public static void main(String[] args) {
        
        int arr1[] = {4,7,1,1,2,-3,-7,17,15,-19,-18};
        
        int arr2[] = {4,7,1,1,2,-3,-7,17,15};

        Stack<Integer> st1 = aestrailCollide(arr1); // O(2N) , O(N)

        System.out.println(st1);

        Stack<Integer> st2 = aestrailCollide(arr2);

        System.out.println(st2);

    }
}
