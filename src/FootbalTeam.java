import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Team team = readRecordsFromFile("players.txt");

            System.out.println("Chọn đội hình ra sân: (442 - 352 - 433)");

            int number = Integer.parseInt(scanner.nextLine());

            int defender = number / 100;
            int midfielder = (number - defender * 100) / 10;
            int forwarder = (int) number % 10;

            ArrayList<Player> fullTeam = team.buildTeam(defender, midfielder, forwarder);

            for (Player player : fullTeam) {
                System.out.println(player);
            }

            System.out.print("Do you want to see another option? Type Y or N ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Y")) {
                continue;
            } else if (input.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static Team readRecordsFromFile(String file) {

        Team teams = new Team();

        try (Scanner inputFile = new Scanner(Paths.get(file))) {

            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                String[] part = line.split(" - ");

                int number = Integer.parseInt(part[0]);
                String name = part[1];
                String position = part[2];

                if (position.equals("GK")) {
                    teams.addGK(name, position, number);
                }

                if (position.equals("DF")) {
                    teams.addDF(name, position, number);
                }

                if (position.equals("MF")) {
                    teams.addMF(name, position, number);
                }

                if (position.equals("FW")) {
                    teams.addFW(name, position, number);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return teams;
    }
}