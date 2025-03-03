
import java.util.Stack;


class Pair{

    int first, second;
    public Pair(int first , int second){

        this.first = first;
        this.second = second;

    }

}
class minStackI{

    Stack<Pair> st;
    public minStackI(){

        st = new Stack<>();

    }

    public void push(int val){

        int min = Integer.MAX_VALUE;

        if(st.isEmpty()) min = val;
        else min = Math.min(val , st.peek().second);

        st.push(new Pair(val , min));

    }

    public void pop() {
        
        st.pop();
    
    }

    public int top(){

        return st.peek().first;

    }

    public int getMin(){

        return st.peek().second;
    
    }
}

class minStackII{

    Stack<Integer> st = new Stack<>();

    int mini = Integer.MAX_VALUE;

    void push(int val){

        if(st.isEmpty()) {
            
            st.push(val); mini = val;
        }

        else {

            if(st.peek() < val) st.push(val);

            else{

                st.push(2 * val - mini);
                mini = val;

            }

        }

    }

    void pop(){

        int val = st.pop();

        if(val < mini) mini = (2 * mini) - val;

    }

    int top(){

        int val = st.peek();

        if(val < mini){

            return mini;

        }

        return val;

    }

    int getMin(){

        return mini;

    }

}

public class MinStack{

    public static void main(String[] args) {
        
        minStackI s1 = new minStackI();   // TC --> O(1) , SC --> O(2N) , To store pair variables.

        s1.push(12);  s1.push(15);  s1.push(10); // [12,15,10]

        s1.pop(); // [12,15]

        System.out.println("Top :" + s1.top()); // 15

        System.out.println("Min :" + s1.getMin()); // 12

        s1.pop();   s1.push(10); // [12,10]
 
        System.out.println("Top :" + s1.top()); // 10

        System.out.println("Min :" + s1.getMin());   // 10 
        
        minStackII s2 = new minStackII(); // TC --> O(1) , SC --> O(N)

        s2.push(12);  s2.push(15);  s2.push(10);

        s2.pop();

        System.out.println(s2.top());

        System.out.println(s2.getMin());

        s2.pop();   s2.push(10);
 
        System.out.println(s2.top());

        System.out.println(s2.getMin());    

    }

}