
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

public class basics {
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        // Stack using Array
        stack st = new stack();

        st.push(2); st.push(4); st.push(6); st.push(8); // [2,4,6,8];

        System.out.println(st.Top()); // 8

        st.pop(); st.pop(); // [2,4]

        System.out.println(st.size()); // 2


        queue q = new queue();

        q.push(2); q.push(4); q.push(6); q.push(8);

        q.pop();

        System.out.println(q.top());

        System.out.println(q.size());

    }

}
