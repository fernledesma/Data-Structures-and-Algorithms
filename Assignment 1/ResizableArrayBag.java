import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T>{
    private T[] bag;
    private int numberOfEntries;
    
    public ResizableArrayBag(){
        this(10);
    }
    public ResizableArrayBag(int initCapacity){
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[initCapacity];
        bag = tempBag;
    }
    
    public int getCurrentSize(){
        return numberOfEntries;
    }

    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry){
        int newLen = 2 * bag.length;
        if(numberOfEntries >= bag.length){
            bag = Arrays.copyOf(bag, newLen);
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    public T remove(){
        T result = null;
        if(numberOfEntries > 0){
            result = bag[numberOfEntries - 1];
            bag[numberOfEntries -1] = null;
            numberOfEntries--;
        }
        return result;
    }

    public boolean remove(T data){
        for(int i = 0; i< numberOfEntries; i++){
            if(bag[i].equals(data)){
                bag[i] = bag[numberOfEntries - 1];
                bag[numberOfEntries =1] = null;
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }
    
    public void clear(){
        for (int i=0; i<numberOfEntries; i++){
            bag[i]= null;
        }
        numberOfEntries=0;
    }
    public int getFrequencyOf(T data){
        int temp=0;
        for(int i=0; i< numberOfEntries; i++){
            if(bag[i].equals(data)){
                temp++;
            }
        }
        return temp;
    }
    public boolean contains(T data){
        for(int i=0; i< numberOfEntries; i++){
            if(bag[i].equals(data)){
                return true;
            }
        }
        return false;
    }

    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] finalArr = (T[])new Object[numberOfEntries];
        for(int i=0; i< numberOfEntries; i++){
            finalArr[i] = bag[i];
        }
        return finalArr;
    }
    @Override
    public BagInterface<T>union(BagInterface<T> newBag ){
        BagInterface<T> finalBag = new ResizableArrayBag<>();
        T[] thisArray = this.toArray();
        T[] newArray= newBag.toArray();
        for(T data : thisArray){
            finalBag.add(data);
        }
        for(T data : newArray){
            finalBag.add(data);
        }
        return finalBag;
    }
    @Override
    public BagInterface<T> intersection (BagInterface<T> newBag){
        BagInterface<T> finalBag = new ResizableArrayBag<>();
        T[] thisArray = this.toArray();
       
        for(T data : thisArray){
            if(newBag.contains(data)){
                finalBag.add(data);
            }
        }
        return finalBag;
    }
    @Override
    public BagInterface<T> difference(BagInterface<T> newBag){
        BagInterface<T> finalBag = new ResizableArrayBag<>();
        T[] thisArray = this.toArray();

        for(T data : thisArray){
            if(!newBag.contains(data)){
                finalBag.add(data);
            }
        }
        return finalBag;
    }
}
