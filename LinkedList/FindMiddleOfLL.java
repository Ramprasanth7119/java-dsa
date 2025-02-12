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


public class FindMiddleOfLL {
    
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

    public static Node removeMiddleNodeI(Node head){

        Node temp = head;

        int cnt = 0;

        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        temp = head;

        int mid = (cnt / 2) + 1;

        while(temp != null){
            mid--;
            if(mid == 0) break;
            temp = temp.next;
        }

        return temp;
    }

    public static Node removeMiddleNodeII(Node head){

        Node slow = head , fast = head;

        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;

    }

    public static void main(String[] args) {
        
                
        int arr1[] = {1,2,3,4,5};

        int arr2[] = {1,2,3,4,5,6};

        Node head1 = arrayToSLL(arr1);

        Node head2 = arrayToSLL(arr2);

        Node remMidI = removeMiddleNodeI(head1); // Brute..

        Node remMidII = removeMiddleNodeII(head2);  // tortiose and hare method{i.e slow and fast pointers}

        printSLL(remMidI);
        
        printSLL(remMidII);
    }


}
