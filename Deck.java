import java.util.Random;
import java.util.ArrayList;

public class Deck 
{
    
       //constants:
       final static int CARDS_IN_DECK = 52;
       //fields
       private ArrayList<Card> deck;
   
       /**
         Default constructor calls freshDeck method and creates
         a new deck of 52 cards
       */
       public Deck() 
       {
           freshDeck();
       }
   
       /**
        freshDeck method creates new deck of 52 cards
        in an arrayList 
       */
       public void freshDeck()
       {
           //initialize the deck array list
           deck = new ArrayList<Card>();
           
           
           
           
           
           
           
           
           //iterate from cards 2 to ace
           for (int rank=2;rank<=Card.ACE;rank++) 
           {
               deck.add(new Card(Card.CLUBS,rank));      
               deck.add(new Card(Card.DIAMONDS,rank));
               deck.add(new Card(Card.HEARTS,rank));
               deck.add(new Card(Card.SPADES,rank));  
               
               
               
               
               
                         
           }
       }
   
       /**
        dealCard method removes a card from the deck
        @return the card
        */
        
      public Card dealCard()
      {
         Card c = deck.remove(0);  //  remove it (returns removed object)
         return c;
      }
   
       /**
        cardsRemaining returns num of cards remaining 
        @return size of deck array list.
        */
       public int cardsRemaining()
      {  
         return deck.size();
      }
   
       /**
        isEmpty checks deck status as empty true or false
        @return true or false...
        */
      public boolean isEmpty() {
           return cardsRemaining() == 0;
       }
   
       /**
        shuffle method sorts cards randomly.
     */
      public void shuffle()
      {
         int randNum;
         Card temp;
         Random r = new Random();
         for (int i = 0; i < deck.size(); i++)
         {
            randNum = r.nextInt(deck.size());
            temp = deck.get(i);
            deck.set(i,deck.get(randNum));
            deck.set(randNum,temp);
         }      
      }
}