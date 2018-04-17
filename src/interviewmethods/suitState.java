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
public enum suitState 
{
    Club (0), Diamond (1), Heart (2), Spade (3);
    private int value;
    private suitState(int v) {value = v;}
    public int getValue() {return value;}
    public static suitState getSuitFromVal(int v)
    {
        switch(v)
        {
            case 0: return Club;
            case 1: return Diamond; 
            case 2: return Heart;
            case 3: return Spade;
        }
        return null;
    }
}
