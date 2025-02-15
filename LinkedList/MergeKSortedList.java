import java.util.*;

class Node{

    int data;
    Node next;
    Node child;

    public Node(int data , Node next , Node child){
        this.data = data;
        this.next = next;
        this.child = child; 
    }

    public Node(int data){
        this.data = data;
    }

}

public class MergeKSortedList {

    public static Node arrayToLL(int arr[]){

        Node head = new Node(arr[0]);

        Node temp = head;

        for(int i = 1 ; i < arr.length ; i++){

            Node nw = new Node(arr[i]);

            temp.next = nw;

            temp = nw;

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

    public static Node mergeLL(Node h1 , Node h2){

        Node t1 = h1 , t2 = h2;

        Node dummy = new Node(-1);

        Node temp = dummy;

        while(t1 != null && t2 != null){

            if(t1.data < t2.data){

                temp.next = t1;
                temp = t1;
                t1 = t1.next;

            } else {

                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }

        }

        if(t1 != null) temp.next = t1;

        else temp.next = t2;

        return dummy.next;

    }

    public static Node mergeKSortedLLI(List<Node> ls){

        int arr[] = new int[20];

        int ind = 0;

        for(int i = 0 ; i < ls.size() ; i++){

            Node head = ls.get(i);

            while(head != null){

                arr[ind++] = head.data;
                head = head.next;

            }

        }

        Arrays.sort(arr);

        Node head = arrayToLL(arr);

        return head;
        
    }

    public static Node mergeKSortedLLII(List<Node> ls){

        Node head = ls.get(0 );

        for(int i = 1 ; i < ls.size() ; i++){

            head = mergeLL(head, ls.get(i));

        }
        return head;

    }

    public static Node mergeKSortedLLIII(List<Node> ls){

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));

        for(Node i : ls){

            if(i != null)  pq.add(i);

        }

        Node dummy = new Node(-1);
        Node temp = dummy;

        while(!pq.isEmpty()){

            Node curr = pq.poll();

            temp.next = curr;
            temp = curr;

            if(temp.next != null) pq.add(curr.next);

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        
        List<Node> ls = new ArrayList<>();

        ls.add(arrayToLL(new int[]{1,3,4,5,8}));

        ls.add(arrayToLL(new int[]{1,2,3,7,9}));

        ls.add(arrayToLL(new int[]{4,6,7,8,9}));

        ls.add(arrayToLL(new int[]{1,2,5,7,8}));

        Node head1 = mergeKSortedLLI(ls);  // O(N * K) + O(M log M) where M = N*K + O(M) , SC -> O(M) + O(M)
 
        Node head2 = mergeKSortedLLII(ls);  // O(N * (K * (K + 1)) / 2) {nearly O(N*3)}  , SC -> O(1)
 
        Node head3 = mergeKSortedLLIII(ls);  // O(K * log K ) + N * K * log   , SC -> O(K)
 
        printLL(head1);

        printLL(head2);

        printLL(head3);

    }
    
}
