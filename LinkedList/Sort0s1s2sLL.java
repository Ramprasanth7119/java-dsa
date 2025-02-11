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

public class Sort0s1s2sLL {

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

    public static Node sort0s1s2sI(Node head){
        
        int cnt0 = 0 , cnt1 = 0 , cnt2 = 0;

        Node temp = head;

        while(temp != null){

            if(temp.data == 0) cnt0++;
            else if(temp.data == 1) cnt1++;
            else cnt2++;

            temp = temp.next;
        }


        temp = head;

        while(temp != null){

            if(cnt0 != 0){

                temp.data = 0;
                cnt0--;

            } else if(cnt1 != 0){

                temp.data = 1;
                cnt1--;

            } else {

                temp.data = 2;
                cnt2--;

            }
            temp = temp.next;

        }
        return head;

    }

    public static Node sort0s1s2sII(Node head){

        Node zeroNode = new Node(-1);
        Node oneNode = new Node(-1);
        Node twoNode = new Node(-1);

        Node zero = zeroNode , one = oneNode , two = twoNode;

        Node temp = head;

        while(temp != null){

            if(temp.data == 0){

                zero.next = temp;
                zero = temp;

            } else if(temp.data == 1){

                one.next = temp;
                one = temp;

            } else {

                two.next = temp;
                two = temp;

            }

            temp = temp.next;

        }


        if(oneNode.next != null){
            zero.next = oneNode.next;
        } else{
            zero.next = twoNode.next;
        }

        one.next = twoNode.next;
        two.next = null;

        return zeroNode.next;

    }

    public static void main(String[] args) {
        
        int arr1[] = {0,0,2,1,2,1,0,1};

        Node head1 = arrayToLL(arr1);

        int arr2[] = {0,0,2,1,2,1,0,1};

        Node head2 = arrayToLL(arr2);

        Node sortI = sort0s1s2sI(head1);

        Node sortII = sort0s1s2sII(head2);

        printLL(sortI);

        printLL(sortII);


    }
}
