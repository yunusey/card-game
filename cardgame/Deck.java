package cardgame;

public class Deck {
    private Card[] deck;
    private int numCards;

    public Deck() {
        initDeck();
    }

    // Initializes the deck of cards with appropriate suite and value
    public void initDeck() {
        deck = new Card[52];
        numCards = 52;
        for(int i = 0; i < 13; i++){
            deck[i] = new Card("clubs", i + 1);
        }
        for(int i = 0; i < 13; i++){
            deck[13 + i] = new Card("diamonds", i + 1);
        }
        for(int i = 0; i < 13; i++){
            deck[26 + i] = new Card("hearts", i + 1);
        }
        for(int i = 0; i < 13; i++){
            deck[39 + i] = new Card("spades", i + 1);
        }
    }

    // Randomizes the current deck. Think of various algorithms to do this.
    // Pefect shuffle?
    public void shuffle() {
        for(int i = 0; i < numCards - 1; i++){
            int j = (int)(Math.random() * (numCards - i) + i);
            swap(i, j);
        }
        System.out.println(deck[numCards - 1]);
    }

    private void swap(int i, int j){
        Card c = deck[i];
        deck[i] = deck[j];
        deck[j] = c;
    }

    // will deal numCards number of cards from the deck and update deck accordingly
    public Card[] deal(int numCards) {
        if (this.numCards == 0) {
            return null;
        }
        Card[] cards = new Card[numCards];
        for(int i = this.numCards - numCards; i < this.numCards; i++){
            cards[i - (this.numCards - numCards)] = this.deck[i];
            this.deck[i] = null;
        }
        this.numCards -= numCards;
        return cards;
    }

    // Should display the current deck using Card's to String method
    public void displayDeck() {
        for(int i = 0; i < numCards; i++){
            System.out.println(deck[i]);
        }
    }

}