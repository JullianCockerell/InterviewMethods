/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;

/**
 *
 * @author julliancockerell
 */
public class jCard 
{
    private boolean available = true;
    protected int faceValue;
    protected suitState suit;
    
    public jCard(int c, suitState s)
    {
        faceValue = c;
        suit = s;
    }
    
    public suitState suit(){return suit;}
    public boolean isAvail() {return available;}
    public void makeUnavail() {available = false;}
    public void makeAvail() {available = true;}
}


