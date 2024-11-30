import java.io.*;
import java.util.*;

public class TestHeap<T extends Comparable<? super T>> {
    public static  <T extends String> void main(String[] args) throws FileNotFoundException {
        int MAX_CAPACITY=101;

        File file = new File("data.txt");
        Scanner sn = new Scanner(file);

        @SuppressWarnings("unchecked")
        T[] entries= (T[]) new Comparable[MAX_CAPACITY];

        int i=0;
        while (sn.hasNext()){
            entries[i+1] = (T) sn.nextLine();
            i++;
        }

        MaxHeap heap = new MaxHeap();
        MaxHeap smartHeap = new MaxHeap(entries);
        for (T d: entries){
            heap.add(d);
        }
        heap.reheap(1);
        System.out.println("Heap using the regular method: "+Arrays.toString(heap.getFirstTen()));
        System.out.println("Number of swaps in the heap:"+ heap.getCountOfReheaps());
        System.out.println("Heap after 10 removals: "+ heap.getFirstTen());

        System.out.println("Heap using the optimal method: "+Arrays.toString(smartHeap.getFirstTen()));
        System.out.println("Number of swaps in the heap:"+ smartHeap.getCountOfReheaps());
        System.out.println("Heap after 10 removals: "+ smartHeap.getFirstTen());
    }
}
