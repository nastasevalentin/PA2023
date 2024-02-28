public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide 3 arguments: a, b, and k.");
            return;
        }

        int a, b, k;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            k = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Arguments must be integers.");
            return;
        }

        if (a > b) {
            System.out.println("a must be less than or equal to b.");
            return;
        }

        long startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (isKReducible(i, k)) {
                sb.append(i).append(" ");
            }
        }

        System.out.println("K-reducible numbers: " + sb.toString());

        long endTime = System.nanoTime();
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
    }

    private static boolean isKReducible(int num, int k) {
        while (num != k && num >= 10) {
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            num = sum;
        }
        return num == k;
    }
}