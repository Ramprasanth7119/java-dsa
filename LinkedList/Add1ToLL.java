
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


public class Add1ToLL {


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

    public static Node reverse(Node head){

        if(head == null ||head.next == null) return head;

        Node newNode = reverse(head.next);

        Node front = head.next;

        front.next = head;

        head.next = null;

        return newNode;

    }

    public static Node add1ToLLI(Node head){

        head = reverse(head);

        int carry = 1;

        Node temp = head;

        while(temp != null){

            temp.data = carry + temp.data;

            if(temp.data < 10) {

                carry = 0;
                break;
            }

            temp.data = 0;
            carry = 1;

            temp = temp.next;

        }

        if(carry == 1){

            Node nw = new Node(carry);
            head = reverse(head);
            nw.next = head;

            return nw;

        }
        head = reverse(head);

        return head;

    }

    public static int carryFinder(Node temp){

        if(temp == null) return 1;

        int carry = carryFinder(temp.next);

        temp.data = temp.data + carry;

        if(temp.data < 10) return 0;

        temp.data = 0;

        return 1;

    }

    public static Node add1ToLLII(Node head){

        int carry = carryFinder(head);

        if(carry == 1){

            Node nw = new Node(carry);

            nw.next = head;

            head = nw;

        }

        return head;

    }

    public static void main(String[] args) {
        
        int arr1[] = {9,9,9,9};

        int arr2[] = {1,9,8};

        Node head1 = arrayToSLL(arr1);

        Node head2 = arrayToSLL(arr2);

        Node add1I = add1ToLLI(head1); // Order of O(3N) and O(1) , But it take too much time to run because of iterative approach..

        Node add1II = add1ToLLII(head2); // Order of O(N) and O(N){Recursive stack space} , but faster than Iterative...
 
        printSLL(add1I);

        printSLL(add1II);


    }
}
