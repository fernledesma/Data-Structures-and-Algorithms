public interface BagInterface<T> {
    public boolean add(T newEntry);

    public T remove();

    public boolean remove(T data);

    public void clear();

    public int getFrequencyOf(T data);

    public int getCurrentSize();

    public T[] toArray();

    public boolean contains(T data);

    public boolean isEmpty();

    /*The  union  of  two  bags  consists  of  their  contents bag  
    into  a  new  bag. */
    public BagInterface<T> union(BagInterface<T> newBag);
    
    /* The intersection of two bags is a new bag of the 
     entries that occur in both bags. 
     That is, it contains the overlapping entries.  */
    public BagInterface<T> intersection(BagInterface<T> newBag);

    /* The  difference  of  two  bags  is a new bag of  the  
     entries  that  would  be  left  in  one bag  after  removing  those  
     that  also  occur  in  the  second bag.  */
    public BagInterface<T> difference(BagInterface<T> newBag);

}
