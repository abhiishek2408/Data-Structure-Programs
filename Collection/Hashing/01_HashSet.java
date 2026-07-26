package Collection.Hashing;
import java.util.*;

class HashSetFunction {
    public static void main(final String[] args){

        HashSet<String> h = new HashSet<String>();

        h.add("India");
        h.add("Australia");
        h.add("South Africa");

        h.add("India"); //duplicate

        System.out.println(h);   

        System.out.println("List contains India or not:" + h.contains("India"));

        h.remove("Australia");
        System.out.println("List after removing Australia:" + h);

        System.out.println("Iterating over list:");
        for (String string : h) {
            System.out.print(string + ", ");
        }

        // isEmpty()
        System.out.println("\nIs HashSet empty? " + h.isEmpty());

        // size()
        System.out.println("Size of the HashSet: " + h.size());

        // clone()
        HashSet<String> cloneH = (HashSet<String>)h.clone();
        System.out.println("Cloned HashSet: " + cloneH);

        // equals()
        HashSet<String> h2 = new HashSet<String>();
        h2.add("India");
        h2.add("South Africa");
        System.out.println("Is HashSet equal to h2? " + h.equals(h2));

        // hashCode()
        System.out.println("HashSet's hash code: " + h.hashCode());

        // removeAll(Collection)
        ArrayList<String> collection = new ArrayList<String>();
        collection.add("India");
        h.removeAll(collection);
        System.out.println("HashSet after removing all elements in collection: " + h);

        // addAll(Collection)
        collection.add("Australia");
        h.addAll(collection);
        System.out.println("HashSet after adding all elements in collection: " + h);

        // containsAll(Collection)
        System.out.println("Does HashSet contain all elements in collection? " + h.containsAll(collection));

        // retainAll(Collection)
        HashSet<String> h3 = new HashSet<String>();
        h3.add("South Africa");
        h.retainAll(h3);
        System.out.println("HashSet after retaining all elements in h3: " + h);

        // toString()
        System.out.println("HashSet as a string: " + h.toString());
    }
}
