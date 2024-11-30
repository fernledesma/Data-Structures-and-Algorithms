import java.util.*;
public class LinkedBag<T> implements BagInterface<T>{
    private Node firstNode;
    private int numberOfEntries;

    private class Node{
        private T data;
        private Node next;
        private Node(T dataPortion){
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }
        private T getData(){
            return data;
        }
        private void setData(T newData){
            data = newData;
        }
        private Node getNextNode(){
            return next;
        }
        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }


    public LinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] finalArr = (T[]) new Object[numberOfEntries];
        int i = 0;
        while(firstNode != null){
            finalArr[i] = firstNode.data;
            i++;
            firstNode = firstNode.next;
        }
        return finalArr;
    }

    public boolean add(T newEntry){
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    public boolean remove (T data){
       boolean found = false;
        Node currentNode = firstNode;
       Node previousNode = null;

       while (currentNode != null){
        if(data.equals(currentNode.data)){
            if(previousNode == null){
                firstNode = currentNode.next;
            }
            else{
                previousNode = currentNode.next;
            }
            numberOfEntries--;
            found = true;
            break;
        }
        previousNode = currentNode;
        currentNode = currentNode.next;
       }
       return found;
    }

    public void clear(){
        firstNode = null;
        numberOfEntries = 0;
    }

    public int getFrequencyOf(T data){
        int frequency = 0;
        Node currentNode = firstNode;
        while (currentNode != null){
            if(data.equals(currentNode.data)){
                frequency++;
            }
            currentNode = currentNode.next;
        }
        return frequency;
    }

    public int getCurrentSize(){
        return numberOfEntries;
    }

    public boolean contains(T data){
        Node currentNode = firstNode;
        while (currentNode != null){
            if(data.equals(currentNode.data)){
               return true;
            }
        currentNode = currentNode.next;
        }
        return false;
    }
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    public BagInterface<T> union(BagInterface<T> newBag){
        BagInterface<T> finalBag = new LinkedBag<>();
        T[] thisArray = this.toArray();
        T[] newArray = newBag.toArray();
        for(T data : thisArray){
            finalBag.add(data);
        }
        for(T data : newArray){
            finalBag.add(data);
        }
        return finalBag;
    }
    public BagInterface<T> intersection(BagInterface<T> newBag){
        BagInterface<T> finalBag = new LinkedBag<>();
        T[] thisArray = this.toArray();
        T[] newArray = newBag.toArray();
        for(T data : thisArray){
            finalBag.add(data);
        }
        for(T data : newArray){
            finalBag.add(data);
        }
        return finalBag;
    }
    public BagInterface<T> difference(BagInterface<T> newBag){
        BagInterface<T> finalBag = new LinkedBag<>();
        T[] thisArray = this.toArray();
        T[] newArray = newBag.toArray();
        for(T data : thisArray){
            finalBag.add(data);
        }
        for(T data : newArray){
            finalBag.add(data);
        }
        return finalBag;
    }
}
