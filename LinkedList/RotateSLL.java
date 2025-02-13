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


public class RotateSLL {

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

    public static Node findNewNode(Node temp , int len){

        int cnt = 1;

        while(temp != null){
            if(cnt == len) break;

            cnt++;
            temp = temp.next;
        }
        return temp;

    }

    public static Node rotateLL(Node head , int k){

        Node tail = head;

        int len = 1;

        while(tail.next != null){

            tail = tail.next;
            len++;

        }

        if(k % len == 0) return head;

        k = k % len;

        tail.next = head;

        Node nw = findNewNode(head, len - k);

        head = nw.next;

        nw.next = null;

        return head;

    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        Node head = arrayToSLL(arr);

        head = rotateLL(head, 4);

        printSLL(head);

    }
    
}
