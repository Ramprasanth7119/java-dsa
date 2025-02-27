import java.util.*;
public class PrefixToInfix {

    public static String prefixToInfix(String s){

        int n = s.length() , i = n - 1;

        Stack<String> st = new Stack<>();

        while(i >= 0){

            char ch = s.charAt(i);

            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch >= '0' && ch <= 9) st.push(ch + "");  // O(1)

            else {

                String s1 = st.pop();
                String s2 = st.pop();

                String res = "(" + s1 + ch + s2 + ")";

                st.push(res);

            }

            i--;
        }

        return st.peek();
        
    }
    

    public static void main(String[] args) {

        String s1 = "+a*b-^cde";

        String s2 = "+-*+abcdf";

        String s3 = "*+pq-mn";

        System.out.println(prefixToInfix(s1)); // TC --> O(N) , SC --> O(N)

        System.out.println(prefixToInfix(s2)); // TC --> O(N) , SC --> O(N)

        System.out.println(prefixToInfix(s3)); // TC --> O(N) , SC --> O(N)



    }

}
