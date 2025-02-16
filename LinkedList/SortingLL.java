import java.util.*;

class Node{

    int data;
    Node next;
    Node child;

    public Node(int data , Node next , Node child){
        this.data = data;
        this.next = next;
        this.child = child; 
    }

    public Node(int data){
        this.data = data;
    }

}


public class SortingLL {

    public static Node arrayToLL(int arr[]){

        Node head = new Node(arr[0]);

        Node temp = head;

        for(int i = 1 ; i < arr.length ; i++){

            Node nw = new Node(arr[i]);

            temp.next = nw;

            temp = nw;

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

    public static Node sortI(Node head){

        Node temp = head;

        int[] arr = new int[5];

        int i = 0;

        while(temp != null){

            arr[i++] = ( temp.data);
            temp = temp.next;

        }

        Arrays.sort(arr);

        temp = head;

        i = 0;

        while(temp != null){

            temp.data = arr[i++];
            temp = temp.next;

        }

        return head;

    }

    public static Node findMiddleNode(Node temp){

        Node slow = temp , fast = temp.next;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;

    }

    public static Node mergeTwoSortedLL(Node head1 , Node head2){

        Node t1 = head1 , t2 = head2;

        Node dummy = new Node(-1);

        Node temp = dummy;

        while(t1 != null && t2 != null){

            if(t1.data < t2.data){

                temp.next = t1;
                temp = t1; 
                t1 = t1.next;
                
            } else {

                temp.next = t2;
                temp = t2;
                t2 = t2.next;

            }

        }

        if(t1 != null) temp.next = t1;
        else temp.next = t2;

        return dummy.next;
    }

    public static Node sortII(Node head){

        Node temp = head;

        if(head == null || head.next == null) return head;

        Node mid = findMiddleNode(head);

        Node left = head , right = mid.next;

        mid.next = null;

        left = sortII(left);

        right = sortII(right);

        return mergeTwoSortedLL(left , right);

    }

    public static void main(String[] args) {
        
        Node head1 = arrayToLL(new int[]{1,4,5,3,2});

        Node head2 = arrayToLL(new int[]{9,6,7,5,1,3,2,4,8});

        head1 = sortI(head1);

        head2 = sortII(head2);

        printLL(head1);

        printLL(head2);

    }
    
}
