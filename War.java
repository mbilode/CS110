public class War 
{
    //fields:
    MyHand playerHand;
    MyHand playerPile;
    MyHand compHand;
    MyHand compPile;
    private Deck deck;
    private int playerCardCount;
    private int computerCardCount;

    /**
      Constructor creates two players hands
    */
    public War() 
    {
        deck = new Deck(); //create deck of 52 cards 
        playerHand = new MyHand(); //initialize player hand
        compHand = new MyHand(); //initialize computer hand
        deal(); //deal to each hand
        
        playerPile = new MyHand(); //initialize player pile
        compPile = new MyHand(); //initialize computer pile
    }
    /**
      deal method deals cards to each player.
    */
    public void deal() 
    {
       
        deck.shuffle(); //sort the deck randomly
        
        int i = 0; //initialize int i.
        
        while(!deck.isEmpty()) //iterate until deck has no cards left.
        {
            if (i % 2 == 0) //for even cards...
            {
                playerHand.push(deck.dealCard()); //set card to players hand
                
            } 
            
            else 
            {
                compHand.push(deck.dealCard()); //set odd cards to computers hand
                            
            }

            i++;//iterate 
        }
    }

    /**
      move gets the top card from a pile 
      @return card 
    */
    public Card move(MyHand player) 
    {
        Card card = (Card)player.pop();
        return card;
    }
}