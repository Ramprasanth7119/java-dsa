import java.util.*;

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


public class MergeTwoSortedLL {
    
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

    public static int lengthOfLL(Node t1){

        int c1 = 1;

        while(t1.next != null){

            c1++;
            t1 = t1.next;

        }
        return c1;
    }

    public static Node mergeTwoSortedLLI(Node head1 , Node head2){

        Node t1 = head1 , t2 = head2;

        int cnt = lengthOfLL(t1) + lengthOfLL(t2);

        List<Integer> temp = new ArrayList<>();

        t1 = head1;
        t2 = head2;

        while(t1 != null){
            temp.add(t1.data);
            t1 = t1.next;
        }

        while(t2 != null){
            temp.add(t2.data);
            t2 = t2.next;
        }

        int n = temp.size();
        
        int arr[] = new int[cnt];

        for(int i = 0;i<n;i++){

            arr[i] = temp.get(i);

        }

        Arrays.sort(arr);

        Node head = arrayToSLL(arr);

        return head;

    }

    public static Node mergeTwoSortedLLII(Node head1 , Node head2){

        Node t1 = head1 , t2 = head2;

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

    public static void main(String[] args) {
        
        int arr1[] = {1,1,2,3,3,4,5,8};

        int arr2[] = {1,2,3,4,5,6,7,8,9,9};
        
        int arr3[] = {1,1,2,3,3,4,5,8};

        int arr4[] = {1,2,3,4,5,6,7,8,9,9};

        Node head1 = arrayToSLL(arr1);

        Node head2 = arrayToSLL(arr2);

        Node head3 = arrayToSLL(arr3);

        Node head4 = arrayToSLL(arr4);

        Node mergeI = mergeTwoSortedLLI(head1, head2); // O(N1 + N2) + O(log N) + O(N) , O(N)

        Node mergeII = mergeTwoSortedLLII(head3, head4); // O(N1 + N2) , O(1)

        printSLL(mergeI);

        printSLL(mergeII);

    }

}
