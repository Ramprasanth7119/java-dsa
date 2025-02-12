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


public class StartingPointOfLoop {
    

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

        if(head == null) return;

        else System.out.println(head.data);

    }

    public static Node startingPointOfLoopI(Node head){

        Map<Node , Integer> map = new HashMap<>();

        Node temp = head;

        while(temp != null){

            if(map.containsKey(temp)) {

                return temp;
            }

            map.put(temp,1);

            temp = temp.next;

        }

        return null;

    }

    public static Node startingPointOfLoopII(Node head){

        Node slow = head , fast = head;
        
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){

                slow = head;
                while(slow != fast){

                    slow = slow.next;
                    fast = fast.next;

                }

                return slow;
            }

        }
        return null;

    }

    public static void main(String[] args) {
               
        int arr1[] = {1,2,3,4,5};

        Node head1 = arrayToSLL(arr1);

        head1.next.next.next.next.next = head1.next.next;

        int arr2[] = {1,2,3,4,5};

        Node head2 = arrayToSLL(arr2);

        head2.next.next.next.next.next = head2.next.next;

        Node LoopI = startingPointOfLoopI(head1);

        Node LoopII = startingPointOfLoopII(head2);

        printSLL(LoopI);

        printSLL(LoopII);

        // System.out.println(startingPointOfLoopI(head1));

        // System.out.println(startingPointOfLoopI(head2));

    }

}
