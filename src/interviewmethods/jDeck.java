/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author julliancockerell
 */
public class jDeck 
{
    private ArrayList<jCard> cards = new ArrayList<jCard>();
    private int dealtIndex = 0;
    
    public void setStanDeckOfCards(ArrayList<jCard> deck)
    {
        for(suitState state : suitState.values())
        {
            for(int i = 1; i < 14; i++)
            {
                jCard insert = new jCard(i, state);
                deck.add(insert);
            }
        }
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }
    
    public int remainingCards()
    {
        return cards.size() - dealtIndex;
    }
    
    public jCard[] dealHand(int n)
    {
        jCard[] hand = new jCard[n];
        for(int i = 0; i < n; i++)
        {
            hand[i] = dealCard();
        }
        return hand;
    }
    
    public jCard dealCard()
    {
        for(jCard card : cards)
        {
            if(card.isAvail())
            {
                card.makeUnavail();
                return card;
            }
        }
        System.out.println("All cards have been dealt!");
        return null;     
    }
    
    public ArrayList<jCard> getCards()
    {
        return cards;
    }
}

