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

public class InsertionSLL {

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

    public static Node insertAtFirst(Node head , int val){

        if(head == null) return new Node(val);

        return new Node(val , head);

    }

    public static Node insertAtLast(Node head , int val){

        if(head == null) return head;

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = new Node(val,null);

        return head;

    }

    public static Node insertAtKThPosition(Node head , int k , int val){

        if(head == null){
            if(k == 1){
                return new Node(val , head);
            } else{
                return head;
            }
        }

        if(k == 1) return new Node(val , head);

        int cnt = 0;

        Node temp = head;

        while(temp.next != null){

            cnt++;

            if(cnt == (k-1)){

                Node dummy = new Node(val , temp.next);

                temp.next = dummy;

            }

            temp = temp.next;

        }

        return head;

    }

    public static Node insertBeforeValue(Node head , int val , int el){

        if(head == null){

            return head;

        }

        if(head.data == val) return new Node(el , head);

        Node temp = head;

        while(temp.next != null){

            if(temp.next.data == val){

                Node dummy = new Node(el , temp.next);

                temp.next = dummy;

                break;

            }
            temp = temp.next;

        }
        return head;

    }
    
    public static void main(String[] args) {
        
        int arr1[] = {1,2,3,4,5};

        int arr2[] = {1,2,3,4,5};

        int arr3[] = {1,2,3,4,5};

        int arr4[] = {1,2,3,4,5};

        Node head1 = arrayToLL(arr1);

        Node head2 = arrayToLL(arr2);

        Node head3 = arrayToLL(arr3);

        Node head4 = arrayToLL(arr4);

        Node insFis = insertAtFirst(head1, 0);

        Node insLas = insertAtLast(head2, 0);

        Node insKPos = insertAtKThPosition(head3, 3 ,0);

        Node insValEl = insertBeforeValue(head4, 5 ,0);

        printLL(insFis);

        printLL(insLas);

        printLL(insKPos);

        printLL(insValEl);
        
    }

}
