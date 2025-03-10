
import java.util.Stack;


public class RemoveKDigits {

    public static String removekdigits(String s, int k){

        int n = s.length();

        Stack<Character> st = new Stack<>();

        if(k == n) return "0";

        for(int i = 0 ; i < n ; i++){

            while(!st.isEmpty() && k > 0 && st.peek() - '0' > s.charAt(i) - '0'){

                st.pop();
                k--;

            }

            st.push(s.charAt(i));

        }

        while(k > 0){

            st.pop();
            k--;

        }

        StringBuilder res = new StringBuilder();

        while(!st.isEmpty()){

            res.append(st.pop());

        }

        res.reverse();

        while(res.length() > 1 && res.charAt(0) == '0'){

            res.deleteCharAt(0);

        }

        return res.toString();

    }
    
    public static void main(String[] args) {
        
        String s = "10200";

        System.out.println(removekdigits(s , 1));

    }

}
