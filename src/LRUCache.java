import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class DLinkedList{

        int key;
        int value;

        DLinkedList prev;
        DLinkedList next;

    }

    private void addNode(DLinkedList node){

        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DLinkedList node){

        DLinkedList pre = node.prev;
        DLinkedList post = node.next;

        pre.next = post;
        post.prev = pre;

    }

    private void moveToHead(DLinkedList node){

        removeNode(node);
        addNode(node);

    }

    private DLinkedList popTail(){

        DLinkedList res = tail.prev;
        removeNode(res);

        return res;
    }

    private Map<Integer,DLinkedList> cache = new HashMap<>();
    private int count;
    private int capacity;

    DLinkedList head,tail;

    public LRUCache(int capacity){
        head = new DLinkedList();
        head.prev = null;

        tail = new DLinkedList();
        tail.next = null;

        head.next = tail;
        tail.prev = head;

        this.count = 0;
        this.capacity = capacity;
    }

    public int get(int key){

        DLinkedList node = cache.get(key);
        if(node == null){
            return -1;
        }
        else{
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key,int value){

        DLinkedList node = cache.get(key);
        if (node == null){

            DLinkedList newNode = new DLinkedList();
            newNode.key = key;
            newNode.value = value;

            cache.put(key,newNode);
            addNode(newNode);
            count++;
            if(count>capacity){

                DLinkedList res = popTail();
                cache.remove(res);
                count--;

            }

        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }


    public static void main(String a[]){

        LRUCache obj = new LRUCache(2);

        int param1 = obj.get(1);
        System.out.println(param1);
        obj.put(1,1);
        param1 = obj.get(1);
        System.out.println(param1);

    }

}
