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

public class DeletionLL {

    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node arrayToLL(int arr[]){

        Node head = new Node(arr[0]);

        Node dummy = head;
    
        for(int i = 1 ; i < arr.length ; i++){
            
            Node temp = new Node(arr[i]);

            dummy.next = temp;

            dummy = temp;

        }
    
        return head;
    }

    public static Node deleteAtFirst(Node head){

        head = head.next;

        return head;

    }

    public static Node deleteAtLast(Node head){

        Node temp = head;

        if(head == null || head.next == null) return null;

        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;

        return head;

    }

    public static Node deleteAtKThPosition(Node head , int k){

        Node temp = head;

        if(head == null) return head;

        Node prev = null;

        if(k == 1){
            
            head = head.next;
            return head;
        }

        int cnt = 0;

        while(temp != null){

            cnt++;

            if(cnt == k){

                prev.next = prev.next.next;
                break;

            }

            prev = temp;
            temp = temp.next;

        }

        return head;

    }

    public static Node deleteAtValue(Node head , int val){

        if(head == null) return head;

        if(head.data == val){

            head = head.next;
            return head;

        }

        Node temp = head , prev = null;

        while(temp != null){

            if(temp.data == val){

                prev.next = prev.next.next;

            }

            prev = temp;
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

        Node delFis = deleteAtFirst(head1);  // Delete the first value

        Node delLas = deleteAtLast(head2);  // delete the last value

        Node delKNode = deleteAtKThPosition(head3, 3); // delete the K th index element

        Node delVal = deleteAtValue(head4, 2); // delete the value present in the LL

        printLL(delFis);

        printLL(delLas);

        printLL(delKNode);

        printLL(delVal);

    }

}
