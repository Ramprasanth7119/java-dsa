import java.util.Stack;

public class InfixToPostfix {

    public static int getPriority(char ch){

        if(ch == '^') return 3;

        else if(ch == '*' || ch == '/') return 2;

        else if(ch == '+' || ch == '-') return 1;

        return -1;

    }
    
    public static String infixToPostFix(String s){

        int n = s.length() , i = 0;

        Stack<Character> st = new Stack<>(); // O(N) {SC}

        String ans = "";

        while(i < n){  // O(N)

            char ch = s.charAt(i);

            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch >= '0' && ch <= 9) ans += ch;  // O(1)

            else if(ch == '(') st.push(ch); // O(1)
 
            else if(ch == ')') {

                while(!st.isEmpty() && st.peek() != '(') {  // O(N)
                     
                    ans += st.peek(); 
                    st.pop();
                }

                st.pop();

            }

            else {

                while(!st.isEmpty() && getPriority(ch) <= getPriority(st.peek())) { // O(N)
                    
                    ans += st.peek();
                    st.pop();
                }

                st.push(ch);

            }

            i++;

        }

        while(!st.isEmpty()){

            ans += st.peek();
            st.pop();

        }

        return ans;

    }

    public static void main(String[] args) {

        String s1 = "a+b*(c^d-e)";

        String s2 = "(a+b)*c-d+f";

        System.out.println(infixToPostFix(s1)); // TC --> O(N) + O(N) , SC --> O(N) + O(N)

        System.out.println(infixToPostFix(s2)); // TC --> O(N) + O(N) , SC --> O(N) + O(N)

    }

}
