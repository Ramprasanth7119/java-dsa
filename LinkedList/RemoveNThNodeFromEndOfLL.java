
 class Node {  
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


public class RemoveNThNodeFromEndOfLL {

    
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

    public static Node removeNThNodeFromEndOfLL(Node head , int n){

        Node fast = head;

        for(int i = 0 ; i < n ; i++) fast = fast.next;

        Node slow = head;

        if(fast == null) return head.next;

        while(fast.next != null){

            slow = slow.next;

            fast = fast.next;

        }

        slow.next = slow.next.next;

        return head;

    }
    
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};

        Node head = arrayToLL(arr);

        Node delNode = removeNThNodeFromEndOfLL(head, 5);

        printLL(delNode);

    }
}

