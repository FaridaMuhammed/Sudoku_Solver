/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudokusolver;

public class Sudoku {
    private int[][] board;
    public static final int EMPTY = 0; //empty cell
    public int SIZE;
    public int HALF_SIZE;
    
    public Sudoku(int[][] board, int n)
    {
        this.SIZE = n; //size of our Sudoku grids
        this.HALF_SIZE = (int)Math.sqrt(SIZE);
        this.board = new int[SIZE][SIZE];
        
        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE; j++)
            {
                this.board[i][j] = board[i][j];
            }
        }
    }//end of constructor 
    
    //we check if a possible number is already in a row 
    private boolean isInRow(int row, int number)
    {
        for(int i=0; i<SIZE; i++)
        {
            if(board[row][i] == number)
                return true;
        }
        
        return false;
        
    }//end of isInRow function
    
    //we check if a possible number is already in a column 
    private boolean isInCol(int col, int number)
    {
        for(int i=0; i<SIZE; i++)
        {
            if(board[i][col] == number)
                return true;
        }
        
        return false;
    }//end of isInCol function
    
    //we check if a possible number is in its inner box
    private boolean isInBox(int row, int col, int number)
    {
        int r = row - row % HALF_SIZE;
        int c = col - col % HALF_SIZE;
        
        for(int i=r; i<r+HALF_SIZE; i++)
        {
            for(int j=c; j<c+HALF_SIZE; j++)
            {
                if(board[i][j] == number)
                    return true;
            }
        }
        
        return false;
    }//end of isInBox function
    
    
    //combined method to check if a number possible to a row,col position is ok
    private boolean isOk(int row, int col, int number)
    {
        return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
    }//end of isOk function
    
    
    //Solve method. We'll use a recursive BackTracking algorithm.
    
    public boolean solve()
    {
        for(int row=0; row<SIZE; row++)
        {
            for(int col=0; col<SIZE; col++)
            {
                //we search an empty cell
                if(board[row][col] == EMPTY)
                {
                    //we try possible numbers
                    for(int number=1; number<=SIZE; number++)
                    {
                        if(isOk(row,col,number))
                        {
                            //number ok. it respects sudoku constraints
                            board[row][col] = number;
                            
                            if(solve())
                            {
                                //we start backtracking recursively
                                return true;
                            }else{//if not the solution, we empty the cell and we continue
                                board[row][col] = EMPTY;
                                
                            }
                        }
                    }
                    
                    return false; 
                }
            }
        }
        
        return true; //sudoku solved
    }//end of solve function
    
    public void display()
    {
        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE; j++)
            {
                System.out.print(""+board[i][j]);
            }
           System.out.print("\n");     
        }
        
        System.out.print("\n");
    
    }//end of display function
      
}






