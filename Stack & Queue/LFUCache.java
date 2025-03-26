 
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

    public void displayCache() {
    
            System.out.println("Current Cache Content:");
    
            for (Map.Entry<Integer, DLLNode> entry : cache.entrySet()) {
    
                DLLNode node = entry.getValue();
                System.out.println("Key: " + entry.getKey() + ", Value: " + node.val + ", Frequency: " + node.freq);
    
            }
    
        }
        
    
        int getKey(int key){
    
            DLLNode currKey = cache.get(key);
    
            if(currKey == null) return -1;
    
            updateNode(currKey);
    
            return currKey.val;
    
        }
    
        void updateNode(DLLNode curr){
    
            int currFreq = curr.freq;
            DoubleLinkedList currList = freqMap.get(currFreq);
    
            currList.removeNode(curr);
    
            if(currList.listsize == 0 && minFreq == currFreq) minFreq++;    
    
            curr.freq++;
            DoubleLinkedList nextList = freqMap.getOrDefault(curr.freq , new DoubleLinkedList());
    
            nextList.addNode(curr);
            freqMap.put(curr.freq , nextList);
    
    
        }
    
        void put(int key , int val){
    
            if(capacity == 0) return; 
    
            if(cache.containsKey(key)){
    
                DLLNode curr = cache.get(key);
                curr.val = val;
                updateNode(curr);
    
            }
    
            else{
    
                cursize++;
    
                if(cursize > capacity){
    
                    DoubleLinkedList minList = freqMap.get(minFreq);
    
                    cache.remove(minList.tail.prev.key);
    
                    minList.removeNode(minList.tail.prev);
    
                    cursize--;
                }
    
                minFreq = 1;
    
                DLLNode newNode = new DLLNode(key , val);
    
                DoubleLinkedList newList = freqMap.getOrDefault(1 , new DoubleLinkedList());
    
                newList.addNode(newNode);
    
                cache.put(key , newNode);
    
                freqMap.put(1 , newList);
    
    
            }
    
        }
        
        
        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
    
            System.out.print("Enter the capacity of the LFU Cache: ");
    
            int capacity = sc.nextInt();
    
            LFUCache lfuCache = new LFUCache(capacity);
    
            while (true) {
    
                System.out.println("\nMenu:");
                System.out.println("1. Get key");
                System.out.println("2. Put key-value");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
    
                int choice = sc.nextInt();
    
                if (choice == 1) {
    
                    System.out.print("Enter key to get value: ");
    
                    int key = sc.nextInt();
                    int value = lfuCache.getKey(key);
    
                    if (value == -1) {
    
                        System.out.println("Key not found.");
    
                    } else {
    
                        System.out.println("Value for key " + key + ": " + value);
    
                    }
    
                } else if (choice == 2) {
    
                    System.out.print("Enter key to put: ");
                    int key = sc.nextInt();
    
                    System.out.print("Enter value for key " + key + ": ");
                    int value = sc.nextInt();
    
                    lfuCache.put(key, value);
                    System.out.println("Key-value pair (" + key + ", " + value + ") added/updated.");
    
                } else if (choice == 3) {
    
                    System.out.println("Exiting...");
                    break;
    
                } else {
    
                    System.out.println("Invalid choice, please try again.");
    
                }
    
            }
    
            sc.close();
    
            lfuCache.displayCache();
    }

}
