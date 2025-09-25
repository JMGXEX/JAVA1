import java.util.Scanner;
public class UserScanner {
    public class UseSanner {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter youer name: ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name + "!");
            int old = scanner.nextInt();
            System.out.println("당신의 나이는 : "+old);
            scanner.close();
        }
    }

}
