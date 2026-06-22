public class StringOperationsAndMethods {
    public static void main(String[] args) {

        String str = "Hello, Java!";

        // ─── BASIC OPERATIONS ───────────────────────────────────────────
        System.out.println(str.length());                      // 12
        System.out.println(str.toUpperCase());                 // HELLO, JAVA!
        System.out.println(str.toLowerCase());                 // hello, java!
        System.out.println(str.trim());                        // removes leading/trailing spaces
        System.out.println(str.isEmpty());                     // false
        System.out.println("".isEmpty());                      // true
        System.out.println(str.isBlank());                     // false
        System.out.println("   ".isBlank());                   // true

        // ─── ACCESSING CHARACTERS ────────────────────────────────────────
        System.out.println(str.charAt(0));                     // H
        System.out.println(str.indexOf("Java"));               // 7  (first occurrence)
        System.out.println(str.lastIndexOf("l"));              // 3  (last occurrence)
        System.out.println(str.substring(7));                  // Java!
        System.out.println(str.substring(7, 11));              // Java  (7 inclusive, 11 exclusive)

        // ─── CHECKING CONTENT ────────────────────────────────────────────
        System.out.println(str.contains("Java"));              // true
        System.out.println(str.startsWith("Hello"));           // true
        System.out.println(str.endsWith("!"));                 // true

        // ─── REPLACING ───────────────────────────────────────────────────
        System.out.println(str.replace("Java", "World"));      // Hello, World!
        System.out.println(str.replaceAll("[aeiou]", "*"));    // H*ll*, J*v*!  (regex)

        // ─── SPLITTING & JOINING ─────────────────────────────────────────
        String csv = "one,two,three,four";
        String[] parts = csv.split(",");
        for (String part : parts) {
            System.out.println(part);                          // one  two  three  four
        }

        String joined = String.join(" - ", "one", "two", "three");
        System.out.println(joined);                            // one - two - three

        // ─── COMPARING STRINGS ───────────────────────────────────────────
        String a = "hello";
        String b = "hello";
        String c = new String("hello");

        System.out.println(a == b);                            // true  (same string pool reference)
        System.out.println(a == c);                            // false (different object in memory)
        System.out.println(a.equals(c));                       // true  (compares content)
        System.out.println(a.equalsIgnoreCase("HELLO"));       // true

        // ─── CONVERSION ──────────────────────────────────────────────────
        String numStr = "42";
        int parsed = Integer.parseInt(numStr);                 // String → int
        double parsedD = Double.parseDouble("3.14");           // String → double
        String fromInt = String.valueOf(100);                  // int → String
        System.out.println(parsed + 8);                        // 50
        System.out.println(parsedD);                           // 3.14
        System.out.println(fromInt);                           // 100

        // ─── STRING FORMATTING ───────────────────────────────────────────
        // %s = string | %d = integer | %f = float | %c = char | %b = boolean | %n = newline
        String formatted = String.format("Name: %s | Age: %d | GPA: %.2f", "Alice", 20, 9.756);
        System.out.println(formatted);                         // Name: Alice | Age: 20 | GPA: 9.76

        System.out.printf("%-10s %5d %8.2f%n", "Bob", 25, 7.5);  // left-align, width padding
        System.out.printf("%-10s %5d %8.2f%n", "Alice", 20, 9.75);

        // ─── TEXT BLOCKS (Java 15+) ───────────────────────────────────────
        String json = """
                {
                    "name": "Alice",
                    "age": 20
                }
                """;
        System.out.println(json);

        // ─── STRING BUILDER (mutable, faster for repeated concatenation) ──
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(", ");
        sb.append("World");
        sb.insert(5, "!");                                     // insert at index 5
        sb.replace(0, 5, "Hi");                                // replace index 0–5
        sb.reverse();                                          // reverses the string
        sb.delete(0, 2);                                       // delete index 0–2
        System.out.println(sb.toString());
    }
}