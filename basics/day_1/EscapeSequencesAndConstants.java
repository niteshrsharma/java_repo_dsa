public class EscapeSequencesAndConstants {
    public static void main(String[] args) {

        // ─── ESCAPE SEQUENCES ─────────────────────────────────────────────
        System.out.println("Hello\nWorld");          // \n  — newline
        System.out.println("Hello\tWorld");          // \t  — tab
        System.out.println("Hello\\World");          // \\  — literal backslash
        System.out.println("She said \"Java\"");     // \"  — double quote inside string
        System.out.println('\'');                    // \'  — single quote inside char
        System.out.println("Hello\rWorld");          // \r  — carriage return (overwrites from start)
        System.out.println("A\bB");                  // \b  — backspace (removes A, prints B)
        System.out.println("Alert\u0007");           // \u0007 — bell/alert (may beep in terminal)

        // UNICODE ESCAPE
        System.out.println("\u0041");                // A    (unicode for 'A')
        System.out.println("\u20B9");                // ₹    (Indian Rupee symbol)
        System.out.println("\u00A9");                // ©    (copyright symbol)
        System.out.println("\u2764");                // ❤    (heart symbol)

        // ─── CONSTANTS WITH final ─────────────────────────────────────────
        final int MAX_SCORE      = 100;
        final double PI          = 3.14159265358979;
        final String APP_NAME    = "MyApp";
        final boolean DEBUG_MODE = false;

        System.out.println(MAX_SCORE);
        System.out.println(PI);
        System.out.println(APP_NAME);
        System.out.println(DEBUG_MODE);

        // MAX_SCORE = 200;  // ← compile error, cannot reassign a final variable

        // ─── CONSTANTS IN A CLASS (static final) ──────────────────────────
        System.out.println(AppConstants.MAX_USERS);
        System.out.println(AppConstants.VERSION);
        System.out.println(AppConstants.GRAVITY);
        System.out.println(AppConstants.APP_TITLE);

        // ─── BUILT-IN CONSTANTS ───────────────────────────────────────────
        System.out.println(Integer.MAX_VALUE);       // 2147483647
        System.out.println(Integer.MIN_VALUE);       // -2147483648
        System.out.println(Double.MAX_VALUE);        // 1.7976931348623157E308
        System.out.println(Double.MIN_VALUE);        // 4.9E-324
        System.out.println(Float.NaN);               // NaN  — not a number
        System.out.println(Double.POSITIVE_INFINITY);// Infinity
        System.out.println(Double.NEGATIVE_INFINITY);// -Infinity
        System.out.println(Math.PI);                 // 3.141592653589793
        System.out.println(Math.E);                  // 2.718281828459045
    }
}

// ─── CLASS WITH STATIC CONSTANTS ──────────────────────────────────────────────
class AppConstants {
    static final int    MAX_USERS  = 500;
    static final String VERSION    = "1.0.0";
    static final double GRAVITY    = 9.8;
    static final String APP_TITLE  = "Java App";
}