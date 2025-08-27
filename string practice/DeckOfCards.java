
package String_file;import java.util.Scanner;

class DeckOfCards {

    // Method to initialize deck
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                          "Jack", "Queen", "King", "Ace"};
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Method to shuffle deck
    public static void shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = i + (int) (Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    // Method to distribute cards
    public static String[][] distributeCards(String[] deck, int players, int cardsEach) {
        if (players * cardsEach > deck.length) {
            System.out.println("Not enough cards to distribute!");
            return null;
        }

        String[][] playerCards = new String[players][cardsEach];
        int index = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsEach; j++) {
                playerCards[i][j] = deck[index++];
            }
        }
        return playerCards;
    }

    // Method to print player cards
    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ": ");
            for (String card : players[i]) {
                System.out.println("  " + card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Initialize deck
        String[] deck = initializeDeck();

        // Step 2: Shuffle
        shuffleDeck(deck);

        // Input number of players and cards
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsEach = sc.nextInt();

        // Step 3: Distribute
        String[][] distributed = distributeCards(deck, players, cardsEach);

        // Step 4: Print result
        if (distributed != null) {
            printPlayers(distributed);
        }
    }
}

