import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class PrimeNumber {
    private static String outPut;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File outFile = new File("nguyento.txt");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("X") || input.equalsIgnoreCase("Q")) {
                break;
            }

            if (!isNumeric(input)) {
                String outPut = input + " không phải là số";
                System.out.println(outPut);
                continue;
            }

            int number = Integer.parseInt(input);

            if (number == 0 || number == 1) {
                String outPut = number + " không phải là số nguyên tố";
                writeToFile(outPut, outFile);
                System.out.println(outPut);
            } else if (isPrimeNumber(number)) {
                String outPut = number + " là số nguyên tố";
                writeToFile(outPut, outFile);
                System.out.println(outPut);
            } else {
                outPut = number + " không phải là số nguyên tố";
                writeToFile(outPut, outFile);
                System.out.println(outPut);
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

    private static void writeToFile(String data, File outFile) {
        File file = new File(outFile.toString());
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
