package IOOC.linearSearch;

public class TestDivisor {

    public static void main(String[] args) {
        int n = 16;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }

        System.out.println("better way");

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                System.out.println(i == n/i?"":n/i);

            }
        }

        //i 和 n/i 是n的兩個約數
    }
}