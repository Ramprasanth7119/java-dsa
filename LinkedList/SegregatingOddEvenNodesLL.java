
import java.util.*;

class Node{
    
    int data;
    Node next;

    public Node(int data , Node next){

        this.data = data;
        this.next = next;

    }

    public Node(int data){

        this.data = data;

    }
}

public class SegregatingOddEvenNodesLL {

    public static Node arrayToLL(int arr[]){

        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1 ; i < arr.length ; i++){

            Node dummy = new Node(arr[i]);
            temp.next = dummy;
            temp = dummy;

        }
        return head;
    }

    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node segregatingoddEvenNodeI(Node head){

        Node temp = head;

        // Stack<Integer> oddEven = new Stack<>();

        List<Integer> oddEven = new ArrayList<>();

        while(temp != null && temp.next != null){

            oddEven.add(temp.data);
            temp = temp.next.next;

        }

        if(temp != null) oddEven.add(temp.data);

        temp = head.next;

        while(temp != null && temp.next != null){

            oddEven.add(temp.data);
            temp = temp.next.next;
        }

        if(temp != null) oddEven.add(temp.data);

        temp = head;

        int ind = 0;

        while(temp != null){
        
            temp.data = oddEven.get(ind);
            ind++;
            temp = temp.next;
            
        }

        return head;

    }

    public static Node segregatingoddEvenNodeII(Node head){


        Node odd = head;
        Node even = head.next;
        Node evenFirst = head.next;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;

        }


        odd.next = evenFirst;

        return head;

    }

    public static void main(String[] args) {

        int arr1[] = {1,2,3,4,5,6};

        Node head1 = arrayToLL(arr1);

        int arr2[] = {1,2,3,4,5,6};

        Node head2 = arrayToLL(arr2);
        
        // printLL(head);

        Node segNodeI = segregatingoddEvenNodeI(head1);

        printLL(segNodeI);

        Node segNodeII = segregatingoddEvenNodeII(head2);

        printLL(segNodeII);
    }
    
}
