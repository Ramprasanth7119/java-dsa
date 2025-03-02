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

public class Basics {

    public static Node arrayToLL(int arr[]){

        Node head = new Node(arr[0]);
        Node m = head;

        for(int i = 1 ; i < arr.length ; i++){

            Node temp = new Node(arr[i]);
            m.next = temp;
            m = temp;

        }
        return head;

    }

    public static void printLL(Node head){
        Node temp = head;

        System.out.print("Elements in LL : ");
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static int countLengthOfLL(Node head){
        Node temp = head;
        int cnt = 0;

        while(temp != null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    public static boolean searchElementInLL(Node head , int num){
        Node temp = head;

        while(temp != null){
            if(temp.data == num) return true;
            temp = temp.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        int arr[] = {6,4,1,3,2,5};

        Node head = arrayToLL(arr);

        System.out.println("Head Node of LL : " + head.data);

        System.out.println("Length of LL : " + countLengthOfLL(head));

        printLL(head);

        System.out.println("Element Search : " + searchElementInLL(head, 4));

    }

}
