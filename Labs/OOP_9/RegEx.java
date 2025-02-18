package OOP_9;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/17/2025, Monday
 **/

public class RegEx {
    public static void main(String[] args) {
        // 1. Literals
        System.out.println("1. Literal Characters");
        System.out.printf("\"cat\".matches(\"cat\"): %b\n", "cat".matches("cat"));
        System.out.printf("\"cat\".matches(\"bat\"): %b\n", "cat".matches("bat"));
        System.out.printf("\"cat\".matches(\"ca\"): %b\n", "cat".matches("ca"));
        System.out.printf("\"096\".matches(\"096\"): %b\n", "096".matches("096"));
        System.out.println();

        // 2. Meta Characters
        System.out.println("2. Meta Characters");
        System.out.printf("\".\" matches any character: \"a\".matches(\".\"): %b\n", "a".matches("."));
        System.out.printf("\"*\" zero or more: \"aaa\".matches(\"a*\"): %b\n", "aaa".matches("a*"));
        System.out.printf("\"+\" one or more: \"aaa\".matches(\"a+\"): %b\n", "aaa".matches("a+"));
        System.out.printf("\"?\" zero or one: \"a\".matches(\"a?\"): %b\n", "a".matches("a?"));
        System.out.println();

        // 3. Character Classes
        System.out.println("3. Character Classes");
        System.out.printf("\"[abc]\" any character in the set: \"b\".matches(\"[abc]\"): %b\n", "b".matches("[abc]"));
        System.out.printf("\"[^abc]\" any character not in the set: \"z\".matches(\"[^abc]\"): %b\n", "z".matches("[^abc]"));
        System.out.printf("\"[a-z]\" any lowercase letter: \"m\".matches(\"[a-z]\"): %b\n", "m".matches("[a-z]"));
        System.out.printf("\"[A-Z]\" any capital letter: \"M\".matches(\"[A-Z]\"): %b\n", "M".matches("[A-Z]"));
        System.out.println();

        // 4. Predefined Character Classes
        System.out.println("4. Predefined Character Classes");
        System.out.printf("\"\\\\d\" digit: \"5\".matches(\"\\\\d\"): %b\n", "5".matches("\\d"));
        System.out.printf("\"\\\\w\" word character: \"k\".matches(\"\\\\w\"): %b\n", "k".matches("\\w"));
        System.out.printf("\"\\\\s\" whitespace: \" \".matches(\"\\\\s\"): %b\n", " ".matches("\\s"));
        System.out.printf("\"\\\\D\" non-digit: \"a\".matches(\"\\\\D\"): %b\n", "a".matches("\\D"));
        System.out.println();

        // 5. Grouping and Alternation
        System.out.println("5. Grouping and Alternation");
        System.out.printf("Grouping: \"abc\".matches(\"(abc)\"): %b\n", "abc".matches("(abc)"));
        System.out.printf("Alternation: \"cat\".matches(\"cat|dog\"): %b\n", "cat".matches("cat|dog"));
        System.out.printf("Combined: \"ac\".matches(\"(a|b)c\"): %b\n", "ac".matches("(a|b)c"));
        System.out.println();

        // 6. Anchors
        System.out.println("6. Anchors");
        System.out.printf("\"^\" start: \"abc\".matches(\"^abc\"): %b\n", "abc".matches("^abc"));
        System.out.printf("\"$\" end: \"abc\".matches(\"abc$\"): %b\n", "abc".matches("abc$"));
        System.out.printf("\"\\b\" word boundary: \"cat\".matches(\"\\bcat\\b\"): %b\n", "cat".matches("\\bcat\\b"));
        System.out.println();

        // 7. Lookaheads & Lookbehinds (Advanced)
        System.out.println("7. Lookaheads & Lookbehinds (Advanced)");
        System.out.printf("Positive lookahead: \"abc\".matches(\"ab(?=c).*\"): %b\n", "abc".matches("ab(?=c).*"));
        System.out.printf("Negative lookahead: \"abd\".matches(\"ab(?!c).*\"): %b\n", "abd".matches("ab(?!c).*"));
        System.out.printf("Positive lookbehind: \"cab\".matches(\".*(?<=c)ab\"): %b\n", "cab".matches(".*(?<=c)ab"));
        System.out.printf("Negative lookbehind: \"dab\".matches(\".*(?<!c)ab\"): %b\n", "dab".matches(".*(?<!c)ab"));
        System.out.println();

        // 8. Escape Sequences
        System.out.println("8. Escape Sequences");
        System.out.printf("Escape dot: \".\".matches(\"\\.\"): %b\n", ".".matches("\\."));
        System.out.printf("Escape backslash: \"\\\\\".matches(\"\\\\\"): %b\n", "\\".matches("\\\\"));
        System.out.printf("Escape brackets: \"[\".matches(\"\\[\"): %b\n", "[".matches("\\["));
        System.out.println();

        // 9. Flags (Modifiers)
        System.out.println("9. Flags (Modifiers)");
        System.out.printf("Case-insensitive: \"Cat\".matches(\"(?i)cat\"): %b\n", "Cat".matches("(?i)cat"));
        System.out.printf("Multiline: \"first\\nsecond\".matches(\"(?m).*^first$\\n.*\"): %b\n", "first\nsecond".matches("(?m).*^first$\n.*"));
        System.out.printf("Multiline: \"first\\nsecond\".matches(\"(?m).*\\n^second$.*\"): %b\n", "first\nsecond".matches("(?m).*\n^second$.*"));
        System.out.printf("Dotall: \"a\\nb\".matches(\"(?s)a.b\"): %b\n", "a\nb".matches("(?s)a.b"));
        System.out.printf("Verbose/Ignore whitespace:\"ab\".matches(\"(?x)a  b\"): %b\n", "ab".matches("(?x)a  b"));
    }
}