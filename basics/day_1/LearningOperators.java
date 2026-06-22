public class LearningOperators {
    public static void main(String[] args) {

        // ─── ARITHMETIC OPERATORS ─────────────────────────────────────────
        int a = 10, b = 3;

        System.out.println(a + b);       // 13  — addition
        System.out.println(a - b);       // 7   — subtraction
        System.out.println(a * b);       // 30  — multiplication
        System.out.println(a / b);       // 3   — integer division (truncates decimal)
        System.out.println(a % b);       // 1   — modulus (remainder)

        double x = 10.0, y = 3.0;
        System.out.println(x / y);       // 3.3333... — decimal division

        // ─── ASSIGNMENT OPERATORS ─────────────────────────────────────────
        int n = 10;
        n += 5;   System.out.println(n); // 15  — n = n + 5
        n -= 3;   System.out.println(n); // 12  — n = n - 3
        n *= 2;   System.out.println(n); // 24  — n = n * 2
        n /= 4;   System.out.println(n); // 6   — n = n / 4
        n %= 4;   System.out.println(n); // 2   — n = n % 4

        // ─── INCREMENT & DECREMENT ────────────────────────────────────────
        int i = 5;
        System.out.println(i++);         // 5   — post-increment: use then increment
        System.out.println(i);           // 6
        System.out.println(++i);         // 7   — pre-increment: increment then use
        System.out.println(i--);         // 7   — post-decrement: use then decrement
        System.out.println(i);           // 6
        System.out.println(--i);         // 5   — pre-decrement: decrement then use

        // ─── COMPARISON OPERATORS ─────────────────────────────────────────
        int p = 10, q = 20;
        System.out.println(p == q);      // false — equal to
        System.out.println(p != q);      // true  — not equal to
        System.out.println(p >  q);      // false — greater than
        System.out.println(p <  q);      // true  — less than
        System.out.println(p >= q);      // false — greater than or equal
        System.out.println(p <= q);      // true  — less than or equal

        // ─── LOGICAL OPERATORS ────────────────────────────────────────────
        boolean t = true, f = false;
        System.out.println(t && f);      // false — AND: both must be true
        System.out.println(t || f);      // true  — OR:  at least one must be true
        System.out.println(!t);          // false — NOT: flips the boolean

        // short-circuit evaluation
        int val = 0;
        // val != 0 is false, so right side never evaluates (avoids division by zero)
        System.out.println(val != 0 && (10 / val > 1));   // false
        // val == 0 is true, so right side never evaluates
        System.out.println(val == 0 || (10 / val > 1));   // true

        // ─── BITWISE OPERATORS ────────────────────────────────────────────
        int u = 5;   // binary: 0101
        int v = 3;   // binary: 0011

        System.out.println(u & v);       // 1    — AND:  0101 & 0011 = 0001
        System.out.println(u | v);       // 7    — OR:   0101 | 0011 = 0111
        System.out.println(u ^ v);       // 6    — XOR:  0101 ^ 0011 = 0110
        System.out.println(~u);          // -6   — NOT:  flips all bits
        System.out.println(u << 1);      // 10   — left shift:  0101 → 1010 (multiply by 2)
        System.out.println(u >> 1);      // 2    — right shift: 0101 → 0010 (divide by 2)
        System.out.println(-5 >>> 1);    // unsigned right shift: fills with 0 instead of sign bit

        // ─── TERNARY OPERATOR ─────────────────────────────────────────────
        int age = 20;
        String result = (age >= 18) ? "Adult" : "Minor";
        System.out.println(result);      // Adult

        // nested ternary (use sparingly)
        int marks = 75;
        String grade = (marks >= 90) ? "A" : (marks >= 75) ? "B" : (marks >= 60) ? "C" : "F";
        System.out.println(grade);       // B

        // ─── instanceof OPERATOR ──────────────────────────────────────────
        String name = "Java";
        System.out.println(name instanceof String);   // true

        Object obj = 42;
        System.out.println(obj instanceof Integer);   // true
        System.out.println(obj instanceof String);    // false

        // ─── OPERATOR PRECEDENCE (high to low) ───────────────────────────
        System.out.println(2 + 3 * 4);       // 14  — * before +
        System.out.println((2 + 3) * 4);     // 20  — () first
        System.out.println(10 - 3 - 2);      // 5   — left to right
        System.out.println(2 + 3 == 5);      // true — arithmetic before comparison
        System.out.println(true || false && false);   // true — && before ||
    }
}