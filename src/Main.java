public class Main {
    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
    }

    public static int sum(int k) {
        if (k > 0) {
            System.out.println("i");
            return k + sum(k - 1);
        } else {
            System.out.println("hi");
            return 0;
        }
    }

}
