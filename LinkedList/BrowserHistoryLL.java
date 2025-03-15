class Node {

    String data;
    Node next , prev;

    public Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public Node(String data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

}

class Browser{ 
    
    Node head;
    Node curr = head;

    public Browser(String Homepage){

        head = new Node(Homepage);

    }

    public void visit(String url){

        Node nw = new Node(url);
        head.next = nw;
        head = nw;

    }

    public String back(int steps){

        while(steps > 0){

            if(head.prev != null){

                head = head.prev;
                steps--;

            } else {

                break;

            }

        }

        return head.data;
    }

    public String forward(int steps){

        while(steps> 0){

            if(head.next != null){

                head = head.next;
                steps--;

            } else{

                break;

            }
        }
        return head.data;
    }
}

