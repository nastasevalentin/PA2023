public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main lab1 = new Main();
        lab1.exercise();
    }

    void exercise(){
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000);
        n = n * 3;
        int decimal = Integer.parseInt("10101",2);
        n = n + decimal;
        decimal = Integer.parseInt("FF", 16);
        n = n + decimal;
        n = n * 6;

        while (n > 9) {
            int sum = 0;
            while (n > 0) {
                sum = sum + (n % 10);
                n = n / 10;
            }
            n = sum;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}
