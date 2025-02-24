package ErrorHandling_11;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/

public class StackTrace {
    public static void main(String[] args) {
        a();
    }
    static void a() {
        b();
    }
    static void b() {
        c();
    }
    static void c() {
        d();
    }
    static void d() {
        Thread.dumpStack();
    }
}
