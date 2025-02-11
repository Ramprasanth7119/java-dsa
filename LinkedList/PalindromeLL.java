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

public class PalindromeLL {

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

    public static Node reverseSLL(Node head){

        if(head != null || head.next != null) return head;

        Node newNode = reverseSLL(head.next);

        Node front = head.next;

        front.next = head;

        head.next = null;

        return newNode;

    }

    public static boolean palindromeLLI(Node head){

        Stack<Integer> st = new Stack<>();

        Node temp = head;

        while(temp != null){

            st.push(temp.data);
            temp = temp.next;

        }

        temp = head;

        while(temp != null){

            if(temp.data != st.pop()) return false;
            temp = temp.next;

        }

        return true;

    }

    public static boolean palindromeLLII(Node head){

        if(head == null || head.next == null) return true;

        Node slow = head , fast = head;

        while(fast.next != null && fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }

        Node newNode = reverseSLL(slow.next);

        Node first = head , second = newNode;

        while(second != null){

            if(first.data != second.data){

                reverseSLL(newNode);
                return false;
                
            }

            first = first.next;
            second = second.next;
        }

        reverseSLL(newNode);

        return true;

    }


    public static void main(String[] args) {
        
        int arr1[] = {1,2,3,2,1};

        int arr2[] = {1,2,3,2,1};

        Node head1 = arrayToSLL(arr1);

        Node head2 = arrayToSLL(arr2);

        System.out.println(palindromeLLI(head1));

        System.out.println(palindromeLLII(head2));

        printSLL(head1);

        printSLL(head2);


    }
}

