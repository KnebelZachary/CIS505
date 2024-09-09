package Module_2.SportsTeamApp;
import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueOption;

        do {

            System.out.print("Enter the team name: ");
            String teamName = scanner.nextLine();

            Team team = new Team(teamName);


            System.out.print("Enter the player names (comma separated): ");
            String playerNames = scanner.nextLine();
            String[] playerArray = playerNames.split(",");

            for (String player : playerArray) {
                team.addPlayer(player.trim());
            }

            

            System.out.println("Number of players in team " + team.getPlayerCount());
            System.out.print("Players on team: ");
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(team.getPlayers()[i] + " ");
            }

            System.out.println();

          
            System.out.print("Do you want to enter another team? (yes/no): ");
            continueOption = scanner.nextLine();

        } while (continueOption.equalsIgnoreCase("yes"));

        scanner.close();
    }
}

