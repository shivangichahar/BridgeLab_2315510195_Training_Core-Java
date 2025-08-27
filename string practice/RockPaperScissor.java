package String_file;
import java.util.*;

public class RockPaperScissor {
    private static final String[] CHOICES = {"rock", "paper", "scissors"};
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    
    private List<String> gameResults;
    private int userWins;
    private int computerWins;
    private int totalGames;
    
    public RockPaperScissor() {
        gameResults = new ArrayList<>();
        userWins = 0;
        computerWins = 0;
        totalGames = 0;
    }
    
    public String getComputerChoice() {
        return CHOICES[random.nextInt(3)];
    }
  
    public String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Tie";
        }
        
        if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (userChoice.equals("paper") && computerChoice.equals("rock")) ||
            (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            userWins++;
            return "User";
        } else {
            computerWins++;
            return "Computer";
        }
    }
    

    public String[][] calculateStats() {
        String[][] stats = new String[2][4];
        
        stats[0][0] = "Player";
        stats[0][1] = "Wins";
        stats[0][2] = "Win Percentage";
        stats[0][3] = "Average Wins";
        
        stats[1][0] = "User";
        stats[1][1] = String.valueOf(userWins);
        stats[1][2] = totalGames > 0 ? String.format("%.2f%%", (userWins * 100.0) / totalGames) : "0.00%";
        stats[1][3] = totalGames > 0 ? String.format("%.2f", (double) userWins / totalGames) : "0.00";
        
        return stats;
    }
    
    public void displayResults() {
        System.out.println("\n=== GAME RESULTS ===");
        System.out.printf("%-8s %-12s %-15s %-10s%n", "Game", "User Choice", "Computer Choice", "Winner");
        System.out.println("------------------------------------------------");
        
        for (int i = 0; i < gameResults.size(); i++) {
            System.out.printf("%-8d %s%n", (i + 1), gameResults.get(i));
        }
        
        System.out.println("\n=== STATISTICS ===");
        String[][] stats = calculateStats();
        
        System.out.printf("%-10s %-6s %-15s %-12s%n", "Player", "Wins", "Win Percentage", "Average Wins");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-10s %-6d %-15s %-12s%n", "User", userWins, 
            totalGames > 0 ? String.format("%.2f%%", (userWins * 100.0) / totalGames) : "0.00%",
            totalGames > 0 ? String.format("%.2f", (double) userWins / totalGames) : "0.00");
        System.out.printf("%-10s %-6d %-15s %-12s%n", "Computer", computerWins, 
            totalGames > 0 ? String.format("%.2f%%", (computerWins * 100.0) / totalGames) : "0.00%",
            totalGames > 0 ? String.format("%.2f", (double) computerWins / totalGames) : "0.00");
        System.out.printf("%-10s %-6d %-15s %-12s%n", "Ties", (totalGames - userWins - computerWins), 
            totalGames > 0 ? String.format("%.2f%%", ((totalGames - userWins - computerWins) * 100.0) / totalGames) : "0.00%",
            totalGames > 0 ? String.format("%.2f", (double) (totalGames - userWins - computerWins) / totalGames) : "0.00");
    }
    
    public static void main(String[] args) {
        RockPaperScissor game = new RockPaperScissor();
        
        System.out.println("Welcome to Rock-Paper-Scissors Game!");
        System.out.print("Enter the number of games you want to play: ");
        int numberOfGames = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("\nGame " + (i + 1) + ":");
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();
            
            if (!Arrays.asList(CHOICES).contains(userChoice)) {
                System.out.println("Invalid choice! Please enter rock, paper, or scissors.");
                i--; // retry this game
                continue;
            }
            
            String computerChoice = game.getComputerChoice();
            String winner = game.findWinner(userChoice, computerChoice);
            
            String gameResult = String.format("%-12s %-15s %-10s", userChoice, computerChoice, winner);
            game.gameResults.add(gameResult);
            game.totalGames++;
            
            System.out.println("Computer chose: " + computerChoice);
            System.out.println("Winner: " + winner);
        }
        
        game.displayResults();
        
        scanner.close();
    }
}