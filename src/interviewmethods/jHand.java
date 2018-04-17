/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;
import java.util.ArrayList;
/**
 *
 * @author julliancockerell
 */
public class jHand 
{
    protected ArrayList<jCard> cards = new ArrayList<jCard>();
    public int score()
    {
        int score = 0;
        for(jCard card : cards)
        {
            score += card.faceValue;
        }
        return score;
    }
    public void addCard(jCard add)
    {
        cards.add(add);
    }
    
    public void addCards(jCard[] add)
    {
        for(jCard card : add)
        {
            cards.add(card);
        }
    }
}
