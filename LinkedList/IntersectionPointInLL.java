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

    public static void main(String[] args) {
        
        int arr1[] = {4,1,8,4,5};

        int arr2[] = {5,6,1,8,4,5};

        Node head1 = arrayToSLL(arr1);

        Node head2 = arrayToSLL(arr2);

        Node temp1 = head1;
        
        while (temp1 != null && temp1.data != 8) {
            temp1 = temp1.next;
        }

        Node temp2 = head2;

        while (temp2 != null && temp2.data != 1) {
            temp2 = temp2.next;
        }

        temp2.next = temp1; 

        Node insPoint = intersectionPointInLLI(head1, head2);

        printSLL(insPoint);


    }

}
