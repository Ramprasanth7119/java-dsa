
import java.util.Stack;

public class InfixConversions {

    public static int getPriority(char ch){

        if(ch == '^') return 3;

        else if(ch == '*' || ch == '/') return 2;
 
        else if(ch == '+' || ch == '-') return 1;

        return -1;

    }

    public static String reverse(String str){

        int n = str.length();

        StringBuilder ans = new StringBuilder();

        for(int i =  n - 1 ; i >= 0 ; i--){

            ans.append(str.charAt(i));

        }

        for(int i = 0 ; i < n ; i++){

            if(ans.charAt(i) == '(') ans.setCharAt(i, ')');

            else if(ans.charAt(i) == ')') ans.setCharAt(i, '(');

        }

        return ans.toString();

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

    public static String infixToPrefix(String s){

        int n = s.length() , i = 0;

        Stack<Character> st = new Stack<>(); // O(N)

        String ans = "";

        s = reverse(s); // O(N/2)

        while(i < n){ // O(N)

            char ch = s.charAt(i);

            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch >= '0' && ch <= 9) ans += ch;

            else if(ch == '(') st.push(ch);

            else if(ch == ')'){

                while(!st.isEmpty() && st.peek() != '('){

                    ans += st.peek();
                    st.pop();

                }

                st.pop(); // Remove the opening bracket;

            }

            else {

                if(ch == '^'){

                    while(!st.isEmpty() && getPriority(ch) <= getPriority(st.peek())) {
                            
                        ans += st.peek();
                        st.pop();
                    }

                } 
                else {

                    while(!st.isEmpty() && getPriority(ch) < getPriority(st.peek())){
                        
                        ans += st.peek();
                        st.pop();
                    }

                }

                st.push(ch);
            }
            i++;

        }

        while(!st.isEmpty()){
                        
            ans += st.peek();
            st.pop();
        }

        System.out.println(ans + " :");

        ans = reverse(ans);

        return ans;

    }
    
    public static void main(String[] args) {
        
        // String s = "(a+b)*c+d/(e+f)";

        String s = "a+b*(c^d-e)";

        String s2 = "(a+b)*c-d+f";

        System.out.println(infixToPostFix(s)); // TC --> O(N) + O(N) , SC --> O(N) + O(N)

        System.out.println(infixToPrefix(s2)); // TC --> O(3N) , SC --> O(N)

    }

}
