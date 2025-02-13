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


public class RemoveDuplicatesFromSortedDLL{


    public static Node arrayToDLL(int arr[]){

        Node head = new Node(arr[0]);

        Node temp = head;

        for(int i = 1 ; i < arr.length;i++){

            Node nw = new Node(arr[i] , null , temp);

            temp.next = nw;

            temp = nw;

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

    public static Node removeDuplicates(Node head){

        Node temp = head;

        while(temp != null && temp.next != null){

            Node nw = temp.next;

            while( nw != null && nw.data == temp.data){

                nw = nw.next;

            }

            temp.next = nw;
            if(nw != null) nw.prev = temp;

            temp = temp.next;

        }
        return head;

    }

    public static void main(String[] args) {
        
        int arr[] = {1,1,1,2,2,3,4,4,5,5,6,6};

        Node head = arrayToDLL(arr);

        Node remDup = removeDuplicates(head); // O(N);

        printDLL(remDup);
    }

}   