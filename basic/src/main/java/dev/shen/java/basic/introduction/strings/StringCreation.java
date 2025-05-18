package dev.shen.java.basic.introduction.strings;

public class StringCreation {
    public static void main(String[] args) {
        // --- Part 1: String Literals and the String Constant Pool ---
        System.out.println("--- Part 1: String Literals & String Constant Pool ---");

        // s1 and s2 refer to the same object in the String Constant Pool
        String s1 = "Hello";
        String s2 = "Hello";

        System.out.println("s1: \"" + s1 + "\" (hashCode: " + s1.hashCode() + "), " +
                "(id: " + System.identityHashCode(s1) + ")");
        System.out.println("s2: \"" + s2 + "\" (hashCode: " + s2.hashCode() + "), " +
                "(id: " + System.identityHashCode(s2) + ")");

        // == compares object references
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true, because their content is the same
        System.out.println("s1 == s2: " + (s1 == s2)); // true, because they point to the same pool object

        // --- Part 2: 'new String()' creates objects on the Heap ---
        System.out.println("\n--- Part 2: 'new String()' & Heap Allocation ---");

        // s3 is a new object created on the heap
        String s3 = new String("Hello");
        // s4 is another new object created on the heap, distinct from s3
        String s4 = new String("Hello");

        System.out.println("s3: \"" + s3 + "\" (hashCode: " + s3.hashCode() + ")" +
                "(id: " + System.identityHashCode(s3) + ")");
        System.out.println("s4: \"" + s4 + "\" (hashCode: " + s4.hashCode() + ")" +
                "(id: " + System.identityHashCode(s4) + ")");

        System.out.println("s3 == s4: " + (s3 == s4)); // false, different objects on the heap
        System.out.println("s3.equals(s4): " + s3.equals(s4)); // true, content is the same

        // Comparing a literal with a heap object
        System.out.println("s1 == s3: " + (s1 == s3)); // false, s1 is in pool, s3 is on heap
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true, content is the same

        // --- Part 3: String Immutability ---
        System.out.println("\n--- Part 3: String Immutability ---");

        String originalString = "Java";
        System.out.println("Original String (originalString): \"" + originalString + "\" (hashCode: " + originalString.hashCode() + ", id: " + System.identityHashCode(originalString) + ")");

        // Modifying the string (e.g., concatenation)
        String modifiedString = originalString.concat(" is Fun"); // This creates a NEW String object

        System.out.println("Modified String (modifiedString): \"" + modifiedString + "\" (hashCode: " + modifiedString.hashCode() + ", id: " + System.identityHashCode(modifiedString) + ")");
        System.out.println("Original String after concat (originalString): \"" + originalString + "\" (hashCode: " + originalString.hashCode() + ", id: " + System.identityHashCode(originalString) + ")");

        System.out.println("originalString.equals(modifiedString): " + (originalString.equals(modifiedString))); // false, s1 is in pool, s3 is on heap
        // Check if originalString still points to the same object
        System.out.println("originalString == \"Java\": " + (originalString == "Java")); // true, it wasn't changed
        // Check if modifiedString is a new object
        System.out.println("originalString == modifiedString: " + (originalString == modifiedString)); // false, modifiedString is a new object

        String anotherModification = originalString.toUpperCase(); // This also creates a NEW String object
        System.out.println("Uppercase String (anotherModification): \"" + anotherModification + "\" (hashCode: " + anotherModification.hashCode() + ", id: " + System.identityHashCode(anotherModification) + ")");
        System.out.println("originalString == anotherModification: " + (originalString == anotherModification)); // false

        // --- Part 4: Using intern() ---
        System.out.println("\n--- Part 4: Using intern() ---");

        String heapString = new String("InternTest");
        String poolString = "InternTest";

        System.out.println("heapString: \"" + heapString + "\" (id: " + System.identityHashCode(heapString) + ")");
        System.out.println("poolString: \"" + poolString + "\" (id: " + System.identityHashCode(poolString) + ")");
        System.out.println("heapString == poolString: " + (heapString == poolString)); // false

        // The intern() method returns a canonical representation for the string object.
        // If the pool already contains a string equal to this String object (as determined by equals(Object)),
        // then the string from the pool is returned. Otherwise, this String object is added to the pool
        // and a reference to this String object is returned.
        String internedString = heapString.intern();

        System.out.println("internedString: \"" + internedString + "\" (id: " + System.identityHashCode(internedString) + ")");
        System.out.println("internedString == poolString: " + (internedString == poolString)); // true, internedString now points to the object in the pool
        System.out.println("internedString == heapString: " + (internedString == heapString)); // false, unless heapString was the first "InternTest" to be interned.
        // More precisely, if "InternTest" was not already in the pool,
        // heapString.intern() would add heapString's value to the pool
        // and internedString would point to that new pool entry.
        // However, since "InternTest" (poolString) was already created,
        // intern() finds it.

        String s5 = "Hello"; // From pool
        String s6 = new String("Hello").intern(); // "Hello" from pool is returned
        System.out.println("s5 == s6: " + (s5 == s6)); // true
    }
}
