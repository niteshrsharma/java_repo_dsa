public class LearningVariables {
    public static void main(String[] args) {

        // INTEGER TYPES
        byte b = 127;                  // 8-bit  | range: -128 to 127
        short s = 32000;               // 16-bit | range: -32,768 to 32,767
        int i = 100000;                // 32-bit | most commonly used
        long l = 10000000000L;         // 64-bit | needs 'L' suffix

        // FLOATING POINT TYPES
        float f = 3.14f;               // 32-bit | needs 'f' suffix
        double d = 3.141592653589793;  // 64-bit | default for decimals

        // CHARACTER & BOOLEAN
        char c = 'A';                  // single character, use single quotes
        boolean flag = true;           // true or false only

        // STRING (not a primitive, it's an object)
        String name = "Java";

        // PRINTING THEM
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(flag);
        System.out.println(name);

        // TYPE CASTING
        int x = 100;
        double xAsDouble = x;          // implicit (widening) — safe, no data loss
        double pi = 3.99;
        int piAsInt = (int) pi;        // explicit (narrowing) — truncates decimal, becomes 3
        System.out.println(xAsDouble);
        System.out.println(piAsInt);

        // VAR (type inferred by compiler, Java 10+)
        var age = 25;                  // compiler sees this as int
        var city = "Mumbai";           // compiler sees this as String
        System.out.println(age);
        System.out.println(city);

        // CONSTANTS
        final double PI = 3.14159;     // 'final' makes it unchangeable
        System.out.println(PI);

        // STRING OPERATIONS
        String firstName = "John";
        String lastName = "Doe";

        System.out.println(firstName + " " + lastName);        // concatenation
        System.out.println(firstName.length());                // length
        System.out.println(firstName.toUpperCase());           // JOHN
        System.out.println(firstName.toLowerCase());           // john
        System.out.println(firstName.charAt(0));               // J
        System.out.println(firstName.contains("oh"));         // true
        System.out.println(firstName.replace("J", "B"));      // Bohn
        System.out.println("  hello  ".trim());                // removes spaces

        // STRING FORMATTING
        String formatted = String.format("Name: %s, Age: %d, GPA: %.2f", "Alice", 20, 9.75);
        System.out.println(formatted);
    }
}