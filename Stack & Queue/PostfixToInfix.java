import java.util.*;

public class PostfixToInfix {

    public static String postfixToInfix(String s){

        int i = 0 , n = s.length();

        Stack<String> st = new Stack<>();

        while( i < n){

            char ch = s.charAt(i);

            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch >= '0' && ch <= 9) st.push(ch + "");  // O(1))

            else{

                String s1 = st.pop();
                String s2 = st.pop();

                String res = "(" + s2 + ch + s1 + ")";

                st.push(res);

            }

            i++;
        }
        return st.peek();

    }
    

    public static void main(String[] args) {
        
        String s1 = "abcd^e-*+";

        String s2 = "ab+c*d-f+";

        System.out.println(postfixToInfix(s1));

        System.out.println(postfixToInfix(s2));

    }
}
