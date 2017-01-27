import java.util.Random;

public class deckManipulation {

  public static void main ( String[]args) {

    int[] deck = makeDeck();

    // deck = shuffle(deck);

    // deck = reverse(deck);

    boolean winner = fullHouse(deck);

    System.out.println("The final deck is:");

    for (int count = 0; count <= deck.length - 1; count ++) {
      System.out.println(deck[count]);
    }

  }

  public static int[] makeDeck() {

    Random rand = new Random();

    int[] deck = new int[10];

    int count = 0;

    System.out.println("The starting deck is:");

    while (count <= 9) {
      deck[count] = (rand.nextInt(13) + 1);

      System.out.println(deck[count]);

      count = count + 1;

    }

    System.out.println("The starting deck is finished.");

    return(deck);
  }

  public static int[] swap(int[] deck, int a, int b) {
    int temp;

    temp = deck[a];
    deck[a] = deck[b];
    deck[b] = temp;

    return(deck);
  }

  public static int[] shuffle(int[] deck) {
    int[] randomDeck = new int[deck.length];
    int[] finalDeck = new int[deck.length];

    boolean ready = false;

    Random rand = new Random();

    // Set up random deck
    for (int i = 0; i <= (deck.length - 1); i++) {
      boolean included = true;
      int value = 0;

      while (included) {
        included = false;

        value = rand.nextInt(deck.length) + 1;

        for (int count = 0; count <= (randomDeck.length - 1); count++) {
          if (finalDeck[count] == value) {
            included = true;
          }
        }
      }

      randomDeck[i] = value;

    }

    // Set up final deck
    for (int i = 0; i <= (deck.length - 1); i++) {
      finalDeck[i] = deck[randomDeck[i]];
    }

    return finalDeck;

  }

  public static int[] reverse(int[] deck) {
    int[] finalDeck = new int[deck.length];
    int count = 0;

    for (int i = (deck.length -1); i >= 0; i--) {
      finalDeck[count] = deck[i];

      count = count + 1;
    }

    return finalDeck;
  }

  public static boolean fullHouse(int[] deck) {
    boolean three, two;
    three = two = false;

    for (int i = 0; i <= (deck.length - 1); i++) {
      int amount = 0;
      for (int count = 0; count <= (deck.length - 1); count++) {
        if (deck[i] == deck[count]) {
          amount = amount + 1; //total number of cards of that value
        }
      }

      if (amount >= 3) {
        three = true;
      } else if (amount == 2) {
        two = true;
      }      
    }

    if (three && two) {
      System.out.println("There is a full house");
      return true;
    }

    System.out.println("There is not a full house");
    return false;
  }

}
