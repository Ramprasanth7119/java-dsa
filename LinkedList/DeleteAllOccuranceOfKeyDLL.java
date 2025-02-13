class Node{

    int data;
    Node next  , prev;

    public Node(int data , Node prev , Node next){

        this.data = data;
        this.prev = prev;
        this.next = next;

    }

    public Node(int data){

        this.data = data;

    }

}

public class DeleteAllOccuranceOfKeyDLL {
    
    public static Node arrayToDLL(int arr[]){

        Node head = new Node(arr[0]);

        Node temp = head;

        for(int i = 1 ; i < arr.length ; i++){

            Node nw = new Node(arr[i] , temp , null);

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

    }

    public static Node deleteAllOccuranceOfKeyDLL(Node head , int el){

        Node temp = head;

        while(temp != null){

            if(temp.data == el){

                if(temp == head){

                    head = head.next;

                }

                Node back = temp.prev;
                Node front = temp.next;

                if(front != null) front.prev = back;
                if(back != null) back.next = front;

                temp = front;

            }
            else {

                temp = temp.next;

            }

        }
        return head;
    
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,1,1,4,1};

        Node head = arrayToDLL(arr);

        Node delKey = deleteAllOccuranceOfKeyDLL(head, 1);

        printDLL(delKey);

    }

}
