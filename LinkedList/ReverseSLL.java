import java.util.*;

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

public class ReverseSLL {

    public static Node arrayToSLL(int arr[]){

        Node head = new Node(arr[0]);

        Node temp = head;

        for(int i = 1 ; i < arr.length ; i++){

            Node nw = new Node(arr[i]);

            temp.next = nw;
            temp = nw;
        }
        return head;

    }

    public static void printSLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static Node reverseSLLI(Node head){

        Node temp = head;

        Stack<Integer> st = new Stack<>();

        while(temp != null){
            st.add(temp.data);
            temp = temp.next;
            
        }

        temp = head;

        while(temp != null){
            temp.data = st.peek();
            st.pop();
            temp = temp.next;
        }

        return head;
    }

    public static Node reverseSLLII(Node head){

        Node temp = head;

        Node prev = null;

        while(temp != null){
            
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;

        }

        return prev;

    }

    public static Node reverseSLLIII(Node head){

        if(head == null || head.next == null) return head;

        Node newNode = reverseSLLIII(head.next);

        Node front = head.next;

        front.next = head;

        head.next = null;
        
        return newNode;
    }


    public static void main(String[] args) {
        
        int arr1[] = {1,2,3,4,5};

        int arr2[] = {1,2,3,4,5};

        int arr3[] = {1,2,3,4,5};

        Node head1 = arrayToSLL(arr1);

        Node head2 = arrayToSLL(arr2);

        Node head3 = arrayToSLL(arr3);

        Node revSLLI = reverseSLLI(head1);

        Node revSLLII = reverseSLLII(head2);

        Node revSLLIII = reverseSLLIII(head3);

        printSLL(revSLLI);

        printSLL(revSLLII);

        printSLL(revSLLIII);

    }
}
