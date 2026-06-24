public class LearningTypeConversions {
    public static void main(String[] args) {

        // ─── 1. IMPLICIT (WIDENING) CONVERSION ───────────────────────────
        // smaller type → larger type, done automatically, no data loss
        // byte → short → int → long → float → double

        byte   byteVal   = 42;
        short  shortVal  = byteVal;       // byte  → short  (auto)
        int    intVal    = shortVal;      // short → int    (auto)
        long   longVal   = intVal;        // int   → long   (auto)
        float  floatVal  = longVal;       // long  → float  (auto)
        double doubleVal = floatVal;      // float → double (auto)

        System.out.println("── Widening ──");
        System.out.println("byte   : " + byteVal);
        System.out.println("short  : " + shortVal);
        System.out.println("int    : " + intVal);
        System.out.println("long   : " + longVal);
        System.out.println("float  : " + floatVal);
        System.out.println("double : " + doubleVal);

        // ─── 2. EXPLICIT (NARROWING) CONVERSION ──────────────────────────
        // larger type → smaller type, must cast manually, may lose data

        double d = 9.99;
        float  f = (float)  d;            // double → float  (loses precision)
        long   l = (long)   d;            // double → long   (drops decimal → 9)
        int    i = (int)    d;            // double → int    (drops decimal → 9)
        short  s = (short)  i;            // int    → short
        byte   b = (byte)   i;            // int    → byte

        System.out.println("\n── Narrowing ──");
        System.out.println("double : " + d);
        System.out.println("float  : " + f);
        System.out.println("long   : " + l);
        System.out.println("int    : " + i);
        System.out.println("short  : " + s);
        System.out.println("byte   : " + b);

        // ─── 3. OVERFLOW DURING NARROWING ────────────────────────────────
        int  bigInt  = 300;
        byte overflow = (byte) bigInt;    // 300 exceeds byte max (127), wraps around
        System.out.println("\n── Overflow ──");
        System.out.println("int 300 cast to byte: " + overflow);   // 44

        int  bigInt2   = 130;
        byte overflow2 = (byte) bigInt2;
        System.out.println("int 130 cast to byte: " + overflow2);  // -126

        // ─── 4. char CONVERSIONS ──────────────────────────────────────────
        char ch    = 'A';
        int  ascii = ch;                  // char → int (gives ASCII value, auto)
        char back  = (char) 66;           // int  → char (explicit)

        System.out.println("\n── char conversions ──");
        System.out.println("char 'A' to int  : " + ascii);         // 65
        System.out.println("int  66  to char : " + back);          // B
        System.out.println("char arithmetic  : " + (char)(ch + 1));// B

        // ─── 5. STRING → PRIMITIVE ────────────────────────────────────────
        String strInt    = "100";
        String strDouble = "3.14";
        String strLong   = "9999999999";
        String strBool   = "true";

        int     parsedInt    = Integer.parseInt(strInt);
        double  parsedDouble = Double.parseDouble(strDouble);
        long    parsedLong   = Long.parseLong(strLong);
        boolean parsedBool   = Boolean.parseBoolean(strBool);
        float   parsedFloat  = Float.parseFloat("2.5f");

        System.out.println("\n── String → Primitive ──");
        System.out.println(parsedInt);
        System.out.println(parsedDouble);
        System.out.println(parsedLong);
        System.out.println(parsedBool);
        System.out.println(parsedFloat);

        // ─── 6. PRIMITIVE → STRING ────────────────────────────────────────
        int    num  = 42;
        double pi   = 3.14;

        String s1 = String.valueOf(num);           // recommended
        String s2 = Integer.toString(num);         // using wrapper
        String s3 = "" + num;                      // implicit (works but not clean)
        String s4 = String.valueOf(pi);

        System.out.println("\n── Primitive → String ──");
        System.out.println(s1 + " | " + s2 + " | " + s3 + " | " + s4);

        // ─── 7. PRIMITIVE → WRAPPER (AUTOBOXING) ─────────────────────────
        // Java automatically wraps primitive into its object type

        int     primitive = 50;
        Integer boxed     = primitive;             // autoboxing (auto)
        int     unboxed   = boxed;                 // unboxing   (auto)

        Double  dBoxed    = 3.14;                  // double autoboxed to Double
        double  dUnboxed  = dBoxed;                // Double unboxed to double

        System.out.println("\n── Autoboxing / Unboxing ──");
        System.out.println("boxed   : " + boxed);
        System.out.println("unboxed : " + unboxed);
        System.out.println("dBoxed  : " + dBoxed);
        System.out.println("dUnboxed: " + dUnboxed);

        // ─── 8. WRAPPER UTILITY METHODS ───────────────────────────────────
        System.out.println("\n── Wrapper Utilities ──");
        System.out.println(Integer.toBinaryString(255));       // 11111111
        System.out.println(Integer.toHexString(255));          // ff
        System.out.println(Integer.toOctalString(255));        // 377
        System.out.println(Integer.MAX_VALUE);                 // 2147483647
        System.out.println(Double.isNaN(0.0 / 0.0));           // true
        System.out.println(Double.isInfinite(1.0 / 0.0));      // true

        // ─── 9. NUMERIC LITERAL FORMATS ───────────────────────────────────
        int decimal     = 255;
        int binary      = 0b11111111;     // prefix 0b
        int hex         = 0xFF;           // prefix 0x
        int octal       = 0377;           // prefix 0
        int readable    = 1_000_000;      // underscores for readability (Java 7+)
        long bigNum     = 9_999_999_999L;

        System.out.println("\n── Numeric Literals ──");
        System.out.println("decimal  : " + decimal);
        System.out.println("binary   : " + binary);
        System.out.println("hex      : " + hex);
        System.out.println("octal    : " + octal);
        System.out.println("readable : " + readable);
        System.out.println("bigNum   : " + bigNum);

        // ─── 10. INVALID CONVERSIONS (compile errors if uncommented) ──────
        // boolean x = (boolean) 1;    // cannot cast number to boolean
        // int y = (int) true;          // cannot cast boolean to int
        // String z = (String) 123;     // cannot cast int to String, use valueOf()
    }
}