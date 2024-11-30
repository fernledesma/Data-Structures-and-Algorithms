import java.util.Arrays;

public class ResziableArrayBagTest {
    public static void main(String[] args) throws Exception {
        BagInterface<Integer> bag1 = new ResizableArrayBag<>();
        BagInterface<Integer> bag2 = new ResizableArrayBag<>();

        bag1.add(11);
        bag1.add(12);
        bag1.add(13);

        bag2.add(14);
        bag2.add(12);
        bag2.add(11);

        BagInterface<Integer> union = bag1.union(bag2);
        BagInterface<Integer> intersection = bag1.intersection(bag2);
        BagInterface<Integer> difference = bag1.difference(bag2);
        
        System.out.println("Bag 1: "+ Arrays.toString(bag1.toArray()));
        System.out.println("Bag 2: "+ Arrays.toString(bag2.toArray()));
        System.out.println("Union: "+ Arrays.toString(union.toArray()));
        System.out.println("Intersection: "+ Arrays.toString(intersection.toArray()));
        System.out.println("Difference: "+ Arrays.toString(difference.toArray()));
    }
}
