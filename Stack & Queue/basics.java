import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {

    int data;
    Node next;

    public Node(int data , Node next){
        this.data = data;
        this.next = next;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
    }

}

class stack{

    int arr[] = new int[10];

    int top = -1;

    void push(int x){
         
        if(top == arr.length - 1){
            System.out.println("Stack OverFlow..");
            return;
        }

        top++;
        arr[top] = x;
    }

    void pop(){

        if(top == -1) System.out.println("There is no element..");

        top--;

    }

    int Top(){

        return arr[top];

    }

    int size(){

        return top + 1;

    }

}

class queue{

    int start = -1 , end = -1 , cursize = 0;

    int arr[] = new int[10];

    void push(int x){

        if(cursize == arr.length){

            System.out.println("Queue Overflow..");
            return;

        }

        if(cursize == 0){

            start = 0;
             end = 0;

        } else{

            end = (end + 1) % arr.length;

        } 
        arr[end] = x;
        cursize++;

    }

    int pop(){

        if(cursize == arr.length){

            System.out.println("Queue Overflow..");
            return 0;

        }

        int el = arr[start];

        if(cursize == 1){

            start = -1;
            end = -1;

        } else{

            start = (start + 1) % arr.length;

        }
        cursize--;
        return el;

    }

    int top(){

        return arr[start];

    }

    int size(){
        
        return cursize;

    }

}

class stUsingLL{

    Node top;
    int size = 0;

    void push(int val){

        Node nw = new Node(val);
        nw.next = top;
        top = nw;
        size++;

    }

    int pop(){

        int el = top.data;

        top = top.next;

        size--;

        return el;

    }

    int top(){

        return top.data;

    } 

    int size(){

        return size;

    } 

}

class qLL{

    Node start , end;

    int size = 0;

    void push(int val){

        Node nw = new Node(val);

        if(start == null && end == null){

            start = nw;
            end = nw;

        }

        end.next = nw;
        end = nw;

        size++;

    }

    int pop(){

        int el = start.data;

        start = start.next;

        size--;

        return el;

    } 

    int top(){

        return start.data;

    }

    int size(){

        return size;
    }

}

class stackUsingQueue{ 

    Queue<Integer> q = new LinkedList<>();

    void push(int val){
        
        q.add(val);

        int s = q.size();

        for(int i = 0 ; i < s-1 ; i++){

            q.add(q.peek());
            q.poll(); 

        }

    }

    void pop(){

        q.poll();

    } 

    int top(){

        return q.peek();

    }

    int size(){

        return q.size();

    }

}

class queueUsingStack{

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int val){

        while(!s1.isEmpty()){

            s2.push(s1.pop());

        }

        s1.push(val);

        while(!s2.isEmpty()){

            s1.push(s2.pop());

        }

    }

    void pop(){

        s1.pop();

    }

    int top(){

        return s1.peek();

    }

    int size(){

        return s1.size();
        
    }

}

public class basics {
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        
        System.out.println("Stack using Array");


        // Stack using Array
        stack st = new stack();

        st.push(2); st.push(4); st.push(6); st.push(8); // [2,4,6,8];

        System.out.println(st.Top()); // 8

        st.pop(); st.pop(); // [2,4]

        System.out.println(st.size()); // 2

        
        System.out.println("Queue using Array");

        // Queue using Array
        queue q = new queue();

        q.push(2); q.push(4); q.push(6); q.push(8);

        q.pop(); q.pop();

        System.out.println(q.top()); // [6,8]

        System.out.println(q.size()); // 2


        
        System.out.println("Stack using Linked List");
        // Stack using Linked List
        stUsingLL sl = new stUsingLL();

        sl.push(1); sl.push(2); sl.push(3); sl.push(4); // [1,2,3,4]

        System.out.println(sl.pop()); // [1,2,3]
        
        System.out.println(sl.pop()); // [1,2]

        System.out.println(sl.top()); // [2]

        System.out.println(sl.size()); // 2


        
        System.out.println("Queue using Linked List");

        // Queue using Linked List
        qLL ql = new qLL(); 

        ql.push(1); ql.push(2); ql.push(3); ql.push(4); // [1,2,3,4]

        System.out.println(ql.pop()); // [2,3,4]

        System.out.println(ql.pop()); // [3,4]

        System.out.println(ql.top()); // 3

        System.out.println(ql.size()); // 2

        System.out.println("Stack Using Queue");

        // Stack Using Queue
        stackUsingQueue sq = new stackUsingQueue();

        sq.push(1); sq.push(2); sq.push(3); sq.push(4); //[1,2,3,4]

        sq.pop();  sq.pop();// [1,2]

        System.out.println(sq.top()); // 2

        System.out.println(sq.size()); // 2


        System.out.println("Queue Using Stack");
        // Queue Using Stack
        queueUsingStack qs = new queueUsingStack();

        qs.push(1); qs.push(2); qs.push(3); qs.push(4); // [1,2,3,4]

        qs.pop(); // [2,3,4]

        qs.pop(); // [3,4]

        System.out.println(qs.top()); // 3

        System.out.println(qs.size()); // 2
    }

}
