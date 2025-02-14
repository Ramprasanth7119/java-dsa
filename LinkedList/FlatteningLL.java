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

public class FlatteningLL {

    public static Node mergeTwoLL(Node t1 , Node t2){

        Node dummy = new Node(-1);
        Node temp = dummy;

        while(t1 != null && t2 != null){

            if(t1.data < t2.data){
                temp.child = t1;
                temp = t1;
                t1 = t1.child;
            }
            else{

                temp.child = t2;
                temp = t2;
                t2 = t2.child;

            }
            temp.next = null;

        }

        if(t1 != null) temp.child = t1;
        else temp.child = t2;

        if(dummy.child.next != null) dummy.child.next = null;

        return dummy.child;

    }

    public static Node flattern(Node head){

        if(head == null || head.next == null) return head;

        Node mergeHead = flattern(head.next);

        head = mergeTwoLL(head, mergeHead);

        return head;

    }
  
    public static void printOriginalLinkedList(Node head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        Node head = new Node(5);
        head.child = new Node(14);

        head.next = new Node(10);
        head.next.child = new Node(4);

        head.next.next = new Node(12);
        head.next.next.child = new Node(20);
        head.next.next.child.child = new Node(13);

        head.next.next.next = new Node(7);
        head.next.next.next.child = new Node(17);

        Node flatternI = flattern(head);

        printLinkedList(flatternI);

    }

}
