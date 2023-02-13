package cardgame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;

public class DeckRunner extends JFrame {

    public static Deck d = new Deck();
    public static Card a, b;
    public static int aP = 0, bP = 0;
    public static int turn = 0;

    public static JPanel p = new JPanel();
    
    public static JLabel aLabel, bLabel;

    public static JLabel scoreLabel;
 
    public DeckRunner() {
        
        super("DeckRunner");
 
        getContentPane().setBackground(Color.WHITE);
        setSize(1400, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.add(p);
        JButton playButton = new JButton("Play!");
        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Card[] x = d.deal(2);

                if (x != null) {
                    a = x[0]; b = x[1];
                    setPoints();
                    repaint();
                }

                if (x == null) {
                    if (aP > bP) {
                        scoreLabel.setText("<html><font color = red>You Won!</font></html>");
                    }
                    if (bP > aP) {
                        scoreLabel.setText("<html><font color = blue>Computer Won!</font></html>");
                    }
                    if (aP == bP) {
                        scoreLabel.setText("<html><font color = #00ffff>Tie Game!</font></html>");
                    }
                }
            }
        });


        JButton shuffleButton = new JButton("Shuffle!");
        shuffleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                d.shuffle();
            }
        });


        aLabel = new JLabel();
        aLabel.setSize(40, 100);
        bLabel = new JLabel();

        scoreLabel = new JLabel("", JLabel.CENTER);

        BorderLayout x = new BorderLayout();
        p.setLayout(x);
        
        p.add(playButton, BorderLayout.NORTH);
        p.add(shuffleButton, BorderLayout.SOUTH);
        p.add(aLabel, BorderLayout.WEST);
        p.add(bLabel, BorderLayout.EAST);
        p.add(scoreLabel, BorderLayout.CENTER);

    }

    public void setPoints() {

        turn++;

        if (a.getFaceValue() > b.getFaceValue()) {
            aP++;
        }
        else if(a.getFaceValue() < b.getFaceValue()) {
            bP++;
        }

    }
 
    void drawRectangles(Graphics g) {

        if (a == null || b == null) return;
        // Rectangle r = new Rectangle(50, 100, 100, 160);
        // Graphics2D g2d = (Graphics2D) g;
        // g2d.draw(r);
        // g2d.drawString(a.toString(), 55, 120);

        // Rectangle e = new Rectangle(200, 100, 100, 160);
        // g2d.draw(e);
        // g2d.drawString(b.toString(), 205, 120);
        // g2d.drawString("Point A: " + aP, 55, 300);
        // g2d.drawString("Point B: " + bP, 205, 300);

        String fileA = "imgs/" + a.getFileName();
        String fileB = "imgs/" + b.getFileName();

        ImageIcon aIcon = new ImageIcon(getClass().getResource(fileA));
        ImageIcon bIcon = new ImageIcon(getClass().getResource(fileB));

        aLabel.setIcon(aIcon);
        bLabel.setIcon(bIcon);

        String scoreString = "<html>"
                           +    "<font color = red> You: " + aP + " </font><br>"
                           +    "<font color =#0000ff> Computer: " + bP + " </font>"
                           + "</html>";

        scoreLabel.setText(scoreString);

    }
 
    public void paint(Graphics g) {

        drawRectangles(g);
        super.paint(g);

    }
 
    public static void main(String[] args) throws Exception {

        d.shuffle();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DeckRunner().setVisible(true);
            }
        });

    }
}
