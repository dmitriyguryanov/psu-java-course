public class JitDemo {

    public static long work() {
        long x = 0;
        for (int i = 0; i < 10_000_000; i++) {
            x += (i & 1);
        }
        return x;
    }

    public static void main(String[] args) {
        long t;

        for (int i = 0; i < 50; i++) {
            t = System.nanoTime();
            work();
            long elapsedNs = System.nanoTime() - t;
            double elapsedMs = elapsedNs / 1_000_000.0;
            System.out.println(i + ": " + elapsedMs + " мс");
        }
    }
}