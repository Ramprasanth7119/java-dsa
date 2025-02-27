import java.util.*;

public class PrefixToPostfix {
    

    public static String prefixToPostfix(String s){

        int i = 0 , n = s.length();

        Stack<String> st = new Stack<>(); // O(N) {SC}

        while(i < n){  // O(N)

            char ch = s.charAt(i);

            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch >= '0' && ch <= 9) st.push(ch + "");  // O(1)

            else {

                String op2 = st.pop();
                String op1 = st.pop();

                st.push(op1 + op2 + ch);

            }

            i++;

        }
        return st.peek();

    }

    public static void main(String[] args) {

        String s1 = "*-+435/+243";

        String s2 = "*+AB-CD";

        System.out.println(prefixToPostfix(s1)); // TC --> O(N) + O(N) , SC --> O(N)

        System.out.println(prefixToPostfix(s2)); // TC --> O(N) + O(N) , SC --> O(N)

    }

}
