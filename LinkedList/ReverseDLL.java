
import java.util.Stack;

class Node {

    int data;
    Node next;
    Node prev;

    public Node(int data , Node next , Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}


public class ReverseDLL {

    public static Node arrayToDLL(int arr[]){

        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1 ; i < arr.length ; i++){

            Node dummy = new Node(arr[i]);
            temp.next = dummy;
            dummy.prev = temp;
            temp = dummy;

        }
        return head;
    }

    public static void printDLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node reverseDLLI(Node head){

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

    public static Node reverseDLLII(Node head){
        
        Node curr = head;

        Node last = null;

        while(curr != null){

            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;
            curr = curr.prev;
        }

        return last.prev;
    }
    

    public static void main(String[] args) {
        
        int arr1[] = {1,2,3,4,5};

        int arr2[] = {1,2,3,4,5};

        Node head1 = arrayToDLL(arr1);

        Node head2 = arrayToDLL(arr2);

        Node revDLLI = reverseDLLI(head1);

        Node revDLLII = reverseDLLII(head2);

        printDLL(revDLLI);

        printDLL(revDLLII);

    }

}
