import java.util.*;

class Node {

    int data;

    Node next;

    Node random;

    public Node() {
        this.data = 0;
        this.next = null;
        this.random = null;
    }

    public Node(int x) {
        this.data = x;
        this.next = null;
        this.random = null;
    }

    public Node(int x, Node nextNode, Node randomNode) {
        this.data = x;
        this.next = nextNode;
        this.random = randomNode;
    }
}

public class CloneWithNextAndRandomPointers {

    public static void printLL(Node head){

        Node temp = head;

        while(temp != null){

            System.out.print(temp.data + " ");
            temp = temp.next;

        }
        System.out.println();
    } 
    
    public static Node cloneI(Node head){

        Node temp = head;

        HashMap<Node , Node> map = new HashMap<>();

        while(temp != null){

            Node nw = new Node(temp.data);
            map.put(temp , nw);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){

            Node copy = map.get(temp);

            copy.next = map.get(temp.next);

            copy.random = map.get(temp.random);

            temp = temp.next;

        }

        return map.get(head);

    }

    public static Node cloneII(Node head){

        Node temp = head;

        // Create a copy of each node and insert it next to the original node
        while(temp != null){

            Node nw = new Node(temp.data);

            nw.next = temp.next;

            temp.next = nw;

            temp = temp.next.next;
        }

        temp = head;

        // Assign random pointers to the copied nodes
        while(temp != null){

            Node copy = temp.next;

            if(temp.random != null){
                
                copy.random = temp.random.next;

            } else {

                copy.random = null;

            }

            temp = temp.next.next;

        }

        // Separate the original and copied nodes
        temp = head;
        
        Node dummy = new Node(-1);
        Node prev = dummy;

        while(temp != null){

            prev.next = temp.next;

            prev = temp.next;

            temp.next = temp.next.next;

            temp = temp.next;

        }

        return dummy.next;

    }

        
    public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);


        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        Node head1 = cloneI(head); // O(2N) , O(N) + o(N)
        
        Node head2 = cloneI(head); // O(3N) , O(N)

        printLL(head1);

        printLL(head2);
    }
}
