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

public class IntersectionPointInLL {
    
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

    public static Node intersectionPointInLLI(Node head1 ,Node head2){

        Node temp1 = head1;
        
        Node temp2 = head2;

        int diff = countDiff(head1 , head2);

        if(diff <   0) {

            while(diff != 0){
                temp2 = temp2.next;
                diff++;
            }
        } else {

            while(diff != 0){
                temp1 = temp1.next;
                diff--;
            }

        }


        while(temp1 != null && temp2 != null){

            if(temp1 == temp2) return temp1;
   
            temp2 = temp2.next;
            temp1 = temp1.next;

        }


        return null;
    }

    public static int countDiff(Node head1 , Node head2){

        Node temp = head1;

        int h1 = 0 , h2 = 0;

        while(temp != null){

            h1++;
            temp = temp.next;
            
        }

        temp = head2;

        while(temp != null){

            h2++;
            temp = temp.next;

        }

        return  h1-h2;
    }

    public static Node intersectionPointInLLII(Node head1 , Node head2){

        Node t1 = head1 , t2 = head2;

        while(t1 != null && t2 != null){

            t1 = t1.next;
            t2 = t2.next;

            if(t1.next == null)  t1 = head2;

            if(t2.next == null) t2 = head1;

            if(t1 == t2) return t1;

        }
        return t1;

    }

    public static void main(String[] args) {
        
        int arr1[] = {4,1,8,4,5};

        int arr2[] = {5,6,1,8,4,5};

        int arr3[] = {3,1,4,6,2};

        int arr4[] = {1,2,4,5,4,6,2};

        Node head1 = arrayToSLL(arr1);

        Node head2 = arrayToSLL(arr2);

        Node head3 = arrayToSLL(arr3);

        Node head4 = arrayToSLL(arr4);

         
        // To create a intersection point between two nodes , head1's current intersecting node and head2 's intersecting previous node...
        Node temp1 = head1;
        
        while (temp1 != null && temp1.data != 8) {
            temp1 = temp1.next;
        }

        Node temp2 = head2;

        while (temp2 != null && temp2.data != 1) {
            temp2 = temp2.next;
        }

        temp2.next = temp1; 

        Node temp3 = head3;

        while (temp3 != null && temp3.data != 4) {
            temp3 = temp3.next;
        }

        Node temp4 = head4;

        while (temp4 != null && temp4.data != 5) {
            temp4 = temp4.next;
        }

        temp4.next = temp3; 

        Node insPointI = intersectionPointInLLI(head1, head2);

        Node insPointII = intersectionPointInLLII(head3, head4);

        printSLL(insPointI);

        printSLL(insPointII);


    }

}
