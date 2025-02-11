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

public class AddTwoListLL {

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

    public static Node addTwoList(Node head1 , Node head2){

        Node temp1 = head1 , temp2 = head2;

        int carry = 0;

        Node dummy = new Node(-1);

        Node curr = dummy;

        while(temp1 != null || temp2 != null){

            int sum = carry;

            if(temp1 != null) sum += temp1.data;
            if(temp2 != null) sum += temp2.data;

            Node newNode = new Node(sum % 10);
            carry = sum / 10;

            curr.next = newNode;
            curr = curr.next;

            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;

        }

        if(carry != 0){
            Node newNode = new Node(carry);
            curr.next = newNode;
            newNode.next = null;
        }

        return dummy.next;

    }   
    
    public static void main(String[] args) {
        
        int arr1[] = {1,2,3,4,5};

        int arr2[] = {6,7,8,9,10};

        Node head1 = arrayToLL(arr1);

        Node head2 = arrayToLL(arr2);

        Node  addLis = addTwoList(head1, head2);

        printLL(addLis);

    }

}
