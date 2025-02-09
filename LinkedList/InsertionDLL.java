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


public class InsertionDLL {

    public static Node arrayToDLL(int arr[]){

        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1 ; i < arr.length ; i++){

            Node dummy = new Node(arr[i] , null , temp);
            temp.next = dummy;
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

    public static Node insertBeforeHead(Node head , int val){

        if(head == null) return new Node(val);

        Node temp = head;

        Node newNode = new Node(val , temp , null);

        newNode.prev = null;
        
        temp.prev = newNode;

        return newNode;
    }

    public static Node insertBeforeTail(Node head , int val){

        Node temp = head , back = null , front = null;

        while(temp.next != null){
            temp = temp.next;
        }
        back = temp.prev;

        Node newNode = new Node(val , temp , back);

        temp.prev = newNode;
        back.next = newNode;

        return head;
    }

    public static Node insertAtKThPosition(Node head , int k , int val){

        if(head == null) return new Node(val);

        if(k == 1) return insertBeforeHead(head, val);

        Node temp = head;

        int cnt = 0;

        while(temp.next != null){
            cnt++;
            if(cnt == k) break;
            temp =temp.next;
        }

        if(cnt < k) return head;

        if(temp == null) return new Node(val);

        Node back = temp.prev;
        Node front = temp.next;

        Node newNode = new Node(val , temp , back);

        back.next = newNode;
        temp.prev = newNode;

        return head;

    }

    public static void insertBeforeNode(Node node , int val){

        Node back = node.prev;

        Node newNode = new Node(val , node , back);

        back.next = newNode;
        node.prev = newNode;

    }

    public static void main(String[] args) {
        
        int arr0[] = {1,2,3,4,5};
        
        int arr1[] = {1,2,3,4,5};

        int arr2[] = {1,2,3,4,5};

        int arr3[] = {1,2,3,4,5};

        int arr4[] = {1,2,3,4,5};

        Node head = arrayToDLL(arr0);

        Node head1 = arrayToDLL(arr1);

        Node head2 = arrayToDLL(arr2);

        Node head3 = arrayToDLL(arr3);

        Node insFis = insertBeforeHead(head , 100);

        Node insLas = insertBeforeTail(head1 , 0);

        Node insKPos = insertAtKThPosition(head2 , 3 , 100);

        // Node delNode = deleteAtParticularNode(head3 , 10);

        printDLL(insFis);

        printDLL(insLas);

        printDLL(insKPos);

        insertBeforeNode(head3.next.next.next , 0);

        printDLL(head3);

    }

}
