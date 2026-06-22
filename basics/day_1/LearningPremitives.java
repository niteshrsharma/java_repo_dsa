public class LearningPremitives {
    public static void main(String[] args) {

        // PRIMITIVE DATA TYPES AND THEIR SIZES
        System.out.println("byte    : " + Byte.SIZE       + " bits | " + Byte.BYTES       + " byte  | " + Byte.MIN_VALUE    + " to " + Byte.MAX_VALUE);
        System.out.println("short   : " + Short.SIZE      + " bits | " + Short.BYTES      + " bytes | " + Short.MIN_VALUE   + " to " + Short.MAX_VALUE);
        System.out.println("int     : " + Integer.SIZE    + " bits | " + Integer.BYTES    + " bytes | " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("long    : " + Long.SIZE       + " bits | " + Long.BYTES       + " bytes | " + Long.MIN_VALUE    + " to " + Long.MAX_VALUE);
        System.out.println("float   : " + Float.SIZE      + " bits | " + Float.BYTES      + " bytes | " + Float.MIN_VALUE   + " to " + Float.MAX_VALUE);
        System.out.println("double  : " + Double.SIZE     + " bits | " + Double.BYTES     + " bytes | " + Double.MIN_VALUE  + " to " + Double.MAX_VALUE);
        System.out.println("char    : " + Character.SIZE  + " bits | " + Character.BYTES  + " bytes | 0 to " + (int) Character.MAX_VALUE);
        System.out.println("boolean : JVM dependent (typically 1 bit, stored as 1 byte)");

        // ACTUAL DECLARATIONS
        byte    a = 100;
        short   b = 30000;
        int     c = 100000;
        long    d = 10000000000L;
        float   e = 3.14f;
        double  f = 3.141592653589793;
        char    g = 'Z';
        boolean h = false;

        System.out.println("\n--- Values ---");
        System.out.println("byte    : " + a);
        System.out.println("short   : " + b);
        System.out.println("int     : " + c);
        System.out.println("long    : " + d);
        System.out.println("float   : " + e);
        System.out.println("double  : " + f);
        System.out.println("char    : " + g);
        System.out.println("boolean : " + h);

        // OVERFLOW BEHAVIOR
        byte max = 127;
        max++;                         // goes past max, wraps around to -128
        System.out.println("\nOverflow byte: " + max);

        int intMax = Integer.MAX_VALUE;
        intMax++;                      // wraps to Integer.MIN_VALUE
        System.out.println("Overflow int : " + intMax);
    }
}