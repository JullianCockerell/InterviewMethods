/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods.mineSweeper;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author JullianCockerell
 */
public class mineBoard 
{
    private int nRows;
    private int nColumns;
    private int nBombs;
    private mineCell[][] cells;
    private mineCell[] bombs;
    private int numUnexposedLeft;
    
    public mineBoard(int r, int c, int b)
    {
        nRows = r;
        nColumns = c;
        nBombs = b;
        initializeBoard();
        shuffleBoard();
        setNumberedCells();
        numUnexposedLeft = (r*c) - b;
        printBoard(false);
        
    }
    
    public void playGame()
    {
        Scanner reader = new Scanner(System.in);
        int n, m;
        while(true)
        {
            System.out.println("Move: (row, col)");
            n = reader.nextInt();
            m = reader.nextInt();
            System.out.println("");
            flipPiece(n, m);
            if(numUnexposedLeft == 0){youWin();}
            printBoard(false);
        }

    }
    
    private void initializeBoard()
    {
        cells = new mineCell[nRows][nColumns];
        bombs = new mineCell[nBombs];
        for(int r = 0; r < nRows; r++)
        {
            for(int c = 0; c < nColumns; c++)
            {
                cells[r][c] = new mineCell(r, c);
            }
        }
        int r, c;
        for(int i = 0; i < nBombs; i++)
        {
            r = i/nColumns;
            c = (i - (r*nColumns)) % nColumns;
            bombs[i] = cells[r][c];
            bombs[i].setBomb();
        }
    }
    
    private boolean flipPiece(int r, int c)
    {
        mineCell piece = cells[r][c];
        numUnexposedLeft--;
        if(!piece.flip()){printBoard(true); System.out.println("BOOM!"); System.exit(0);}
        else if(piece.isBlank())
        {
            expandBlank(piece);
        }
        else
        {
            return true;
        }
        return false;
    }

    private void shuffleBoard()
    {
        int nCells = nRows * nColumns;
        Random random = new Random();
        
        for (int index1 = 0; index1 < nCells; index1++) 
        {
            int index2 = index1 + random.nextInt(nCells - index1);
            if (index1 != index2) 
            {
		int row1 = index1 / nColumns;
		int column1 = (index1 - row1 * nColumns) % nColumns;
		mineCell cell1 = cells[row1][column1];
				
		int row2 = index2 / nColumns;
		int column2 = (index2 - row2 * nColumns) % nColumns;
		mineCell cell2 = cells[row2][column2];
				
		cells[row1][column1] = cell2;
		cell2.setRowAndCol(row1, column1);
		cells[row2][column2] = cell1;
		cell1.setRowAndCol(row2, column2);				
            }
        }
    }
    private boolean inBounds(int r, int c)
    {
        return r >= 0 && r < nRows && c >= 0 && c < nColumns;
    }
    
    private void setNumberedCells()
    {
        int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1},{ 0, -1},{ 0, 1},{ 1, -1}, { 1, 0}, { 1, 1}};
	for (mineCell bomb : bombs) 
        {
            int row = bomb.getRow();
            int col = bomb.getCol();
            for (int[] delta : deltas) 
            {
		int r = row + delta[0];
		int c = col + delta[1];
		if (inBounds(r, c)) 
                {
                    cells[r][c].incrementNum();
		}
            }
	}
    }
    
    private void youWin()
    {
        System.out.println("   /\\_/\\   ");
        System.out.println("  / o o \\  ");
        System.out.println(" (   \"   ) ");
        System.out.println("  \\~(*)~/  ");
        System.out.println("   // \\\\   ");
        System.out.println("   YOU WIN!!!  ");
        System.exit(0);
    }
    public void printBoard(boolean showUnderside) 
    {
        System.out.println();
        System.out.println(numUnexposedLeft);
	System.out.print("    ");
	for (int i = 0; i < nColumns; i++) 
        {
            System.out.print(i + " ");
            if(i < 10){System.out.print(" ");}
	}
	System.out.println();
	for (int i = 0; i < nColumns; i++) 
        {
            System.out.print("---");
	}		
	System.out.println();
	for (int r = 0; r < nRows; r++) 
        {
            if(r > 9)
            {
                System.out.print(r + "| ");
            }
            else
            {
                System.out.print(" "+ r + "| ");
            }
            for (int c = 0; c < nColumns; c++) 
            {
		if (showUnderside) 
                {
                    System.out.print(cells[r][c].getUnder());
		} else 
                {
                    System.out.print(cells[r][c].getSurface());
		}
            }
            System.out.println();
	}
    }
    
    private void expandBlank(mineCell cell) 
    {
        int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1},{ 0, -1},{ 0, 1},{ 1, -1}, { 1, 0}, { 1, 1}};		
        System.out.println("Entered");
	Queue<mineCell> toExplore = new LinkedList<mineCell>();
	toExplore.add(cell);
		
	while (!toExplore.isEmpty()) 
        {
            mineCell current = toExplore.remove();
			
            for (int[] delta : deltas) 
            {
		int r = current.getRow() + delta[0];
		int c = current.getCol() + delta[1];
				
		if (inBounds(r, c)) 
                {
                    mineCell neighbor = cells[r][c];
                    if (neighbor.isBlank() && !neighbor.isExposed()) 
                    {
                        toExplore.add(neighbor);
                        neighbor.flip();
                        numUnexposedLeft--;
                    }
		}
            }			
	}
    }
    
}
