import java.util.Scanner;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // File outFile = new File("nguyento.txt");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("X") || input.equalsIgnoreCase("Q")) {
                break;
            }

            if (!isNumeric(input)) {
                System.out.println(input + " không phải là số");
                continue;
            }

            int number = Integer.parseInt(input);

            if (number == 0 || number == 1) {
                System.out.println(number + " không phải là số nguyên tố");
            } else if (isPrimeNumber(number)) {
                System.out.println(number + " là số nguyên tố");
            } else {
                System.out.println(number + " không phải là số nguyên tố");
            }

        }
    }

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // public static void writeToFile(File) {

    // }
}
