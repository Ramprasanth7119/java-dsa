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


public class ReverseKGroupSizeLL{

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

    public static Node reverse(Node head){

        Node temp = head , prev = null;

        while(temp != null){

            Node front = temp.next;

            temp.next = prev;

            prev = temp;

            temp = front;

        }

        return prev;

    }

    public static Node KThNode(Node temp , int k){

        k -= 1;

        while(temp != null && k > 0){

            k--;
            temp = temp.next;

        }

        return temp;

    }

    public static Node reverseKGroupSizeLL(Node head , int k){

        Node temp = head;

        Node prev = null;

        while(temp != null){

            Node kthNode = KThNode(temp, k);

            if(kthNode == null){

                if(prev != null) prev.next = temp;
                break;

            }

            Node newNode = kthNode.next;

            kthNode.next = null;

            reverse(temp);

            if(temp == head){

                head = kthNode;

            } else {

                prev.next = kthNode;

            }

            prev = temp;

            temp = newNode;

        }

        return head;

    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11};

        Node head = arrayToLL(arr);

        head = reverseKGroupSizeLL(head, 3);

        printLL(head);

    }

    
}