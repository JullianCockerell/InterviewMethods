/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods.mineSweeper;

/**
 *
 * @author julliancockerell
 */
public class mineCell 
{
    private int row;
    private int column;
    private boolean isBomb;
    private int number;
    private boolean isExposed = false;
    private boolean isGuess = false;
    
    public mineCell(int r, int c)
    {
        isBomb = false;
        number = 0;
        row = r;
        column = c;
    }
    
    public void setRowAndCol(int r, int c)
    {
        row = r;
        column = c;
    }
    
    public void setBomb()
    {
        isBomb = true;
        number = -1;  
    }
    
    public int getRow(){return row;}
    public int getCol(){return column;}
    public boolean isBomb(){return isBomb;}
    public boolean isBlank(){return number == 0;}
    public boolean isExposed(){return isExposed;}
    public boolean isGuess(){return isGuess;}
    
    public boolean flip()
    {
        isExposed = true;
        return !isBomb;
    }
    
    public boolean toggleGuess()
    {
        if(!isExposed)
        {
            isGuess = !isGuess;
        }
        return isGuess;
    }
    
    public String getUnder()
    {
        if(isBomb){return "*  ";}
        else if(number > 0){return Integer.toString(number) + "  ";}
        else {return "   ";}
    }
    
    @Override
    public String toString()
    {
        return getUnder();
    }
    
    public String getSurface()
    {
        if(isExposed){return getUnder();}
        else if(isGuess){return "B  ";}
        else {return "?  ";}
    }
    
    public void incrementNum()
    {
        number++;
    }
    
         
}
