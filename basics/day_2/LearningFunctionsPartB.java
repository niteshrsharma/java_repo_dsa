public class LearningFunctionsPartB {

    // ════════════════════════════════════════════════════════════════════════
    // SECTION 1 — MATH & NUMBER FUNCTIONS
    // ════════════════════════════════════════════════════════════════════════

    // ─── 1. ABSOLUTE VALUE (manual) ───────────────────────────────────────
    static int abs(int n) {
        return n < 0 ? -n : n;
    }

    // ─── 2. CLAMP — keeps a value within a range ──────────────────────────
    static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    // ─── 3. MAP — maps a value from one range to another ──────────────────
    // e.g. map(50, 0, 100, 0, 255) → 127  (useful for sensors, graphics)
    static double map(double value, double inMin, double inMax, double outMin, double outMax) {
        return (value - inMin) / (inMax - inMin) * (outMax - outMin) + outMin;
    }

    // ─── 4. GREATEST COMMON DIVISOR (Euclidean algorithm) ─────────────────
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);   // recursive Euclidean
    }

    // ─── 5. LEAST COMMON MULTIPLE — uses gcd() ────────────────────────────
    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;           // depends on gcd()
    }

    // ─── 6. IS PERFECT NUMBER ─────────────────────────────────────────────
    // a number equal to the sum of its proper divisors e.g. 6 = 1+2+3
    static boolean isPerfect(int n) {
        if (n < 2) return false;
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }
        }
        return sum == n;
    }

    // ─── 7. DIGIT SUM ─────────────────────────────────────────────────────
    static int digitSum(int n) {
        n = abs(n);                            // uses abs()
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // ─── 8. DIGITAL ROOT — repeatedly sum digits until single digit ────────
    static int digitalRoot(int n) {
        if (n < 10) return n;
        return digitalRoot(digitSum(n));       // recursive, depends on digitSum()
    }

    // ─── 9. COUNT DIGITS ──────────────────────────────────────────────────
    static int countDigits(int n) {
        if (n == 0) return 1;
        return (int) Math.log10(abs(n)) + 1;  // uses abs()
    }

    // ─── 10. REVERSE A NUMBER ─────────────────────────────────────────────
    static int reverseNumber(int n) {
        boolean negative = n < 0;
        n = abs(n);                            // uses abs()
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return negative ? -reversed : reversed;
    }

    // ─── 11. IS ARMSTRONG NUMBER ──────────────────────────────────────────
    // each digit raised to the power of number of digits sums to the number
    // e.g. 153 = 1³ + 5³ + 3³
    static boolean isArmstrong(int n) {
        int digits = countDigits(n);           // depends on countDigits()
        int temp = n, sum = 0;
        while (temp > 0) {
            sum += (int) Math.pow(temp % 10, digits);
            temp /= 10;
        }
        return sum == n;
    }

    // ─── 12. INTEGER SQUARE ROOT (without Math.sqrt) ──────────────────────
    static int isqrt(int n) {
        if (n < 0) return -1;
        int root = 0;
        while ((root + 1) * (root + 1) <= n) root++;
        return root;
    }


    // ════════════════════════════════════════════════════════════════════════
    // SECTION 2 — STRING FUNCTIONS
    // ════════════════════════════════════════════════════════════════════════

    // ─── 13. COUNT VOWELS ─────────────────────────────────────────────────
    static int countVowels(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) count++;
        }
        return count;
    }

    // ─── 14. COUNT CONSONANTS — depends on countVowels() ──────────────────
    static int countConsonants(String s) {
        int letters = 0;
        for (char c : s.toCharArray()) if (Character.isLetter(c)) letters++;
        return letters - countVowels(s);       // depends on countVowels()
    }

    // ─── 15. CAPITALIZE EACH WORD ─────────────────────────────────────────
    static String titleCase(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
              .append(word.substring(1).toLowerCase())
              .append(" ");
        }
        return sb.toString().trim();
    }

    // ─── 16. IS ANAGRAM ───────────────────────────────────────────────────
    static boolean isAnagram(String a, String b) {
        char[] ca = a.toLowerCase().replaceAll("\\s", "").toCharArray();
        char[] cb = b.toLowerCase().replaceAll("\\s", "").toCharArray();
        java.util.Arrays.sort(ca);
        java.util.Arrays.sort(cb);
        return java.util.Arrays.equals(ca, cb);
    }

    // ─── 17. CAESAR CIPHER — encrypt ──────────────────────────────────────
    static String caesarEncrypt(String text, int shift) {
        shift = shift % 26;
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) ((c - base + shift) % 26 + base));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // ─── 18. CAESAR CIPHER — decrypt (depends on encrypt) ─────────────────
    static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift);  // depends on caesarEncrypt()
    }

    // ─── 19. COUNT WORD OCCURRENCES ───────────────────────────────────────
    static int countOccurrences(String text, String word) {
        if (word.isEmpty()) return 0;
        int count = 0, idx = 0;
        while ((idx = text.toLowerCase().indexOf(word.toLowerCase(), idx)) != -1) {
            count++;
            idx += word.length();
        }
        return count;
    }

    // ─── 20. TRUNCATE WITH ELLIPSIS ───────────────────────────────────────
    static String truncate(String s, int maxLen) {
        if (s.length() <= maxLen) return s;
        return s.substring(0, maxLen - 3) + "...";
    }

    // ─── 21. REPEAT STRING ────────────────────────────────────────────────
    static String repeatStr(String s, int times) {
        return s.repeat(Math.max(0, times));
    }

    // ─── 22. IS NUMERIC STRING ────────────────────────────────────────────
    static boolean isNumeric(String s) {
        if (s == null || s.isBlank()) return false;
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    // ════════════════════════════════════════════════════════════════════════
    // SECTION 3 — ARRAY FUNCTIONS
    // ════════════════════════════════════════════════════════════════════════

    // ─── 23. PRINT ARRAY ──────────────────────────────────────────────────
    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ─── 24. REVERSE AN ARRAY ─────────────────────────────────────────────
    static int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    // ─── 25. BUBBLE SORT ──────────────────────────────────────────────────
    static int[] bubbleSort(int[] arr) {
        int[] a = arr.clone();                 // don't mutate original
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    // ─── 26. BINARY SEARCH — expects sorted array ─────────────────────────
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target)  left = mid + 1;
            else                    right = mid - 1;
        }
        return -1;                             // not found
    }

    // ─── 27. FILTER — returns elements greater than threshold ─────────────
    static int[] filterAbove(int[] arr, int threshold) {
        int count = 0;
        for (int n : arr) if (n > threshold) count++;
        int[] result = new int[count];
        int idx = 0;
        for (int n : arr) if (n > threshold) result[idx++] = n;
        return result;
    }

    // ─── 28. SUM OF ARRAY ─────────────────────────────────────────────────
    static int arraySum(int[] arr) {
        int total = 0;
        for (int n : arr) total += n;
        return total;
    }

    // ─── 29. ROTATE ARRAY LEFT by k positions ─────────────────────────────
    static int[] rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = arr[(i + k) % n];
        return result;
    }

    // ─── 30. MERGE TWO SORTED ARRAYS — uses bubbleSort() output ───────────
    static int[] mergeSorted(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) result[k++] = a[i++];
            else               result[k++] = b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }

    // ─── 31. REMOVE DUPLICATES ────────────────────────────────────────────
    static int[] removeDuplicates(int[] arr) {
        int[] sorted = bubbleSort(arr);        // depends on bubbleSort()
        int count = 1;
        for (int i = 1; i < sorted.length; i++) if (sorted[i] != sorted[i-1]) count++;
        int[] result = new int[count];
        result[0] = sorted[0];
        int idx = 1;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i-1]) result[idx++] = sorted[i];
        }
        return result;
    }


    // ════════════════════════════════════════════════════════════════════════
    // SECTION 4 — PATTERN & FORMATTING FUNCTIONS
    // ════════════════════════════════════════════════════════════════════════

    // ─── 32. PRINT STAR TRIANGLE ──────────────────────────────────────────
    static void printTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            System.out.println(repeatStr("* ", i));   // depends on repeatStr()
        }
    }

    // ─── 33. PRINT PYRAMID ────────────────────────────────────────────────
    static void printPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            System.out.print(repeatStr(" ", rows - i));   // depends on repeatStr()
            System.out.println(repeatStr("* ", i));
        }
    }

    // ─── 34. FORMAT AS TABLE ROW ──────────────────────────────────────────
    static String tableRow(String name, int age, double gpa) {
        return String.format("│ %-15s │ %3d │ %5.2f │", name, age, gpa);
    }

    // ─── 35. PROGRESS BAR STRING ──────────────────────────────────────────
    static String progressBar(int percent, int width) {
        percent = clamp(percent, 0, 100);           // depends on clamp()
        int filled = (int) map(percent, 0, 100, 0, width);  // depends on map()
        return "[" + repeatStr("█", filled) + repeatStr("░", width - filled) + "] " + percent + "%";
    }


    // ════════════════════════════════════════════════════════════════════════
    // SECTION 5 — CONVERSION & UTILITY FUNCTIONS
    // ════════════════════════════════════════════════════════════════════════

    // ─── 36. CELSIUS TO FAHRENHEIT ────────────────────────────────────────
    static double celsiusToFahrenheit(double c) { return c * 9.0 / 5.0 + 32; }

    // ─── 37. FAHRENHEIT TO CELSIUS ────────────────────────────────────────
    static double fahrenheitToCelsius(double f) { return (f - 32) * 5.0 / 9.0; }

    // ─── 38. TEMPERATURE DESCRIPTION — uses both converters ───────────────
    static String describeTemp(double celsius) {
        double f = celsiusToFahrenheit(celsius);
        String feel = celsius < 0 ? "Freezing" : celsius < 15 ? "Cold"
                    : celsius < 25 ? "Comfortable" : celsius < 35 ? "Warm" : "Hot";
        return String.format("%.1f°C = %.1f°F — %s", celsius, f, feel);
    }

    // ─── 39. SECONDS TO HH:MM:SS ──────────────────────────────────────────
    static String formatTime(int totalSeconds) {
        int hours   = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    // ─── 40. BMI CALCULATOR ───────────────────────────────────────────────
    static double bmi(double weightKg, double heightM) {
        return weightKg / (heightM * heightM);
    }

    static String bmiCategory(double weightKg, double heightM) {
        double b = bmi(weightKg, heightM);          // depends on bmi()
        if (b < 18.5) return String.format("BMI %.1f — Underweight", b);
        if (b < 25.0) return String.format("BMI %.1f — Normal",      b);
        if (b < 30.0) return String.format("BMI %.1f — Overweight",  b);
        return              String.format("BMI %.1f — Obese",         b);
    }

    // ─── 41. SIMPLE INTEREST ──────────────────────────────────────────────
    static double simpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    // ─── 42. COMPOUND INTEREST ────────────────────────────────────────────
    static double compoundInterest(double principal, double rate, int n, double time) {
        return principal * Math.pow(1 + rate / (n * 100), n * time) - principal;
    }

    // ─── 43. COMPARE SI vs CI — uses both above ───────────────────────────
    static void compareInterest(double principal, double rate, int years) {
        double si = simpleInterest(principal, rate, years);
        double ci = compoundInterest(principal, rate, 12, years);
        System.out.printf("Principal : ₹%.2f | Rate : %.1f%% | Years : %d%n", principal, rate, years);
        System.out.printf("Simple    : ₹%.2f%n", si);
        System.out.printf("Compound  : ₹%.2f%n", ci);
        System.out.printf("Difference: ₹%.2f%n", ci - si);
    }


    // ════════════════════════════════════════════════════════════════════════
    // SECTION 6 — RECURSIVE DEEP DIVES
    // ════════════════════════════════════════════════════════════════════════

    // ─── 44. SUM OF DIGITS RECURSIVELY ────────────────────────────────────
    static int digitSumRecursive(int n) {
        n = abs(n);
        if (n < 10) return n;
        return n % 10 + digitSumRecursive(n / 10);
    }

    // ─── 45. BINARY SEARCH RECURSIVE ──────────────────────────────────────
    static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target)  return binarySearchRecursive(arr, target, mid + 1, right);
        return                         binarySearchRecursive(arr, target, left, mid - 1);
    }

    // ─── 46. FLATTEN — sum all digits of all numbers in array ─────────────
    // shows how array + recursion work together
    static int totalDigitSum(int[] arr) {
        int total = 0;
        for (int n : arr) total += digitSumRecursive(n);   // depends on digitSumRecursive()
        return total;
    }

    // ─── 47. TOWER OF HANOI ───────────────────────────────────────────────
    static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " → " + to);
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " → " + to);
        hanoi(n - 1, aux, to, from);
    }


    // ════════════════════════════════════════════════════════════════════════
    // SECTION 7 — FINAL COMPOSITE FUNCTIONS
    // ════════════════════════════════════════════════════════════════════════

    // ─── 48. FULL NUMBER REPORT — uses 8 functions ────────────────────────
    static void numberReport(int n) {
        int[]  arr    = {n, n*2, n*3, n*4, n*5};
        int[]  sorted = bubbleSort(arr);
        System.out.println("\n── Number Report: " + n + " ──");
        System.out.println("Digits        : " + countDigits(n));
        System.out.println("Digit sum     : " + digitSum(n));
        System.out.println("Digital root  : " + digitalRoot(n));
        System.out.println("Reversed      : " + reverseNumber(n));
        System.out.println("Armstrong?    : " + isArmstrong(n));
        System.out.println("Perfect?      : " + isPerfect(n));
        System.out.println("Clamp(0,50)   : " + clamp(n, 0, 50));
        System.out.println("Mapped 0→255  : " + (int) map(n, 0, 100, 0, 255));
        System.out.print  ("Multiples     : "); printArray(sorted);
    }

    // ─── 49. FULL STRING REPORT — uses 7 functions ────────────────────────
    static void stringReport(String s) {
        System.out.println("\n── String Report: \"" + s + "\" ──");
        System.out.println("Length        : " + s.length());
        System.out.println("Title case    : " + titleCase(s));
        System.out.println("Vowels        : " + countVowels(s));
        System.out.println("Consonants    : " + countConsonants(s));
        System.out.println("Truncate(10)  : " + truncate(s, 10));
        System.out.println("Is numeric?   : " + isNumeric(s));
        System.out.println("Encrypted(3)  : " + caesarEncrypt(s, 3));
        System.out.println("Decrypted     : " + caesarDecrypt(caesarEncrypt(s, 3), 3));
        System.out.println("Occurrences of 'a': " + countOccurrences(s, "a"));
    }

    // ─── 50. FULL ARRAY PIPELINE — uses 9 functions ───────────────────────
    static void arrayPipeline(int[] arr) {
        System.out.println("\n── Array Pipeline ──");
        System.out.print("Original  : "); printArray(arr);

        int[] sorted   = bubbleSort(arr);
        int[] reversed = reverseArray(sorted);
        int[] filtered = filterAbove(arr, 50);
        int[] unique   = removeDuplicates(arr);
        int[] rotated  = rotateLeft(arr, 2);

        System.out.print("Sorted    : "); printArray(sorted);
        System.out.print("Reversed  : "); printArray(reversed);
        System.out.print("Above 50  : "); printArray(filtered);
        System.out.print("Unique    : "); printArray(unique);
        System.out.print("Rotated L2: "); printArray(rotated);

        System.out.println("Sum       : " + arraySum(arr));
        System.out.println("Digit sum : " + totalDigitSum(arr));

        int target = sorted[sorted.length / 2];
        int idx    = binarySearch(sorted, target);
        System.out.println("BinSearch(" + target + "): index " + idx);

        int[] a2 = {10, 30, 50};
        int[] b2 = {20, 40, 60};
        System.out.print("Merged    : "); printArray(mergeSorted(a2, b2));
    }


    // ════════════════════════════════════════════════════════════════════════
    // MAIN
    // ════════════════════════════════════════════════════════════════════════
    public static void main(String[] args) {

        // ── SECTION 1: MATH ────────────────────────────────────────────────
        System.out.println("══ MATH FUNCTIONS ══");
        System.out.println("abs(-42)          : " + abs(-42));
        System.out.println("clamp(150, 0, 100): " + clamp(150, 0, 100));
        System.out.println("clamp(-10, 0, 100): " + clamp(-10, 0, 100));
        System.out.printf ("map(50,0,100,0,255): %.0f%n", map(50, 0, 100, 0, 255));
        System.out.println("gcd(48, 18)       : " + gcd(48, 18));
        System.out.println("lcm(4, 6)         : " + lcm(4, 6));
        System.out.println("isPerfect(6)      : " + isPerfect(6));
        System.out.println("isPerfect(28)     : " + isPerfect(28));
        System.out.println("isPerfect(10)     : " + isPerfect(10));
        System.out.println("digitSum(9875)    : " + digitSum(9875));
        System.out.println("digitalRoot(9875) : " + digitalRoot(9875));
        System.out.println("countDigits(9875) : " + countDigits(9875));
        System.out.println("reverseNumber(123): " + reverseNumber(123));
        System.out.println("isArmstrong(153)  : " + isArmstrong(153));
        System.out.println("isArmstrong(370)  : " + isArmstrong(370));
        System.out.println("isArmstrong(100)  : " + isArmstrong(100));
        System.out.println("isqrt(144)        : " + isqrt(144));
        System.out.println("isqrt(50)         : " + isqrt(50));

        // ── SECTION 2: STRINGS ─────────────────────────────────────────────
        System.out.println("\n══ STRING FUNCTIONS ══");
        System.out.println("countVowels       : " + countVowels("Hello World"));
        System.out.println("countConsonants   : " + countConsonants("Hello World"));
        System.out.println("titleCase         : " + titleCase("the quick brown fox"));
        System.out.println("isAnagram         : " + isAnagram("listen", "silent"));
        System.out.println("isAnagram         : " + isAnagram("hello", "world"));
        System.out.println("caesarEncrypt(3)  : " + caesarEncrypt("Hello Java", 3));
        System.out.println("caesarDecrypt(3)  : " + caesarDecrypt(caesarEncrypt("Hello Java", 3), 3));
        System.out.println("countOccurrences  : " + countOccurrences("banana", "an"));
        System.out.println("truncate(20)      : " + truncate("The quick brown fox jumps", 20));
        System.out.println("isNumeric(\"3.14\"): " + isNumeric("3.14"));
        System.out.println("isNumeric(\"abc\") : " + isNumeric("abc"));

        // ── SECTION 3: ARRAYS ──────────────────────────────────────────────
        System.out.println("\n══ ARRAY FUNCTIONS ══");
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 25, 34};

        System.out.print("Original   : "); printArray(arr);
        System.out.print("Sorted     : "); printArray(bubbleSort(arr));
        System.out.print("Reversed   : "); printArray(reverseArray(arr));
        System.out.print("Above 30   : "); printArray(filterAbove(arr, 30));
        System.out.print("No dupes   : "); printArray(removeDuplicates(arr));
        System.out.print("Rotated L3 : "); printArray(rotateLeft(arr, 3));

        int[] sorted = bubbleSort(arr);
        System.out.println("BinSearch(25): index " + binarySearch(sorted, 25));
        System.out.println("BinSearch(99): index " + binarySearch(sorted, 99));

        int[] x = {1, 3, 5, 7}, y = {2, 4, 6, 8};
        System.out.print("Merged     : "); printArray(mergeSorted(x, y));

        // ── SECTION 4: PATTERNS ────────────────────────────────────────────
        System.out.println("\n══ PATTERN FUNCTIONS ══");
        printTriangle(4);
        printPyramid(4);
        System.out.println("─".repeat(25));
        System.out.println(tableRow("Alice", 20, 9.75));
        System.out.println(tableRow("Bob",   22, 8.40));
        System.out.println(tableRow("Charlie", 19, 9.10));
        System.out.println("─".repeat(25));
        System.out.println(progressBar(0,   30));
        System.out.println(progressBar(35,  30));
        System.out.println(progressBar(70,  30));
        System.out.println(progressBar(100, 30));

        // ── SECTION 5: CONVERSIONS ─────────────────────────────────────────
        System.out.println("\n══ CONVERSION FUNCTIONS ══");
        System.out.println(describeTemp(-5));
        System.out.println(describeTemp(10));
        System.out.println(describeTemp(22));
        System.out.println(describeTemp(40));
        System.out.println("formatTime(3661)  : " + formatTime(3661));
        System.out.println("formatTime(86399) : " + formatTime(86399));
        System.out.println(bmiCategory(70, 1.75));
        System.out.println(bmiCategory(50, 1.75));
        System.out.println(bmiCategory(100, 1.75));
        System.out.println();
        compareInterest(10000, 8, 5);

        // ── SECTION 6: RECURSION ───────────────────────────────────────────
        System.out.println("\n══ RECURSIVE FUNCTIONS ══");
        System.out.println("digitSumRecursive(9875): " + digitSumRecursive(9875));
        System.out.println("totalDigitSum([12,99]) : " + totalDigitSum(new int[]{12, 99}));

        int[] sArr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println("binarySearchRecursive(23): index " + binarySearchRecursive(sArr, 23, 0, sArr.length - 1));
        System.out.println("binarySearchRecursive(99): index " + binarySearchRecursive(sArr, 99, 0, sArr.length - 1));

        System.out.println("\n── Tower of Hanoi (3 disks) ──");
        hanoi(3, 'A', 'C', 'B');

        // ── SECTION 7: COMPOSITE REPORTS ──────────────────────────────────
        numberReport(153);
        numberReport(75);
        stringReport("Hello Java World");
        arrayPipeline(new int[]{42, 17, 88, 55, 23, 67, 42, 91, 17});
    }
}