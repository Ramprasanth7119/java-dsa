import java.util.*;

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

public class FindAllPairsWithSumKDLL {
    
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

    public static List<List<Integer>> findAllPairsWithSumKI(Node head , int target){

        Node t1 = head , t2 = null;

        List<List<Integer>> ans = new ArrayList<>();

        while(t1 != null){

            t2 = t1.next;

            List<Integer> temp = new ArrayList<>();

            while(t2 != null){

                if(t1.data + t2.data == target){

                    temp.add(t1.data);
                    temp.add(t2.data);

                    ans.add(new ArrayList<>(temp));
    
                }

                t2 = t2.next;
                

            }
            t1 = t1.next;
        }
        return ans;
    }

    public static Node tailed(Node head){

        Node temp = head;

        while(temp.next != null) temp = temp.next;

        return temp;
    }

    public static List<List<Integer>> findAllPairsWithSumKII(Node head , int target){

      
        List<List<Integer>> ans = new ArrayList<>();
        
        Node left = head;

        Node tail = tailed(head);

        while(left.data < tail.data){

            List<Integer> temp = new ArrayList<>();

            if(left.data + tail.data == target){

                temp.add(left.data);
                temp.add(tail.data);

                ans.add(new ArrayList<>(temp));

                left = left.next;
                tail = tail.prev;

            }

            else if(target > left.data + tail.data) left = left.next;

            else tail = tail.prev;
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        int sum = 7;

        Node head = arrayToDLL(arr);

        List<List<Integer>> resI = findAllPairsWithSumKI(head , sum);

        List<List<Integer>> resII = findAllPairsWithSumKII(head , sum);

        for(List<Integer> i : resI) System.out.print(i);

        System.out.println();

        for(List<Integer> i : resII) System.out.print(i);

    }

}
