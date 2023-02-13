package cardgame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CardGame extends JFrame {

  private JButton drawButton;
  private JPanel cardContainer;
  private ArrayList<Integer> deck;

  public CardGame() {
    setTitle("Card Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(new Dimension(400, 400));

    drawButton = new JButton("Draw a card");
    cardContainer = new JPanel();

    add(drawButton, BorderLayout.NORTH);
    add(cardContainer, BorderLayout.CENTER);

    drawButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (deck.isEmpty()) {
          JOptionPane.showMessageDialog(CardGame.this, "No more cards in the deck");
          return;
        }

        int card = deck.remove(0);
        cardContainer.add(new JButton(String.valueOf(card)));
        CardGame.this.revalidate();
        CardGame.this.repaint();
      }
    });

    deck = new ArrayList<>();
    for (int i = 1; i <= 52; i++) {
      deck.add(i);
    }
    Collections.shuffle(deck);
  }

  public static void main(String[] args) {
    CardGame game = new CardGame();
    game.setVisible(true);
  }
}