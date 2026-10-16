import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter your city:");
        String city = scanner.nextLine();

        System.out.println("Your city is: " + city);
    }
}