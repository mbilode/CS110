import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame {
    /* -------------------- *
     * FIELDS
     * -------------------- */
    private War war;
    private boolean win;
    private int pCardCount;
    private int cCardCount;

    /* -------------------- *
     * FRAME PARTS
     * -------------------- */
    JButton b;
    JLabel cardB1;
    JLabel cardB2;
    JLabel playerC;
    JLabel compC;
    JLabel pCount;
    JLabel pWin;
    JLabel cCount;
    JPanel leftContainer;
    JPanel rightContainer;
    JPanel center;

    ImageIcon playerFront;
    ImageIcon compFront;
    ImageIcon back;


    /**
     * This constructor creates the War GUI
     */
    public WarGUI(String s) {
        super(s);
        war = new War();
        win = false;

        /* -------------------- *
         * ADD BUTTON
         * -------------------- */
        setLayout(new BorderLayout());
        setBackground(new Color(33, 115, 40));
        b = new JButton("Play");
        b.setFont(new Font("sansserif", Font.BOLD, 32));
        
        b.setPreferredSize(new Dimension(20, 100));
        
        b.setForeground(Color.GREEN);
        b.addActionListener(new ButtonListener());
        add(b, BorderLayout.SOUTH);

        /* -------------------- *
         * ADD CARD COUNT
         * -------------------- */
        leftContainer = new JPanel();
        rightContainer = new JPanel();
        
        pCardCount = war.playerHand.getCount() + war.playerPile.getCount();
        cCardCount = war.compHand.getCount() + war.compPile.getCount();

        pCount = new JLabel(String.valueOf(pCardCount));
        pCount.setFont(new Font("sansserif", Font.BOLD, 32));
        cCount = new JLabel(String.valueOf(cCardCount));
        cCount.setFont(new Font("sansserif", Font.BOLD, 32));
        
        pCount.setForeground(Color.BLUE);
        cCount.setForeground(Color.BLUE);

        /* -------------------- *
         * ADD CARDS
         * -------------------- */
        playerFront = new ImageIcon("PLACEHOLDER"); 
        compFront = new ImageIcon("PLACEHOLDER");
        back = new ImageIcon("cardPics/back.jpg");
    
        cardB1 = new JLabel(back);
        cardB2 = new JLabel(back);

        leftContainer.add(cardB1);
        leftContainer.add(pCount);

        rightContainer.add(cCount);
        rightContainer.add(cardB2);


        add(leftContainer, BorderLayout.WEST);
        add(rightContainer, BorderLayout.EAST);

        center = new JPanel();


        playerC = new JLabel(playerFront);
        compC = new JLabel(compFront);
        center.add(playerC);
        center.add(compC);
        
        add(center, BorderLayout.CENTER);
    }

    

    public class ButtonListener implements ActionListener { 
        //FIELDS
        Card pMove;
        Card cMove;
        String winner;
        MyHand holdingTank;
        
        /**
         * is Called on button press
         */
        public void actionPerformed(ActionEvent e) {
            /* -------------------- *
             * FIRST CHECK TO SEE IF DECK IS EMPTY
             * -------------------- */
            playerHasCards();
            computerHasCards();
            
            if (!win) {
                //ADDITIONAL VARS
                pMove = getTopCard(war.playerHand);
                cMove = getTopCard(war.compHand);
                
                //CALC CARD COUNTS
                updateCardCounts();

                //Show Cards on screen
                playerFront = new ImageIcon("cardPics/" + pMove.imageFinder() + ".jpg");
                compFront = new ImageIcon("cardPics/" + cMove.imageFinder() + ".jpg");
    
                playerC.setIcon(playerFront);
                compC.setIcon(compFront);

                System.out.println("Player: " + pMove + "\n" + "Computer: " + cMove);
                winner = determineWinner(pMove, cMove);
                addWinnings(pMove, winner);
                addWinnings(cMove, winner);

                updateCardCounts();
                
            } else {
                b.setEnabled(false);
            }
        }

        /**
         * updateCardCounts updates the card count on the sides. 
         */
        public void updateCardCounts() {
            pCardCount = war.playerHand.getCount() + war.playerPile.getCount();
            cCardCount = war.compHand.getCount() + war.compPile.getCount();
                
            pCount.setText(String.valueOf(pCardCount));
            cCount.setText(String.valueOf(cCardCount));
        }

        /**
         * Tests to see if the player has cards remaining
         */
        public void playerHasCards() {
            System.out.print("Checking if player has cards...       ");
            if (war.playerHand.isEmpty()) {
                System.out.println("Player hand is empty.");
                if (war.playerPile.isEmpty()) {
                    //Player has no more cards
                    System.out.println("Player is out of cards.\nComputer Wins Match");
                    win = true;
                    b.setEnabled(false);
                } else {
                    //player has cards in pile, 
                    //put them in hand
                    System.out.println("Transferring player cards from pile to hand");
                    while(!war.playerPile.isEmpty()) {
                        war.playerHand.push(new Card(getTopCard(war.playerPile)));
                    }
                }
            } else {
                System.out.println("  OK.");
            }
        }

        /**
         * Tests to see if the computer has cards remaining
         */
        public void computerHasCards() {
            System.out.print("Checking if computer has cards...     ");
            if (war.compHand.isEmpty()) {
                System.out.println("Computer hand is empty.");
                if (war.compPile.isEmpty()) {
                    //Copmuter is out of cards
                    System.out.println("Computer is out of cards.\nPlayer Wins Match!");
                    win = true;
                    b.setEnabled(false);
                } else { 
                    //comp has cards in pile,
                    //put them back in hand    
                    System.out.println("Transferring computer cards from pile to hand");
                    while(!war.compPile.isEmpty()) {
                        war.compHand.push(new Card(getTopCard(war.compPile)));
                    }
                }
            } else {
                System.out.println("Alright..");
            }
        }

        /**
         * returns the top card pulled by the move() method.
         * @return The top card
         * @param player The hand to remove the card from.
         */
        public Card getTopCard(MyHand player) {
            return war.move(player);
        }

        /**
         * Adds cards the player won to the the pile.
         * @param c The card to add
         * @param h The string winner
         */
        public void addWinnings(Card c, String h) {
            if (h.compareTo("Player") == 0) {
                //Player has won. add cards to pile
                war.playerPile.push(new Card(c));

                System.out.println("Adding " + war.playerPile.peek() + " to player pile");
            } else if (h.compareTo("Computer") == 0) {
                //Computer has won. add cards to pile
                war.compPile.push(new Card(c));

                System.out.println("Adding " + war.compPile.peek() + " to computer pile");
            }
        }

        /**
         * This method is responsible for determining who won the round.
         * @return The string representation of the winner,
         * used in addWinnings
         */
        public String determineWinner(Card p, Card c) {
            String w = "";
            if (p.equals(c)) {
                warBattle(p, c);
            } else if (p.greaterThan(c)) {
                //Player Wins
                //Add both cards to 'Pile'
                System.out.println("Player wins round");
                
                
                w = "Player";
            } 
            
            else 
            {
                //Comp wins
                //Add both cards to 'Pile'
                System.out.println("Computer wins round");
                
                w = "Computer";
            }

            return w;
        }

        /**
         * warBattle is used when a war situation occurs
         * @param p Players Card
         * @param c Computers Card
         */
        public void warBattle(Card p, Card c) {
            System.out.println("War!");
            holdingTank = new MyHand();

            Card pPlay = new Card();
            Card cPlay = new Card();

            holdingTank.push(p);
            holdingTank.push(c);

            for (int i = 0; i <= 2; i++) {
                playerHasCards();
                if (!win) {
                    holdingTank.push(getTopCard(war.playerHand));
                }

                computerHasCards();
                if (!win) {
                    holdingTank.push(getTopCard(war.compHand));
                }
            }
            
            playerHasCards();
            if (!win) {
                pPlay = new Card(getTopCard(war.playerHand));

            }

            computerHasCards();
            if (!win) {
                cPlay = new Card(getTopCard(war.compHand));

            }
            
            System.out.println("Player: " + pPlay + "\n" + "Computer: " + cPlay);
            //Show Cards on screen
            playerFront = new ImageIcon("cardPics/" + pPlay.imageFinder() + ".jpg");
            compFront = new ImageIcon("cardPics/" + cPlay.imageFinder() + ".jpg");

            winner = determineWinner(pPlay, cPlay);
            addWinnings(pPlay, winner);
            addWinnings(cPlay, winner);

            while(!holdingTank.isEmpty()) {
                addWinnings((Card)holdingTank.pop(), winner);
            }
        }
    }
}