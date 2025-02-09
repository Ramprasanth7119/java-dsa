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


public class DeletionDLL {

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

    public static Node deleteAtFirst(Node head){

        Node temp = head;

        if(head == null || head.next == null){
            return head;
        }

        head = head.next;
        temp.next = null;
        head.prev = null;

        return head;
    }

    public static Node deleteAtLast(Node head){

        Node temp = head;
        Node back = null;

        while(temp.next != null){
            back = temp;
            temp = temp.next;
        }

        back.next = null;
        temp.prev = null;

        return head;

    }

    public static Node deleteAtKThPosition(Node head , int k){

        Node temp = head;

        if(head == null || head.next == null){
            return null;
        }

        int cnt = 0;

        while(temp != null){ // Or while(temp != null && cnt < k) and remove the if statement inside the while ,when comes to 0 - based indexing..

            cnt++;
            if(cnt == k) break;
            temp = temp.next;

        }

         if(temp == null) return head;
    
        Node back = temp.prev;
        Node front = temp.next;

        if(back == null && front == null){
            return null;
        }
        else if(back == null){
            return deleteAtFirst(head);
        } 
        else if(front == null){
            return deleteAtLast(head);
        }

        back.next = temp.next;
        front.prev = temp.prev;

        temp.next = temp.prev = null;

        return head;
    }

    public static Node deleteAtParticularNode(Node head , int val){

        Node temp = head;
        Node back = null , front = null;

        if(head == null || head.next == null) return null;

        while(temp != null && val != temp.data){

            back = temp;
            temp = temp.next;
        }

        if(temp == null) return head;

        front = temp.next;

        back.next = temp.next;
        front.prev = back;

        return head;

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

        Node delFis = deleteAtFirst(head);

        Node delLas = deleteAtLast(head1);

        Node delKPos = deleteAtKThPosition(head2 , 3);

        Node delNode = deleteAtParticularNode(head3 , 10);

        printDLL(delFis);

        printDLL(delLas);

        printDLL(delKPos);

        printDLL(delNode);


    }

}
