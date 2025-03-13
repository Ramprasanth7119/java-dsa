
import java.util.*;

public class PostfixToPrefix {

    public static String postfixToPrefix(String s){

        int n = s.length() , i = 0;

        Stack<String> st = new Stack<>();

        while(i < n){

            char ch = s.charAt(i);

            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch >= '0' && ch <= 9) st.push(ch + "");  // O(1)

            else {

                String s2 = st.pop();
                String s1 = st.pop();

                String res = ch + s1 + s2;

                st.push(res);

            }

            i++;
        }

        return st.peek();

    }
    
    public static void main(String[] args) {
        
        String s1 = "453*24/+-";

        String s2 = "AB+CD-*";

        System.out.println(postfixToPrefix(s1));

        System.out.println(postfixToPrefix(s2));

    }

}
