import java.util.Arrays;

public class MaxHeap<T extends Comparable<? super T>> {
	private T[] heap;
	private int lastIndex;
    private static int countOfReheaps;
	private static final int DEFAULT_CAPACITY=25;
    private static final int MAX_CAPACITY= 10000;
	
	public MaxHeap(){
		this(DEFAULT_CAPACITY);
	}
    public MaxHeap(int initialCapacity){
    	if(initialCapacity< DEFAULT_CAPACITY){
    		initialCapacity= DEFAULT_CAPACITY;
    	}
    	else
    		checkCapacity(initialCapacity);
    	@SuppressWarnings("unchecked")
    	T[] tempHeap= (T[]) new Comparable[initialCapacity +1];
    	heap=tempHeap;
    	lastIndex=0;
    	
    }
	private void checkCapacity(int initialCapacity) {
		if (initialCapacity < DEFAULT_CAPACITY){
            initialCapacity = DEFAULT_CAPACITY;
        }
		else if (initialCapacity > MAX_CAPACITY){ 
            throw new IllegalStateException("Please create a heap that has a capacity"+
            "larger than" + MAX_CAPACITY);
        }
	}
	
	public void add(T newEntry){
		int newIndex= lastIndex+1;
		int parentIndex= newIndex/2;
		while ((parentIndex>0)&& newEntry.compareTo(heap[parentIndex])>0){
			heap[newIndex] = heap[parentIndex];
			parentIndex= newIndex /2;
		}
		heap[newIndex]= newEntry;
		lastIndex++;
		ensureCapacity();
		
	}
	private void ensureCapacity() {
		if (lastIndex >= heap.length){
            int newCapacity = 2 * heap.length;
            checkCapacity(newCapacity);
            heap = Arrays.copyOf(heap, newCapacity);
        }
		
	}
	
	public void reheap(int rootIndex){
		boolean done= false;
		T orphan = heap[rootIndex];
		int leftChildIndex= 2* rootIndex;
		while(!done && (leftChildIndex <= lastIndex)){
			int largerChildIndex= leftChildIndex;
			int rightChildIndex= 2* rootIndex+1;
			if((rightChildIndex<= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex])>0){
				largerChildIndex = rightChildIndex;
			}
			
			if(orphan.compareTo(heap[largerChildIndex])<0){
				heap[rootIndex]= heap[largerChildIndex];
				rootIndex= largerChildIndex;
				leftChildIndex=2*rootIndex;
                countOfReheaps++;
			}
			else{
				done= true;
			}
			heap[rootIndex]=orphan;
		}
			
		}
    
    public T getMax(){
        T root = null;
        if(!isEmpty()){
			root= heap[1];
        }
        return root;
    
    }
	
    public T removeMax(){
		T root= null;
			
		if(!isEmpty()){
			root= heap[1];
			heap[1]= heap[lastIndex];
			lastIndex--;
			reheap(1);
		}
		return root;
			
	}
	public int getSize(){
        return lastIndex;
    }
    public void clear(){
        while(lastIndex > -1){
            heap[lastIndex] = null;
            lastIndex--;
        }
        lastIndex= 0;
    }
	private boolean isEmpty() {
		return lastIndex < 1;
	}
    public T[] toArray(){
        T[] copy = heap;
        return copy;
    }
    public T[] getFirstTen(){
        @SuppressWarnings("unchecked")
        T[] firstTen=(T[]) new Comparable[10];
        T[] copy = toArray();
        for (int i=1; i<10; i++){
            firstTen[i] = copy[i];
        }
        return firstTen;
    }
    public int getCountOfReheaps(){
        int reheaps= countOfReheaps;
        return reheaps;
    }
	public MaxHeap(T[] entries){
		this(entries.length);
		lastIndex= entries.length;
		
		//Copy given array to data field
		for(int index =0; index<entries.length; index++){
			heap[index+1]= entries[index];
		}
		
		// create heap
		for(int rootIndex= lastIndex/2; rootIndex>0; rootIndex--){
			reheap(rootIndex);
		}
	}
 
	
}
