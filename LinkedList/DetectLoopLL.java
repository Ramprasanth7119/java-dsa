
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

public class DetectLoopLL {
    
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

    public static boolean detectLoopI(Node head){

        Map<Node , Integer> mp = new HashMap<>();

       Node temp = head;

       while(temp != null){

            if(mp.containsKey(temp)) return true;

            mp.put(temp , 1);

            temp = temp.next;
       }
       return false;

    }

    public static boolean detectLoopII(Node head){

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        Node head = arrayToSLL(arr);

        head.next.next.next.next.next = head.next.next;

        System.out.println(detectLoopI(head));

        System.out.println(detectLoopII(head));

    }
}
