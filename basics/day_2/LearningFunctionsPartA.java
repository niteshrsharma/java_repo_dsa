public class LearningFunctionsPartA {

    // ─── 1. BASIC FUNCTION — no params, no return ─────────────────────────
    static void greet() {
        System.out.println("Hello from a function!");
    }

    // ─── 2. FUNCTION WITH PARAMETERS ──────────────────────────────────────
    static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // ─── 3. FUNCTION WITH RETURN VALUE ────────────────────────────────────
    static int add(int a, int b) {
        return a + b;
    }

    // ─── 4. FUNCTION CALLING ANOTHER FUNCTION ─────────────────────────────
    static double square(double n) {
        return n * n;
    }

    static double areaOfCircle(double radius) {
        return Math.PI * square(radius);   // calls square()
    }

    // ─── 5. MULTIPLE RETURN PATHS ─────────────────────────────────────────
    static String classify(int n) {
        if (n > 0) return "Positive";
        if (n < 0) return "Negative";
        return "Zero";
    }

    // ─── 6. OVERLOADED FUNCTIONS (same name, different params) ────────────
    static int multiply(int a, int b) {
        return a * b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // ─── 7. VARARGS — variable number of arguments ────────────────────────
    static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    // ─── 8. RECURSION — function calling itself ───────────────────────────
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;       // base case
        return n * factorial(n - 1);           // recursive call
    }

    // ─── 9. RECURSION — fibonacci ─────────────────────────────────────────
    static int fibonacci(int n) {
        if (n <= 1) return n;                  // base case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ─── 10. FUNCTION WITH ARRAY PARAMETER ────────────────────────────────
    static double average(int[] arr) {
        int total = 0;
        for (int n : arr) total += n;
        return (double) total / arr.length;
    }

    // ─── 11. FUNCTION RETURNING AN ARRAY ──────────────────────────────────
    static int[] minMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        return new int[]{min, max};            // returns array with 2 values
    }

    // ─── 12. CHAINED FUNCTION CALLS ───────────────────────────────────────
    static int doubleIt(int n)   { return n * 2; }
    static int addTen(int n)     { return n + 10; }
    static int subtractFive(int n) { return n - 5; }

    static int pipeline(int n) {
        return subtractFive(addTen(doubleIt(n)));  // chain: double → add 10 → subtract 5
    }

    // ─── 13. PASSING FUNCTION RESULT AS ARGUMENT ──────────────────────────
    static int square(int n)     { return n * n; }
    static int cube(int n)       { return n * n * n; }

    static void printPowerSum(int n) {
        int result = add(square(n), cube(n));  // square(n) + cube(n) passed to add()
        System.out.println(n + "² + " + n + "³ = " + result);
    }

    // ─── 14. GUARD CLAUSE PATTERN ─────────────────────────────────────────
    static String divide(int a, int b) {
        if (b == 0) return "Error: division by zero";   // guard clause exits early
        return "Result: " + (a / b);
    }

    // ─── 15. DEFAULT-LIKE BEHAVIOR WITH OVERLOADING ───────────────────────
    static void printBox(String message, int width) {
        String border = "─".repeat(width);
        System.out.println("┌" + border + "┐");
        System.out.println("│ " + message + " │");
        System.out.println("└" + border + "┘");
    }

    static void printBox(String message) {
        printBox(message, message.length() + 2);  // calls the other overload with default width
    }

    // ─── 16. FUNCTION WITH BOOLEAN RETURN ─────────────────────────────────
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // ─── 17. MUTUALLY DEPENDENT FUNCTIONS ─────────────────────────────────
    static boolean isEven(int n) {
        if (n == 0) return true;
        return isOdd(Math.abs(n) - 1);    // calls isOdd()
    }

    static boolean isOdd(int n) {
        if (n == 0) return false;
        return isEven(Math.abs(n) - 1);   // calls isEven()
    }

    // ─── 18. FUNCTION BUILDING ON MULTIPLE OTHERS ─────────────────────────
    static double hypotenuse(double a, double b) {
        return Math.sqrt(add((int)square(a), (int)square(b)));  // uses add() and square()
    }

    // cleaner version without casting
    static double hypotenusePure(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    // ─── 19. FUNCTION WITH STRING MANIPULATION ────────────────────────────
    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static boolean isPalindrome(String s) {
        String clean = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return clean.equals(reverse(clean));   // uses reverse()
    }

    // ─── 20. HIGHER-ORDER STYLE — function that prints result of another ───
    static void printResult(String label, int value) {
        System.out.printf("%-20s: %d%n", label, value);
    }

    // ─── 21. RECURSIVE FUNCTION — power ───────────────────────────────────
    static double power(double base, int exp) {
        if (exp == 0) return 1;
        if (exp < 0)  return 1 / power(base, -exp);
        return base * power(base, exp - 1);
    }

    // ─── 22. FUNCTION COMPOSING EVERYTHING — final summary ────────────────
    static void studentReport(String name, int[] scores) {
        double avg    = average(scores);
        int[]  mm     = minMax(scores);
        int    total  = sum(scores);           // varargs version

        System.out.println("\n── Report for " + name + " ──");
        System.out.printf("Scores  : ");
        for (int sc : scores) System.out.print(sc + " ");
        System.out.println();
        System.out.printf("Total   : %d%n",   total);
        System.out.printf("Average : %.2f%n", avg);
        System.out.printf("Min     : %d%n",   mm[0]);
        System.out.printf("Max     : %d%n",   mm[1]);
        System.out.printf("Grade   : %s%n",   avg >= 90 ? "A" : avg >= 75 ? "B" : avg >= 60 ? "C" : "F");
    }


    // ─── MAIN ─────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // 1. basic
        greet();

        // 2. with parameter
        greetUser("Alice");

        // 3. return value
        System.out.println("3 + 4 = " + add(3, 4));

        // 4. function calling function
        System.out.printf("Area of circle r=5 : %.2f%n", areaOfCircle(5));

        // 5. multiple return paths
        System.out.println(classify(10));
        System.out.println(classify(-5));
        System.out.println(classify(0));

        // 6. overloading
        System.out.println("multiply int   : " + multiply(3, 4));
        System.out.println("multiply double: " + multiply(3.5, 2.0));
        System.out.println("multiply 3 args: " + multiply(2, 3, 4));

        // 7. varargs
        System.out.println("sum()         : " + sum());
        System.out.println("sum(1,2,3)    : " + sum(1, 2, 3));
        System.out.println("sum(1..5)     : " + sum(1, 2, 3, 4, 5));

        // 8. recursion factorial
        System.out.println("5! = " + factorial(5));
        System.out.println("0! = " + factorial(0));

        // 9. recursion fibonacci
        System.out.print("Fibonacci: ");
        for (int k = 0; k <= 9; k++) System.out.print(fibonacci(k) + " ");
        System.out.println();

        // 10. array parameter
        int[] scores = {85, 92, 78, 95, 88};
        System.out.printf("Average: %.2f%n", average(scores));

        // 11. returning array
        int[] result = minMax(scores);
        System.out.println("Min: " + result[0] + " | Max: " + result[1]);

        // 12. chained calls
        System.out.println("pipeline(5) : " + pipeline(5));   // (5*2)+10-5 = 15

        // 13. result as argument
        printPowerSum(3);    // 9 + 27 = 36
        printPowerSum(4);    // 16 + 64 = 80

        // 14. guard clause
        System.out.println(divide(10, 2));
        System.out.println(divide(10, 0));

        // 15. overload as default
        printBox("Java");
        printBox("Hello", 20);

        // 16. boolean return
        System.out.println("17 prime? " + isPrime(17));
        System.out.println("18 prime? " + isPrime(18));

        // 17. mutually dependent
        System.out.println("isEven(4): " + isEven(4));
        System.out.println("isOdd(7) : " + isOdd(7));

        // 18. hypotenuse
        System.out.printf("hypotenuse(3,4) : %.2f%n", hypotenusePure(3, 4));

        // 19. palindrome using reverse
        System.out.println("racecar palindrome? " + isPalindrome("racecar"));
        System.out.println("hello   palindrome? " + isPalindrome("hello"));
        System.out.println("A man a plan a canal Panama? " + isPalindrome("A man a plan a canal Panama"));

        // 20. labeled result printer
        printResult("factorial(6)", factorial(6));
        printResult("sum(1 to 5)", sum(1, 2, 3, 4, 5));

        // 21. recursive power
        System.out.printf("2^10 = %.0f%n",   power(2, 10));
        System.out.printf("2^-3 = %.4f%n",   power(2, -3));

        // 22. full composition
        studentReport("Alice", new int[]{88, 92, 79, 95, 84});
        studentReport("Bob",   new int[]{55, 62, 48, 70, 60});
    }
}