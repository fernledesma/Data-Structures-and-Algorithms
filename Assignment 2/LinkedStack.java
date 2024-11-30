import java.util.EmptyStackException;
import java.util.Stack;

public class LinkedStack<T> implements StackInterface<T> {
    //first node reference
    private Node topNode;
    //default constructor
    public LinkedStack(){
        topNode=null;
    }
        private class Node{
            private T data;
            private Node next;

            private Node(T data){
                this.data = data;
                this.next = null;
            }
            private Node(T data, Node next){
                this.data = data;
                this.next = next;
            }
         }
    @Override
    public void push(T newEntry){
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }
    @Override
    public T pop(){
        T top = peek();
        topNode = topNode.next;
        return top;
    }
    @Override
    public T peek(){
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        else{
            return topNode.data;
            }
        }

    @Override
    public boolean isEmpty(){
        return topNode == null;
    }
    @Override
    public void clear(){
        topNode = null;
    }
}
