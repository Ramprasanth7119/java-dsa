
import java.util.Stack;


public class RemoveKDigits {

    public static String removekdigits(String s, int k){

        int n = s.length();

        Stack<Character> st = new Stack<>();

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

        if(st.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();

        while(!st.isEmpty()){

            res.append(st.pop());

        }

        while(res.length() != 0 && res.lastIndexOf(s) == '0'){

            int ind = res.lastIndexOf(s);

            res.deleteCharAt(ind);

        }

        StringBuilder ans = new StringBuilder();

        for(int i = res.length() - 1 ; i >= 0 ; i--){

            ans.append(res.charAt(i));

        }

        return ans.toString();

    }
    
    public static void main(String[] args) {
        
        String s = "1432219";

        System.out.println(removekdigits(s , 3));

    }

}
