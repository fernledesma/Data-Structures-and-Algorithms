import java.util.Arrays;

public class LinkedBagTest {
    public static void main(String[] args) throws Exception {
        BagInterface<Character> bag1 = new ResizableArrayBag<>();
        BagInterface<Character> bag2 = new ResizableArrayBag<>();

        bag1.add('a');
        bag1.add('b');
        bag1.add('c');

        bag2.add('b');
        bag2.add('e');
        bag2.add('a');

        BagInterface<Character> union = bag1.union(bag2);
        BagInterface<Character> intersection = bag1.intersection(bag2);
        BagInterface<Character> difference = bag1.difference(bag2);
        
        System.out.println("Bag 1: "+ Arrays.toString(bag1.toArray()));
        System.out.println("Bag 2: "+ Arrays.toString(bag2.toArray()));
        System.out.println("Union: "+ Arrays.toString(union.toArray()));
        System.out.println("Intersection: "+ Arrays.toString(intersection.toArray()));
        System.out.println("Difference: "+ Arrays.toString(difference.toArray()));
    }
}
