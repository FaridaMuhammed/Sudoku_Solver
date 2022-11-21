/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sudokusolver;
import java.util.Scanner;

public class SudokuSolver {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter The Number of rows in your Sudouko");
        
        int rowNum = scan.nextInt();
        
//defining 2D array to hold Sudoku data 
        int[][] matrix = new int[rowNum][rowNum];
        System.out.println("Enter Matrix Data");
        
            for(int i=0; i<rowNum; i++)
            {
                for(int j=0; j<rowNum; j++)
                {
                    matrix[i][j] = scan.nextInt();
                }
            }
            
        Sudoku sudoku = new Sudoku(matrix, rowNum);
        
        System.out.println("Sudoku grid to solve");
        sudoku.display();
        
//we try resolution
        if(sudoku.solve())
        {
            System.out.println("Sudoku Grid solved!");
            sudoku.display();
        }else{
            System.out.println("Unsolveable");
        }
    }
}
