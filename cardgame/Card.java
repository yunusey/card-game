package cardgame;

/*
* Make sure to save as UTF-8 by adding the followingcomment to all documents:
* //♠
* Press save, and when the dialog pops up, press save as UTF-8.
* You need this for documents that use or reference other documents that use special unicode characters.
*/
public class Card {
    // Data Memebers
    private String suit;
    private int faceValue;

    public Card() {
        suit = "Joker";
        faceValue = 0;
    }

    // overloaded
    public Card(String s, int v) {
        suit = s;
        faceValue = v;
    }

    // getters
    public int getFaceValue() {
        return faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public boolean equals(Card c) {
        return (this.faceValue == c.getFaceValue()) &&
                (this.suit.equals(c.getSuit()));
    }

    public boolean sameSuit(Card c) {
        return (this.suit.equals(c.getSuit()));
    }

    public boolean sameValue(Card c) {
        return (this.faceValue == c.getFaceValue());
    }

    public String getFileName() {
        String s = "";
        switch (faceValue) {
            case 1:
                s += "ace";
                break;
            case 11:
                s += "jack";
                break;
            case 12:
                s += "queen";
                break;
            case 13:
                s += "king";
                break;
            default:
                s += faceValue;
                break;
        }
        s += "_of_";
        s += suit;
        s += ".png";
        return s;
    }

    public String toString() {
        String fv = "";
        switch (faceValue) {
            case 11:
                fv += " J";
                break;
            case 12:
                fv += " Q";
                break;
            case 13:
                fv += " K";
                break;
            case 1:
                fv += " A";
                break;
            case 10:
                fv += "10";
                break;
            default:
                fv += " " + faceValue + "";
        }
        fv = fv + " ";
        // ♠
        if (suit.equals("clubs")) {
            fv += "♣";
        } else if (suit.equals("diamonds")) {
            fv += "◆";
        } else if (suit.equals("hearts")) {
            fv += "♥";
        } else if (suit.equals("spades")) {
            fv += "♠";
        } else {
            fv += null;
        }
        return fv;
    }
}