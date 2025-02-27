import java.util.*;

public class BalancedParenthesis {

    public static boolean valid(String s){

        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){

            char x = s.charAt(i);

            if(x == '(' || x == '{' || x == '[') st.push(x); 

            else{

                if(st.isEmpty()) return false;

                char ch = st.peek(); st.pop();

                if( (x == ')' && ch == '(') || (x == ']' && ch == '[') || (x == '}' && ch == '{')) continue;

                else return false;

            }

        }
        return st.isEmpty();
    }

    
    
    public static void main(String[] args) {
        
        List<String> str = new ArrayList<>();

        str.add("()[{}()]");
        str.add("()[{}(])");
        str.add("((){}[])");
        str.add("([{}]]");


        List<String> ans = new ArrayList<>();

        for(int i = 0 ; i < str.size() ; i++){

            if(valid(str.get(i))){

                ans.add("true");

            } else {

                ans.add("false");

            }

        }

        for(String i : ans) System.out.print(i + " "); // [true, false, true, false]

    }

}
