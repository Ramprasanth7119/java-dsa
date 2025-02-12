
import java.util.*;

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

public class LengthOfLoop {
    
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

    public static int lengthOfLoopI(Node head){

        Node temp = head;

        Map<Node , Integer> mp = new HashMap<>();

        int cnt = 0;

        while(temp != null){

            if(mp.containsKey(temp)){

                int t = mp.get(temp);

                return cnt - t;

            }
            mp.put(temp , cnt);
            cnt++;
            temp = temp.next;

        }

        return 0;
    }

    public static int count(Node slow , Node fast){

        int cnt = 1;

        fast = fast.next;

        while(slow != fast){

            cnt++;
            fast = fast.next;

        }
        return cnt;

    }

    public static int lengthOfLoopII(Node head){

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return count(slow, fast);

        }
        return 0;
    }
    

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        Node head = arrayToSLL(arr);

        head.next.next.next.next.next = head.next.next;

        System.out.println(lengthOfLoopI(head));

        System.out.println(lengthOfLoopII(head));

    }
}
