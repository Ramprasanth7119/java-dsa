
import java.util.*;

class DLLNode{

    int val , key;
    int freq;
    DLLNode prev , next;

    public DLLNode(int key , int val){

        this.key = key;
        this.val = val;
        this.freq = 1;

    }

}

class DoubleLinkedList{

    int listsize;
    DLLNode head , tail;

    public DoubleLinkedList(){

        this.listsize = 1;
        this.head = new DLLNode(0 , 0);
        this.tail = new DLLNode(0 , 0);
        head.next = tail;
        tail.prev = head;

    }

    public void addNode(DLLNode temp){

        DLLNode curr = head.next;

        temp.next = curr;
        temp.prev = head;

        head.next = temp;
        curr.prev = temp;

        listsize++;

    }

    public void removeNode(DLLNode temp){

        DLLNode prevNode = temp.prev;
        DLLNode nextNode = temp.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        listsize--;

    }

}

public class LFUCache {

    int capacity;
    int cursize;
    int minFreq;

    Map<Integer, DLLNode> cache;
    Map<Integer , DoubleLinkedList> freqMap;

    public LFUCache(int capacity){

        this.capacity = capacity;
        this.cursize = 0;
        this.minFreq = 0;

        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();

    }

    public int getKey(int key){

        DLLNode currKey = cache.get(key);

        if(currKey == null) return -1;

        return currKey.val;

    }

    
    
    public static void main(String[] args) {
        
        

    }

}
