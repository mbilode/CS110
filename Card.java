
public class Card 
{
    //fields:
    private int rank;
    private char suit;
    
    //constants:
    //suit 
    final static char CLUBS = 'c';  //club
    final static char DIAMONDS = 'd';//diamond 
    final static char HEARTS = 'h';//heart
    final static char SPADES = 's';//spade

    //rank
    final static int JACK = 11;
    final static int QUEEN = 12;
    final static int KING = 13;
    final static int ACE = 14;
    
    

    /**
      Default constructor Card fields to null
     */
    public Card() 
    {
        rank = 0;
        suit = 'e';
    }

    /**
     Card contructor (second) accepts two param sets fields
      @param int r (rank)
      @param char s (suit)
     */
    public Card(char s, int r) 
    {
        setRank(r);
        setSuit(s);
    }

    /**
     The copy constructor creates a new card object 
     using rank and suit fields
     @param Card c 
     */
    public Card(Card c) 
    {
        setRank(c.getRank());
        setSuit(c.getSuit());
    }
    
    /**
      setRanks sets card rank
      @param r (rank)
     */
    public void setRank(int r) 
    {
        rank = r;
    }
    
    /**
      getRank returns card rank
      @return rank.
     */
    public int getRank() 
    {
        return rank;
    }

    /**
      setSuit sets card suit
      @param s The suit
     */
    public void setSuit(char s) 
    {
        suit = s;
    }
    
    

    /**
      getSuit returns card suit
      @return suit
     */
    public char getSuit() 
    {
        return suit;
    }
    
    /**
      The equals method checks if the cards are the same by checking ranks...
      @param Card other
      @return boolean same.
     */
    public boolean equals(Card card) 
    {
        int ranking = this.getRank();
        int ranking2 = card.getRank();
        boolean same;

        if (ranking == ranking2) 
        {
            same = true;
        } 
        
        else 
        {
            same = false;
        }

        return same;
    }

    /**
      greaterThan compares two cards
      @return true if card1 is greater than 
      card2
     */
    public boolean greaterThan(Card card2) 
    {
        int rank1 = this.getRank();
        int rank2 = card2.getRank();
        boolean greater;

        if (rank1 > rank2) 
        {
            greater = true;
        } 
        
        else 
        {
            greater = false;
        }

        return greater;
    }

    /**
      toString returns a string displaying card
      @return Card as a string.
     */
    public String toString() 
    {
        String suitStr="mistake";
        String fullStr;

        switch(suit) 
        {
            case CLUBS:
                suitStr = "Clubs";
                break;
            case DIAMONDS:
                suitStr = "Diamonds";
                break;
            case HEARTS:
                suitStr = "Hearts";
                break;
            case SPADES:
                suitStr = "Spades";
                break;
        }

        fullStr = rank + " " + suitStr;
        return fullStr;
    }

    /**
      imageFinder returns string
      of the card data. I use this 
      to find the image that goes with
      the card... 
      @return card.
     */
    public String imageFinder() 
    {  
        String faceStr;
        String fullName;
    
        switch(rank) 
        {
            case JACK:
                faceStr = "jack";
                break;
            case QUEEN:
                faceStr = "queen";
                break;
            case KING:
                faceStr = "king";
                break;
            case ACE:
                faceStr = "ace";
                break;
            default:
                faceStr = String.valueOf(rank);
                break;
        }

        fullName = faceStr + suit;
        return fullName;
    }

}